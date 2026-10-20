/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_java_medisalud.entity;

/**
 *
 * @author Natalia Rolon Leal
 */
public class Medico extends Persona{

    private String especialidad;

    public Medico(String nombreCompleto, String codigo, String especialidad) {
        super(nombreCompleto, codigo);
        setEspecialidad(especialidad);
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        if (especialidad == null || especialidad.trim().isEmpty()) {
            throw new IllegalArgumentException("La especialidad no puede estar vacia");
        }
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return super.toString() + " (medico, " + especialidad + ")";
    }
}