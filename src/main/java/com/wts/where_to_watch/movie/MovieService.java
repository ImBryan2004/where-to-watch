package com.wts.where_to_watch.movie;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies(){
    return movieRepository.findAll();

    }

    public List<Movie> getMoviesFromName(String searchText){
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getTitulo().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Movie> getMoviesFromGenero(String genero){
        return movieRepository.findAll().stream()
                .filter(movie -> genero.equals(movie.getGenero()))
                .collect(Collectors.toList());
    }

    public List<Movie> getMoviesFromServicio(String servicio_streaming){
        return movieRepository.findAll().stream()
                .filter(movie -> servicio_streaming.equals(movie.getServicio_streaming()))
                .collect(Collectors.toList());
    }

    public Movie addMovie(Movie movie){
        movieRepository.save(movie);
        return movie;
    }

    public Movie updateMovie (Movie updatedMovie){
        Optional<Movie> existingMovie = movieRepository.findById(updatedMovie.getId());

        if (existingMovie.isPresent()){
            Movie movieToUpdate = existingMovie.get();
            movieToUpdate.setTitulo(updatedMovie.getTitulo());
            movieToUpdate.setGenero(updatedMovie.getGenero());
            movieToUpdate.setAnio(updatedMovie.getAnio());
            movieToUpdate.setServicio_streaming(updatedMovie.getServicio_streaming());

            movieRepository.save(movieToUpdate);
            return movieToUpdate;
        }
        return null;
    }

    @Transactional
    public void  deleteMovie(String titulo){
        movieRepository.deleteByTitulo(titulo);
    }

}
