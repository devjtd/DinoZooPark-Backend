package com.dinozoopark.web.model;

public class FormularioContacto {
    private String nombre;
    private String email;
    private String dinosaurioFavorito;
    private String mensaje;

    public FormularioContacto() {
    }

    public FormularioContacto(String nombre, String email, String dinosaurioFavorito, String mensaje) {
        this.nombre = nombre;
        this.email = email;
        this.dinosaurioFavorito = dinosaurioFavorito;
        this.mensaje = mensaje;
    }

    // Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDinosaurioFavorito() {
        return dinosaurioFavorito;
    }

    public void setDinosaurioFavorito(String dinosaurioFavorito) {
        this.dinosaurioFavorito = dinosaurioFavorito;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
