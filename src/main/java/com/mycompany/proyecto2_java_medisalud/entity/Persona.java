/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_java_medisalud.entity;

import java.io.Serializable;

/**
 *
 * @author Natalia Rolon Leal
 */
public class Persona implements Serializable{

    private static final long serialVersionUID = 1L;

    private String nombreCompleto;
    private String codigo;

    protected Persona(String nombreCompleto, String codigo) {
        setNombreCompleto(nombreCompleto);
        this.codigo = codigo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        if (nombreCompleto == null || nombreCompleto.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre completo no puede estar vacio");
        }
        this.nombreCompleto = nombreCompleto;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return codigo + " - " + nombreCompleto;
    }
}
