/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_java_medisalud.Persistencia.archivo;

import com.mycompany.proyecto2_java_medisalud.entity.Cita;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Natalia Rolon Leal
 */
public class AlmacenCitasSerializado {

    private final String rutaArchivo;

    public AlmacenCitasSerializado(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public void guardarTodas(List<Cita> citas) throws IOException {
        try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            escritor.writeObject(new ArrayList<>(citas));
        }
    }

    @SuppressWarnings("unchecked")
    public List<Cita> cargarTodas() throws IOException, ClassNotFoundException {
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(archivo))) {
            return (List<Cita>) lector.readObject();
        }
    }
}