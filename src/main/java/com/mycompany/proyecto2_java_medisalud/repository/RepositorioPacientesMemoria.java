/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_java_medisalud.repository;

import com.mycompany.proyecto2_java_medisalud.entity.Paciente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Natalia Rolon Leal
 */
public class RepositorioPacientesMemoria implements RepositorioPacientes{

    private final List<Paciente> pacientes = new ArrayList<>();

    @Override
    public synchronized void guardar(Paciente paciente) {
        pacientes.add(paciente);
    }

    @Override
    public synchronized Paciente buscarPorCodigo(String codigo) {
        for (Paciente paciente : pacientes) {
            if (paciente.getCodigo().equals(codigo)) {
                return paciente;
            }
        }
        return null;
    }

    @Override
    public synchronized List<Paciente> listarTodos() {
        return new ArrayList<>(pacientes);
    }
}