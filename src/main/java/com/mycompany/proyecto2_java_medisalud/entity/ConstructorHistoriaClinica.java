/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_java_medisalud.entity;

/**
 *
 * @author Natalia Rolon Leal
 */
public class ConstructorHistoriaClinica {

/** Patron Builder: arma una HistoriaClinica con varios campos opcionales paso a paso. */

    private String antecedentes;
    private String alergias;
    private String observaciones;

    public ConstructorHistoriaClinica conAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
        return this;
    }

    public ConstructorHistoriaClinica conAlergias(String alergias) {
        this.alergias = alergias;
        return this;
    }

    public ConstructorHistoriaClinica conObservaciones(String observaciones) {
        this.observaciones = observaciones;
        return this;
    }

    public HistoriaClinica construir() {
        return new HistoriaClinica(antecedentes, alergias, observaciones);
    }
}