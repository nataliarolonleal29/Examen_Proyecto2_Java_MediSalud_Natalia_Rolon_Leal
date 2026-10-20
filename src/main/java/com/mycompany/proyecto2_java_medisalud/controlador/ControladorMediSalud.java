/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_java_medisalud.controlador;

import com.mycompany.proyecto2_java_medisalud.entity.Cita;
import com.mycompany.proyecto2_java_medisalud.entity.Factura;
import com.mycompany.proyecto2_java_medisalud.entity.HistoriaClinica;
import com.mycompany.proyecto2_java_medisalud.entity.Medico;
import com.mycompany.proyecto2_java_medisalud.entity.Paciente;
import com.mycompany.proyecto2_java_medisalud.exception.CitaNoEncontradaException;
import com.mycompany.proyecto2_java_medisalud.exception.MedicoNoEncontradoException;
import com.mycompany.proyecto2_java_medisalud.exception.PacienteNoEncontradoException;
import com.mycompany.proyecto2_java_medisalud.exception.TransicionInvalidaException;
import com.mycompany.proyecto2_java_medisalud.service.EstrategiaCosto;
import com.mycompany.proyecto2_java_medisalud.service.FachadaAgendamiento;
import com.mycompany.proyecto2_java_medisalud.service.ServicioCitas;
import com.mycompany.proyecto2_java_medisalud.service.ServicioFacturacion;
import com.mycompany.proyecto2_java_medisalud.service.ServicioMedicos;
import com.mycompany.proyecto2_java_medisalud.service.ServicioPacientes;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Natalia Rolon Leal
 */
public class ControladorMediSalud {

    private final ServicioPacientes servicioPacientes;
    private final ServicioMedicos servicioMedicos;
    private final ServicioCitas servicioCitas;
    private final ServicioFacturacion servicioFacturacion;
    private final FachadaAgendamiento fachadaAgendamiento;

    public ControladorMediSalud(ServicioPacientes servicioPacientes,
                                 ServicioMedicos servicioMedicos,
                                 ServicioCitas servicioCitas,
                                 ServicioFacturacion servicioFacturacion,
                                 FachadaAgendamiento fachadaAgendamiento) {
        this.servicioPacientes = servicioPacientes;
        this.servicioMedicos = servicioMedicos;
        this.servicioCitas = servicioCitas;
        this.servicioFacturacion = servicioFacturacion;
        this.fachadaAgendamiento = fachadaAgendamiento;
    }

    public void registrarPaciente(Paciente paciente) {
        servicioPacientes.registrarPaciente(paciente);
    }

    public void registrarMedico(Medico medico) {
        servicioMedicos.registrarMedico(medico);
    }

    public Cita agendarCita(String codigoCita, String codigoPaciente, String codigoMedico, LocalDate fecha)
            throws PacienteNoEncontradoException, MedicoNoEncontradoException {
        return fachadaAgendamiento.agendar(codigoCita, codigoPaciente, codigoMedico, fecha);
    }

    public void confirmarCita(String codigoCita) throws CitaNoEncontradaException, TransicionInvalidaException {
        servicioCitas.confirmarCita(codigoCita);
    }

    public void atenderCita(String codigoCita, String diagnostico)
            throws CitaNoEncontradaException, TransicionInvalidaException {
        servicioCitas.atenderCita(codigoCita, diagnostico);
    }

    public Cita buscarCita(String codigoCita) throws CitaNoEncontradaException {
        return servicioCitas.buscarPorCodigo(codigoCita);
    }
    
    public void cancelarCita(String codigoCita) throws CitaNoEncontradaException, TransicionInvalidaException{
        servicioCitas.cancelarCita(codigoCita);
    }

    public HistoriaClinica consultarHistoriaClinica(String codigoPaciente) throws PacienteNoEncontradoException {
        Paciente paciente = servicioPacientes.buscarPorCodigo(codigoPaciente);
        return paciente.getHistoriaClinica();
    }

    public Factura facturarCita(String codigoCita, EstrategiaCosto estrategiaCosto) throws CitaNoEncontradaException {
        Cita cita = servicioCitas.buscarPorCodigo(codigoCita);
        return servicioFacturacion.emitirFactura(cita, estrategiaCosto);
    }

    public List<Cita> generarReportePorMedico(String codigoMedico) {
        return servicioCitas.listarPorMedico(codigoMedico);
    }

    public Map<String, Double> generarReporteFacturacionPorMedico() {
        return servicioFacturacion.totalFacturadoPorMedico();
    }

    public List<Paciente> listarPacientesMayoresDeEdad(int edadMinima) {
        return servicioPacientes.listarMayoresDeEdad(edadMinima);
    }
}