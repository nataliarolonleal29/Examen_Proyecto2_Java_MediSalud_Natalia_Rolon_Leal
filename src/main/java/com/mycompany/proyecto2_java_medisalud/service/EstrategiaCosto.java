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
/** Patron Strategy: variantes intercambiables para calcular el costo de una cita. */
public interface EstrategiaCosto {

    double calcularCosto(Cita cita);
}
