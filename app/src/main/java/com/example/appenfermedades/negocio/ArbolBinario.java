package com.example.appenfermedades.negocio;

import android.widget.TextView;

public class ArbolBinario {
    Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    private boolean esHoja(Nodo pr) {
        return pr.getHijoIzq() == null && pr.getHijoDer() == null;
    }

    private void insertar(Nodo p, boolean b, String nombre) {
        Nodo q = new Nodo();
        if (p == null) {
            raiz = q;
            raiz.setNombre(nombre);
            Nodo r = new Nodo();
            if (b) {
                raiz.setHijoIzq(r);
                raiz.setHijoDer(null);
            } else {
                raiz.setHijoDer(r);
                raiz.setHijoIzq(null);
            }
        } else {
            while (!esHoja(p)) {
                if (p.getHijoIzq() != null) {
                    p = p.getHijoIzq();
                } else if (p.getHijoDer() != null) {
                    p = p.getHijoDer();
                }
            }
            p.setNombre(nombre);
            Nodo r = new Nodo();
            if (b) {
                p.setHijoIzq(r);
                p.setHijoDer(null);
            } else {
                p.setHijoDer(r);
                p.setHijoIzq(null);
            }
        }
    }

    public void insertar(boolean b, String nombre) {
        insertar(raiz, b, nombre);
    }

    private void imprimir(Nodo p, TextView jta) {
        while (!esHoja(p)) {
            jta.append(p.getNombre());
            if (p.getHijoIzq() != null) {
                jta.append(": SI" + '\n');
                p = p.getHijoIzq();
            } else if (p.getHijoDer() != null) {
                jta.append(": NO" + '\n');
                p = p.getHijoDer();
            }
        }
    }

    public void imprimir(TextView jta) {
        imprimir(raiz, jta);
    }

    private int valoracion(Nodo p, Enfermedad e) {
        //lista de sintomas con sus pesos
        String nombre;
        int s = 0;
        int value;
        while (!esHoja(p)) {
            nombre = p.getNombre();
            value = e.valueOf(nombre);//PESO DEL SINTOMA
            if (p.getHijoIzq() != null) {//SI
                s = s + value;
                p = p.getHijoIzq();
            } else if (p.getHijoDer() != null) {//NO
                //s = s - value;
                p = p.getHijoDer();
            }
        }
        return s;
    }

    public int valoracion(Enfermedad e) {
        return valoracion(raiz, e);
    }
}
