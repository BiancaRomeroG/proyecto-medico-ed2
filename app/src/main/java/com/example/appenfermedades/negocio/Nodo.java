package com.example.appenfermedades.negocio;

public class Nodo {
    private Nodo hijoIzq;
    private String nombre;
    private Nodo hijoDer;

    public Nodo() {
        this.hijoIzq = null;
        this.nombre = null;
        this.hijoDer = null;
    }

    public Nodo getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(Nodo hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Nodo getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(Nodo hijoDer) {
        this.hijoDer = hijoDer;
    }
}
