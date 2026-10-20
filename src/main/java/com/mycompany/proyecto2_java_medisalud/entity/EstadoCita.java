/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.proyecto2_java_medisalud.entity;

/**
 *
 * @author Natalia Rolon Leal
 */
public enum EstadoCita {
    
    // Patron State: cada valor sabe a que otros estados puede transicionar.
    PENDIENTE,
    CONFIRMADA,
    ATENDIDA,
    CANCELADA;

    public boolean puedeTransicionarA(EstadoCita nuevoEstado) {
        switch (this) {
            case PENDIENTE:
                return nuevoEstado == CONFIRMADA || nuevoEstado == CANCELADA;
            case CONFIRMADA:
                return nuevoEstado == ATENDIDA || nuevoEstado == CANCELADA;
            default:
                return false;
        }
    }
    
}
