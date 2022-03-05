package com.example.appenfermedades.negocio;

import java.util.LinkedList;

public class Enfermedad {
    LinkedList<Sintoma> sintomas;

    public Enfermedad() {
        sintomas = new LinkedList<>();
    }

    public LinkedList<Sintoma> getSintomas() {
        return sintomas;
    }

    public void setSintomas(LinkedList<Sintoma> sintomas) {
        this.sintomas = sintomas;
    }

    public void addSintoma(String nombre, int valor) {
        Sintoma s = new Sintoma(nombre, valor);
        this.sintomas.add(s);
    }

    public int valueOf(String nombre) {
        for (int i = 0; i < sintomas.size(); i++) {
            if (sintomas.get(i).getNombre().equals(nombre)) {
                return sintomas.get(i).getValor();
            }
        }
        return 0;
    }
}
