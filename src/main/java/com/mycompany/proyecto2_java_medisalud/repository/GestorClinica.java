/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_java_medisalud.repository;

/**
 *
 * @author Natalia Rolon Leal
 */
public class GestorClinica {
    
/** Patron Singleton: unica instancia compartida de los tres repositorios de la aplicacion. */
    
    private static GestorClinica instancia;

    private final RepositorioPacientes repositorioPacientes;
    private final RepositorioMedicos repositorioMedicos;
    private final RepositorioCitas repositorioCitas;

    private GestorClinica(RepositorioPacientes repositorioPacientes, RepositorioMedicos repositorioMedicos, RepositorioCitas repositorioCitas) {
        this.repositorioPacientes = repositorioPacientes;
        this.repositorioMedicos = repositorioMedicos;
        this.repositorioCitas = repositorioCitas;
    }

    public static synchronized GestorClinica inicializar(RepositorioPacientes repositorioPacientes, RepositorioMedicos repositorioMedicos, RepositorioCitas repositorioCitas) {
        if (instancia == null) {
            instancia = new GestorClinica(repositorioPacientes, repositorioMedicos, repositorioCitas);
        }
        return instancia;
    }

    public static GestorClinica obtenerInstancia() {
        if (instancia == null) {
            throw new IllegalStateException("GestorClinica no fue inicializado todavia");
        }
        return instancia;
    }

    public RepositorioPacientes getRepositorioPacientes() {
        return repositorioPacientes;
    }

    public RepositorioMedicos getRepositorioMedicos() {
        return repositorioMedicos;
    }

    public RepositorioCitas getRepositorioCitas() {
        return repositorioCitas;
    }
}