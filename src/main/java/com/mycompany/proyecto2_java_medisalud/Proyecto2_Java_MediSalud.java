/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto2_java_medisalud;

import com.mycompany.proyecto2_java_medisalud.Persistencia.jdbc.CitaDAO;
import com.mycompany.proyecto2_java_medisalud.Persistencia.jdbc.MedicoDAO;
import com.mycompany.proyecto2_java_medisalud.Persistencia.jdbc.PacienteDAO;
import com.mycompany.proyecto2_java_medisalud.controlador.ControladorMediSalud;
import com.mycompany.proyecto2_java_medisalud.exception.CitaNoEncontradaException;
import com.mycompany.proyecto2_java_medisalud.exception.TransicionInvalidaException;
import com.mycompany.proyecto2_java_medisalud.notificacion.HiloNotificaciones;
import com.mycompany.proyecto2_java_medisalud.notificacion.ObservadorCitaNotificacion;
import com.mycompany.proyecto2_java_medisalud.repository.GestorClinica;
import com.mycompany.proyecto2_java_medisalud.service.FachadaAgendamiento;
import com.mycompany.proyecto2_java_medisalud.service.ServicioCitas;
import com.mycompany.proyecto2_java_medisalud.service.ServicioFacturacion;
import com.mycompany.proyecto2_java_medisalud.service.ServicioMedicos;
import com.mycompany.proyecto2_java_medisalud.service.ServicioPacientes;
import com.mycompany.proyecto2_java_medisalud.vista.VistaConsola;

/**
 *
 * @author Natalia Rolon Leal
 */
public class Proyecto2_Java_MediSalud {

    public static void main(String[] args) throws InterruptedException, TransicionInvalidaException, CitaNoEncontradaException {

        PacienteDAO pacienteDAO = new PacienteDAO();
        MedicoDAO medicoDAO = new MedicoDAO();
        CitaDAO citaDAO = new CitaDAO(pacienteDAO, medicoDAO);
        GestorClinica.inicializar(pacienteDAO, medicoDAO, citaDAO);

        ServicioPacientes servicioPacientes = new ServicioPacientes(pacienteDAO);
        ServicioMedicos servicioMedicos = new ServicioMedicos(medicoDAO);
        ServicioCitas servicioCitas = new ServicioCitas(citaDAO);
        ServicioFacturacion servicioFacturacion = new ServicioFacturacion();

        HiloNotificaciones hiloNotificaciones = new HiloNotificaciones();
        hiloNotificaciones.start();
        ObservadorCitaNotificacion observador = new ObservadorCitaNotificacion(hiloNotificaciones);
        FachadaAgendamiento fachadaAgendamiento = new FachadaAgendamiento(
                servicioPacientes, servicioMedicos, servicioCitas, observador);

        ControladorMediSalud controlador = new ControladorMediSalud(
                servicioPacientes, servicioMedicos, servicioCitas, servicioFacturacion, fachadaAgendamiento);

        VistaConsola vista = new VistaConsola(controlador);
        vista.mostrarMenu();

        hiloNotificaciones.detener();
        hiloNotificaciones.join();
    }
}