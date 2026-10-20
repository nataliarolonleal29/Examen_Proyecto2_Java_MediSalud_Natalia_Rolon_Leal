/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_java_medisalud.repository;

import com.mycompany.proyecto2_java_medisalud.entity.Medico;
import java.util.List;

/**
 *
 * @author Natalia Rolon Leal
 */
public interface RepositorioMedicos {

    void guardar(Medico medico);

    Medico buscarPorCodigo(String codigo);

    List<Medico> listarTodos();
}