/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_java_medisalud.notificacion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Natalia Rolon Leal
 */
public class HiloNotificaciones extends Thread{

/** Concurrencia: procesa notificaciones en un hilo separado para no bloquear el hilo principal. */

    private final List<String> pendientes = new ArrayList<>();
    private volatile boolean activo = true;

    public HiloNotificaciones() {
        super("hilo-notificaciones");
    }

    public synchronized void encolar(String mensaje) {
        pendientes.add(mensaje);
    }

    public void detener() {
        activo = false;
    }

    @Override
    public void run() {
        while (activo) {
            procesarPendientes();
            try {
                Thread.sleep(200);
            } catch (InterruptedException excepcion) {
                Thread.currentThread().interrupt();
                activo = false;
            }
        }
        procesarPendientes();
    }

    private synchronized void procesarPendientes() {
        for (String mensaje : pendientes) {
            System.out.println("[notificacion] " + mensaje);
        }
        pendientes.clear();
    }
}