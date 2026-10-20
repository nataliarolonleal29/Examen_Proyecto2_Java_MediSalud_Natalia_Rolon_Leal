/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_java_medisalud.service;

import com.mycompany.proyecto2_java_medisalud.entity.Paciente;
import com.mycompany.proyecto2_java_medisalud.exception.PacienteNoEncontradoException;
import com.mycompany.proyecto2_java_medisalud.repository.RepositorioPacientes;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author Natalia Rolon Leal
 */
public class ServicioPacientes {

    private final RepositorioPacientes repositorioPacientes;

    public ServicioPacientes(RepositorioPacientes repositorioPacientes) {
        this.repositorioPacientes = repositorioPacientes;
    }

    public void registrarPaciente(Paciente paciente) {
        repositorioPacientes.guardar(paciente);
    }

    public Paciente buscarPorCodigo(String codigo) throws PacienteNoEncontradoException {
        Paciente paciente = repositorioPacientes.buscarPorCodigo(codigo);
        if (paciente == null) {
            throw new PacienteNoEncontradoException(codigo);
        }
        return paciente;
    }

    public List<Paciente> listarTodos() {
        return repositorioPacientes.listarTodos();
    }

    public List<Paciente> listarMayoresDeEdad(int edadMinima) {
        Predicate<Paciente> esMayorDeEdad = paciente -> paciente.getEdad() >= edadMinima;
        return repositorioPacientes.listarTodos().stream()
                .filter(esMayorDeEdad)
                .collect(Collectors.toList());
    }
}
