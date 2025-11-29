package com.wts.where_to_watch.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/movie")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getMovies(
        @RequestParam(required = false) UUID id,
        @RequestParam(required = false) String titulo,
        @RequestParam(required = false) String genero,
        @RequestParam(required = false) Integer anio,
        @RequestParam(required = false) String servicio_streaming){

        if(titulo != null){
            return movieService.getMoviesFromName(titulo);
        }
        else if(genero != null) {
            return movieService.getMoviesFromGenero(genero);
        }
        else if (servicio_streaming != null) {
            return movieService.getMoviesFromServicio(servicio_streaming);
        }
        else {
            return movieService.getMovies();
        }
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        Movie createdMovie = movieService.addMovie(movie);
        return new ResponseEntity<>(createdMovie, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie){
        Movie resultMovie = movieService.updateMovie(movie);
        if (resultMovie != null) {
            return  new ResponseEntity<>(resultMovie, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{titulo}")
    public ResponseEntity<String> deleteMovie(@PathVariable String titulo){
        movieService.deleteMovie(titulo);
        return new ResponseEntity<>("Pelicula borrada exitosamente", HttpStatus.OK);
    }
}
