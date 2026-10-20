/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.mycompany.proyecto2_java_medisalud.exception;

import java.time.LocalDate;

/**
 *
 * @author Natalia Rolon Leal
 */
public class CancelacionTardiaException extends Exception {

    /**
     * Creates a new instance of <code>CancelacionTardiaException</code> without
     * detail message.
     */
    public CancelacionTardiaException(LocalDate fecha) {
        if(fecha.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("La fecha no puede estar en el pasado");
        }
    }

    /**
     * Constructs an instance of <code>CancelacionTardiaException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
//    public CancelacionTardiaException(String msg) {
//        super(msg);
//    }
}
