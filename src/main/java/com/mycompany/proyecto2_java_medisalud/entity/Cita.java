/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_java_medisalud.entity;

import com.mycompany.proyecto2_java_medisalud.notificacion.ObservadorCita;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Natalia Rolon Leal
 */
public class Cita implements Serializable{

    private static final long serialVersionUID = 1L;

    private final String codigo;
    private final Paciente paciente;
    private final Medico medico;
    private final LocalDate fecha;
    private EstadoCita estado;
    private transient List<ObservadorCita> observadores = new ArrayList<>();

    public Cita(String codigo, Paciente paciente, Medico medico, LocalDate fecha) {
        this.codigo = codigo;
        this.paciente = paciente;
        this.medico = medico;
        this.fecha = fecha;
        this.estado = EstadoCita.PENDIENTE;
    }

    public void agregarObservador(ObservadorCita observador) {
        observadores.add(observador);
    }

    public void cambiarEstado(EstadoCita nuevoEstado) {
        this.estado = nuevoEstado;
        for (ObservadorCita observador : observadores) {
            observador.notificarCambioEstado(this);
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public EstadoCita getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Cita " + codigo + " [" + estado + "] " + paciente.getNombreCompleto()
                + " con " + medico.getNombreCompleto() + " el " + fecha;
    }

    private void readObject(ObjectInputStream entrada) throws IOException, ClassNotFoundException {
        entrada.defaultReadObject();
        observadores = new ArrayList<>();
    }
}