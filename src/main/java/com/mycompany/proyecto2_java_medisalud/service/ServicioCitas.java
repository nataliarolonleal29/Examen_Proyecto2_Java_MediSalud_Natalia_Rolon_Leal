/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_java_medisalud.service;

import com.mycompany.proyecto2_java_medisalud.entity.Cita;
import com.mycompany.proyecto2_java_medisalud.entity.EstadoCita;
import com.mycompany.proyecto2_java_medisalud.entity.Medico;
import com.mycompany.proyecto2_java_medisalud.entity.Paciente;
import com.mycompany.proyecto2_java_medisalud.exception.CitaNoEncontradaException;
import com.mycompany.proyecto2_java_medisalud.exception.TransicionInvalidaException;
import com.mycompany.proyecto2_java_medisalud.repository.RepositorioCitas;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Natalia Rolon Leal
 */
public class ServicioCitas {

    private final RepositorioCitas repositorioCitas;

    public ServicioCitas(RepositorioCitas repositorioCitas) {
        this.repositorioCitas = repositorioCitas;
    }

    public Cita agendarCita(String codigo, Paciente paciente, Medico medico, LocalDate fecha) {
        Cita cita = new Cita(codigo, paciente, medico, fecha);
        repositorioCitas.guardar(cita);
        return cita;
    }

    public Cita buscarPorCodigo(String codigo) throws CitaNoEncontradaException {
        Cita cita = repositorioCitas.buscarPorCodigo(codigo);
        if (cita == null) {
            throw new CitaNoEncontradaException(codigo);
        }
        return cita;
    }

    public void confirmarCita(String codigo) throws CitaNoEncontradaException, TransicionInvalidaException {
        cambiarEstado(codigo, EstadoCita.CONFIRMADA);
    }

    public void atenderCita(String codigo, String diagnostico)
            throws CitaNoEncontradaException, TransicionInvalidaException {
        Cita cita = cambiarEstado(codigo, EstadoCita.ATENDIDA);
        cita.getPaciente().getHistoriaClinica().agregarConsulta(diagnostico);
    }

    public void cancelarCita(String codigo) throws CitaNoEncontradaException, TransicionInvalidaException {
        cambiarEstado(codigo, EstadoCita.CANCELADA);
    }

    public List<Cita> listarPorMedico(String codigoMedico) {
        return repositorioCitas.listarPorMedico(codigoMedico);
    }

    public Cita cambiarEstado(String codigo, EstadoCita nuevoEstado)
            throws CitaNoEncontradaException, TransicionInvalidaException {
        Cita cita = buscarPorCodigo(codigo);
        if (!cita.getEstado().puedeTransicionarA(nuevoEstado)) {
            throw new TransicionInvalidaException(codigo, cita.getEstado(), nuevoEstado);
        }
        cita.cambiarEstado(nuevoEstado);
        repositorioCitas.guardar(cita);
        return cita;
    }
}