/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_java_medisalud.service;

import com.mycompany.proyecto2_java_medisalud.entity.Cita;
import com.mycompany.proyecto2_java_medisalud.entity.Factura;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Natalia Rolon Leal
 */
public class ServicioFacturacion {

    private final List<Factura> facturasEmitidas = new ArrayList<>();

    public Factura emitirFactura(Cita cita, EstrategiaCosto estrategiaCosto) {
        double montoBase = estrategiaCosto.calcularCosto(cita);
        Factura factura = new Factura(cita, montoBase);
        facturasEmitidas.add(factura);
        return factura;
    }

    public List<Factura> listarFacturas() {
        return new ArrayList<>(facturasEmitidas);
    }

    public Map<String, Double> totalFacturadoPorMedico() {
        return facturasEmitidas.stream()
                .collect(Collectors.groupingBy(
                        factura -> factura.getCita().getMedico().getCodigo(),
                        Collectors.summingDouble(Factura::calcularMonto)));
    }
}