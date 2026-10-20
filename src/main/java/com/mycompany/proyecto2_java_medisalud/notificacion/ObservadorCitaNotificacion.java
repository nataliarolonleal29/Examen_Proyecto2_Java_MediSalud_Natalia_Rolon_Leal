/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_java_medisalud.notificacion;

import com.mycompany.proyecto2_java_medisalud.entity.Cita;

/**
 *
 * @author Natalia Rolon Leal
 */
public class ObservadorCitaNotificacion implements ObservadorCita{

    private final HiloNotificaciones hiloNotificaciones;

    public ObservadorCitaNotificacion(HiloNotificaciones hiloNotificaciones) {
        this.hiloNotificaciones = hiloNotificaciones;
    }

    @Override
    public void notificarCambioEstado(Cita cita) {
        hiloNotificaciones.encolar("La cita " + cita.getCodigo() + " ahora esta " + cita.getEstado());
    }
}