package com.wts.where_to_watch.movie;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "movie_info")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "UUID DEFAULT gen_random_uuid()")
    private UUID id;

    private String titulo;

    private String genero;

    private Integer anio;

    private String servicio_streaming;

    private String descripcion;

    // Constructor vacío (OBLIGATORIO para JPA)
    public Movie() {
    }

    // Constructor completo
    public Movie(UUID id, String titulo, String genero, Integer anio, String servicioStreaming) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.anio = anio;
        this.servicio_streaming = servicio_streaming;
        this.descripcion = descripcion;
    }

    // Constructor sin ID (para cuando PostgreSQL lo genera automáticamente)
    public Movie(String titulo, String genero, Integer anio, String servicioStreaming) {
        this.titulo = titulo;
        this.genero = genero;
        this.anio = anio;
        this.servicio_streaming = servicio_streaming;
        this.descripcion = descripcion;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnio() {
        return anio;
    }


    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getServicio_streaming() {
        return servicio_streaming;
    }

    public void setServicio_streaming(String servicio_streaming) {
        this.servicio_streaming = servicio_streaming;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = this.descripcion;
    }

}
