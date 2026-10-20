/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_java_medisalud.entity;

/**
 *
 * @author Natalia Rolon Leal
 */
public class Factura {

    private final Cita cita;
    private final double montoBase;

    public Factura(Cita cita, double montoBase) {
        this.cita = cita;
        this.montoBase = montoBase;
    }

    public Cita getCita() {
        return cita;
    }

    public double getMontoBase() {
        return montoBase;
    }

    public double calcularMonto() {
        return montoBase;
    }

    @Override
    public String toString() {
        return "Factura de la cita " + cita.getCodigo() + ": $" + calcularMonto();
    }
}