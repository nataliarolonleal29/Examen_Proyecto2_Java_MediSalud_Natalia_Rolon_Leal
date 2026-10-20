/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.mycompany.proyecto2_java_medisalud.exception;

/**
 *
 * @author Natalia Rolon Leal
 */
public class PacienteNoEncontradoException extends Exception {

    public PacienteNoEncontradoException(String codigo) {
        super("No existe un paciente con el codigo " + codigo);
    }
}