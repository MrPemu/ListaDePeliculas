package com.example.listadepeliculas;

public class Pelicula {
    private String peliculaNombre;
    private String peliculaGenero;
    private String peliculaImagen;
    private String peliculaWeb;


    public Pelicula (String nombre, String genero, String imagen, String web) {
        this.peliculaNombre = nombre;
        this.peliculaGenero = genero;
        this.peliculaImagen = imagen;
        this.peliculaWeb = web;
    }

    public String getPeliculaNombre() {
        return peliculaNombre;
    }

    public String getPeliculaGenero() {
        return peliculaGenero;
    }

    public String getPeliculaImagen() {
        return peliculaImagen;
    }

    public String getPeliculaWeb() {
        return peliculaWeb;
    }
}

