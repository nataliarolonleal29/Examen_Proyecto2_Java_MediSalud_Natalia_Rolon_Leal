/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_java_medisalud.repository;

import com.mycompany.proyecto2_java_medisalud.entity.Medico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Natalia Rolon Leal
 */
public class RepositorioMedicosMemoria implements RepositorioMedicos{

    private final List<Medico> medicos = new ArrayList<>();

    @Override
    public synchronized void guardar(Medico medico) {
        medicos.add(medico);
    }

    @Override
    public synchronized Medico buscarPorCodigo(String codigo) {
        for (Medico medico : medicos) {
            if (medico.getCodigo().equals(codigo)) {
                return medico;
            }
        }
        return null;
    }

    @Override
    public synchronized List<Medico> listarTodos() {
        return new ArrayList<>(medicos);
    }
}