package com.appsmoviles.u2primerapp.model;

public class Persona {
    private String nombre;
    private Double estatura;
    private int peso;
    private String procedencia;

    public Persona() {
        nombre = "";
        estatura = 0.0;
        peso = 0;
        procedencia = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getEstatura() {
        return estatura;
    }

    public void setEstatura(Double estatura) {
        this.estatura = estatura;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }
}
