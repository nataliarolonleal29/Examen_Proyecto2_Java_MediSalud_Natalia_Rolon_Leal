/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_java_medisalud.service;

import com.mycompany.proyecto2_java_medisalud.entity.Medico;
import com.mycompany.proyecto2_java_medisalud.exception.MedicoNoEncontradoException;
import com.mycompany.proyecto2_java_medisalud.repository.RepositorioMedicos;
import java.util.List;

/**
 *
 * @author Natalia Rolon Leal
 */
public class ServicioMedicos {

    private final RepositorioMedicos repositorioMedicos;

    public ServicioMedicos(RepositorioMedicos repositorioMedicos) {
        this.repositorioMedicos = repositorioMedicos;
    }

    public void registrarMedico(Medico medico) {
        repositorioMedicos.guardar(medico);
    }

    public Medico buscarPorCodigo(String codigo) throws MedicoNoEncontradoException {
        Medico medico = repositorioMedicos.buscarPorCodigo(codigo);
        if (medico == null) {
            throw new MedicoNoEncontradoException(codigo);
        }
        return medico;
    }

    public List<Medico> listarTodos() {
        return repositorioMedicos.listarTodos();
    }
}