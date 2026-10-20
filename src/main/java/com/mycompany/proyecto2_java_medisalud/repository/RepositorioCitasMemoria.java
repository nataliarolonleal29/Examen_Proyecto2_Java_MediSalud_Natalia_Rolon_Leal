/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_java_medisalud.repository;

import com.mycompany.proyecto2_java_medisalud.entity.Cita;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Natalia Rolon Leal
 */
public class RepositorioCitasMemoria implements RepositorioCitas{
    
    private final Map<String, Cita> citasPorCodigo = new HashMap<>();

    @Override
    public synchronized void guardar(Cita cita) {
        citasPorCodigo.put(cita.getCodigo(), cita);
    }

    @Override
    public synchronized Cita buscarPorCodigo(String codigo) {
        return citasPorCodigo.get(codigo);
    }

    @Override
    public synchronized List<Cita> listarTodas() {
        return new ArrayList<>(citasPorCodigo.values());
    }

    @Override
    public synchronized List<Cita> listarPorMedico(String codigoMedico) {
        List<Cita> resultado = new ArrayList<>();
        for (Cita cita : citasPorCodigo.values()) {
            if (cita.getMedico().getCodigo().equals(codigoMedico)) {
                resultado.add(cita);
            }
        }
        return resultado;
    }
}