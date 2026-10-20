/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_java_medisalud.entity;

/**
 *
 * @author Natalia Rolon Leal
 */
public class FacturaConRecargoNocturno extends Factura{

/** Patron Decorator: agrega un recargo a una Factura existente sin modificar su clase. */

    private static final double RECARGO_NOCTURNO = 15.0;
    private final Factura facturaOriginal;

    public FacturaConRecargoNocturno(Factura facturaOriginal) {
        super(facturaOriginal.getCita(), facturaOriginal.getMontoBase());
        this.facturaOriginal = facturaOriginal;
    }

    @Override
    public double calcularMonto() {
        return facturaOriginal.calcularMonto() + RECARGO_NOCTURNO;
    }

    @Override
    public String toString() {
        return facturaOriginal.toString() + " + recargo nocturno = $" + calcularMonto();
    }
}