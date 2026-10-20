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
// Patron Observer: Cita avisa a sus observadores cuando cambia de estado, sin conocer como lo usan.
public interface ObservadorCita {
    void notificarCambioEstado(Cita cita);
}
