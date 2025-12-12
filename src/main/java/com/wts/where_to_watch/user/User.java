package com.wts.where_to_watch.user;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "UUID DEFAULT gen_random_uuid()")
    private UUID id;

    private String nombre;

    private String contrasena;

    private String roles;

    public User () {

    }

    public User (UUID id, String nombre, String contrasena, String roles) {
        this.id = id;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.roles = roles;
    }

    public User (String nombre, String contrasena, String roles) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.roles = roles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
