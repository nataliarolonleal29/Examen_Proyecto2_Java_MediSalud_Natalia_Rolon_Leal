/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_java_medisalud.service;

import com.mycompany.proyecto2_java_medisalud.entity.Cita;

/**
 *
 * @author Natalia Rolon Leal
 */
public class EstrategiaCostoConsultaEspecialista implements EstrategiaCosto{

    private static final double COSTO_CONSULTA_ESPECIALISTA = 90.0;

    @Override
    public double calcularCosto(Cita cita) {
        return COSTO_CONSULTA_ESPECIALISTA;
    }
}