/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_java_medisalud.entity;

/**
 *
 * @author Natalia Rolon Leal
 */
public class FacturaConDescuentoAfiliado extends Factura{

/** Patron Decorator: agrega un descuento a una Factura existente sin modificar su clase. */

    private static final double DESCUENTO_AFILIADO = 10.0;
    private final Factura facturaOriginal;

    public FacturaConDescuentoAfiliado(Factura facturaOriginal) {
        super(facturaOriginal.getCita(), facturaOriginal.getMontoBase());
        this.facturaOriginal = facturaOriginal;
    }

    @Override
    public double calcularMonto() {
        double montoConDescuento = facturaOriginal.calcularMonto() - DESCUENTO_AFILIADO;
        return Math.max(0.0, montoConDescuento);
    }

    @Override
    public String toString() {
        return facturaOriginal.toString() + " - descuento afiliado = $" + calcularMonto();
    }
}