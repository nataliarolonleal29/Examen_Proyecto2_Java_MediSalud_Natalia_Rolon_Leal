/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_java_medisalud.service;

import com.mycompany.proyecto2_java_medisalud.entity.Cita;
import com.mycompany.proyecto2_java_medisalud.entity.Medico;
import com.mycompany.proyecto2_java_medisalud.entity.Paciente;
import com.mycompany.proyecto2_java_medisalud.exception.MedicoNoEncontradoException;
import com.mycompany.proyecto2_java_medisalud.exception.PacienteNoEncontradoException;
import com.mycompany.proyecto2_java_medisalud.notificacion.ObservadorCita;
import java.time.LocalDate;

/**
 *
 * @author Natalia Rolon Leal
 */
public class FachadaAgendamiento {

/** Patron Facade: un unico metodo coordina buscar paciente, buscar medico, crear la cita y conectarla con su observador. */

    private final ServicioPacientes servicioPacientes;
    private final ServicioMedicos servicioMedicos;
    private final ServicioCitas servicioCitas;
    private final ObservadorCita observadorCita;

    public FachadaAgendamiento(ServicioPacientes servicioPacientes, ServicioMedicos servicioMedicos, ServicioCitas servicioCitas, ObservadorCita observadorCita) {
        this.servicioPacientes = servicioPacientes;
        this.servicioMedicos = servicioMedicos;
        this.servicioCitas = servicioCitas;
        this.observadorCita = observadorCita;
    }

    public Cita agendar(String codigoCita, String codigoPaciente, String codigoMedico, LocalDate fecha) throws PacienteNoEncontradoException, MedicoNoEncontradoException {
        Paciente paciente = servicioPacientes.buscarPorCodigo(codigoPaciente);
        Medico medico = servicioMedicos.buscarPorCodigo(codigoMedico);
        Cita cita = servicioCitas.agendarCita(codigoCita, paciente, medico, fecha);
        cita.agregarObservador(observadorCita);
        return cita;
    }
}