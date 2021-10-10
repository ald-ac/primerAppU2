package com.appsmoviles.u2primerapp.model;

import androidx.annotation.NonNull;

public class Persona {
    private String nombre;
    private Double estatura;
    private int peso;
    private String procedencia;
    private Double imc;

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

    public Double getImc() {
        return imc;
    }

    public void setImc(Double imc) {
        this.imc = imc;
    }

    @NonNull
    @Override
    public String toString() {
        return nombre;
    }
}
