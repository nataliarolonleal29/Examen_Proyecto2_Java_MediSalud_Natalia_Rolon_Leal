/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_java_medisalud.util;

import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author Natalia Rolon Leal
 */
public class ContadorCodigos {
    
/** Concurrencia: AtomicLong genera codigos unicos sin condicion de carrera entre hilos. */
    
    private final AtomicLong contador = new AtomicLong(0);
    private final String prefijo;

    public ContadorCodigos(String prefijo) {
        this.prefijo = prefijo;
    }

    public String siguienteCodigo() {
        long numero = contador.incrementAndGet();
        String numeroConRelleno = String.format("%03d", numero);
        return prefijo + numeroConRelleno;
    }
}