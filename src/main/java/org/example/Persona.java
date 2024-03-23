package org.example;

import java.util.ArrayList;

public class Persona {
    private String cui;
    private ArrayList<Vacuna> vacunas;

    public Persona(String cui) {
        this.cui = cui;
        this.vacunas = new ArrayList<Vacuna>();
    }

    public void agregarVacuna(Vacuna vacuna) {
        this.vacunas.add(vacuna);
    }

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    public ArrayList<Vacuna> getVacunas() {
        return vacunas;
    }

    public void setVacunas(ArrayList<Vacuna> vacunas) {
        this.vacunas = vacunas;
    }
}
