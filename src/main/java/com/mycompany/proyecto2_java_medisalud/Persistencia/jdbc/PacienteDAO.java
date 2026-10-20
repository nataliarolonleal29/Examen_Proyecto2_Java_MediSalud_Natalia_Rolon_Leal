/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_java_medisalud.Persistencia.jdbc;

import com.mycompany.proyecto2_java_medisalud.entity.Paciente;
import com.mycompany.proyecto2_java_medisalud.repository.RepositorioPacientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Natalia Rolon Leal
 */
public class PacienteDAO implements RepositorioPacientes {

    @Override
    public void guardar(Paciente paciente) {
        String sql = "INSERT INTO pacientes (codigo, nombre_completo, edad) VALUES (?, ?, ?)";
        try (Connection conexion = ConexionDB.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setString(1, paciente.getCodigo());
            sentencia.setString(2, paciente.getNombreCompleto());
            sentencia.setInt(3, paciente.getEdad());
            sentencia.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException excepcion) {
            throw new IllegalArgumentException("Ya existe un paciente con el codigo " + paciente.getCodigo());
        } catch (SQLException excepcion) {
            throw new RuntimeException("No se pudo guardar el paciente " + paciente.getCodigo(), excepcion);
        }
    }

    @Override
    public Paciente buscarPorCodigo(String codigo) {
        String sql = "SELECT codigo, nombre_completo, edad FROM pacientes WHERE codigo = ?";
        try (Connection conexion = ConexionDB.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setString(1, codigo);
            try (ResultSet resultado = sentencia.executeQuery()) {
                if (resultado.next()) {
                    return mapearPaciente(resultado);
                }
                return null;
            }
        } catch (SQLException excepcion) {
            throw new RuntimeException("No se pudo buscar el paciente " + codigo, excepcion);
        }
    }

    @Override
    public List<Paciente> listarTodos() {
        List<Paciente> pacientes = new ArrayList<>();
        String sql = "SELECT codigo, nombre_completo, edad FROM pacientes";
        try (Connection conexion = ConexionDB.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql);
             ResultSet resultado = sentencia.executeQuery()) {
            while (resultado.next()) {
                pacientes.add(mapearPaciente(resultado));
            }
        } catch (SQLException excepcion) {
            throw new RuntimeException("No se pudo listar los pacientes", excepcion);
        }
        return pacientes;
    }

    private Paciente mapearPaciente(ResultSet resultado) throws SQLException {
        String codigo = resultado.getString("codigo");
        String nombreCompleto = resultado.getString("nombre_completo");
        int edad = resultado.getInt("edad");
        return new Paciente(nombreCompleto, codigo, edad);
    }
}