/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ceedcv.exaprofinal8.controlador;

import static java.awt.JobAttributes.DestinationType.FILE;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ceedcv.exaprofinal8.modelo.IModelo;
import org.ceedcv.exaprofinal8.modelo.ModeloDb4o;
import org.ceedcv.exaprofinal8.modelo.ModeloFichero;
import org.ceedcv.exaprofinal8.modelo.ModeloMysql;
import org.ceedcv.exaprofinal8.modelo.Persona;
import org.ceedcv.exaprofinal8.modelo.Telefono;
import org.ceedcv.exaprofinal8.vista.Vista;

/**
 *
 * @author paco
 */
public class Controlador implements ActionListener {

    private IModelo modelo;
    private Vista vista;
    ArrayList<Telefono> telefonos;
    ArrayList<Persona> personas;

    Controlador(IModelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
        inicializaBotones();
        vista.setVisible(true);
        vista.setTitle("exaprofinal8");
        vista.setLocationRelativeTo(null); // Centrar
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //ModeloA
        //exportardeMysqlaFichero();
        //ModeloB
        exportardeDb4oaFichero();

    }

    private void exportardeMysqlaFichero() {

        vista.setTitle("exaprofinal8a - Mysql a Fichero");
        modelo = new ModeloMysql();

        personas = modelo.readp();
        telefonos = modelo.readt();

        modelo = new ModeloFichero();
        modelo.iniciar();

        Iterator it = telefonos.iterator();
        while (it.hasNext()) {
            Telefono telefono = (Telefono) it.next();
            modelo.create(telefono);
        }
        it = personas.iterator();
        while (it.hasNext()) {
            Persona persona = (Persona) it.next();
            modelo.create(persona);
        }

    }

    private void exportardeDb4oaFichero() {

        vista.setTitle("exaprofinal8b - Db4o a Fichero");
        modelo = new ModeloDb4o();
        modelo.iniciar();

        personas = modelo.readp();
        telefonos = modelo.readt();

        modelo = new ModeloFichero();
        modelo.iniciar();

        Iterator it = telefonos.iterator();
        while (it.hasNext()) {
            Telefono telefono = (Telefono) it.next();
            modelo.create(telefono);
        }
        it = personas.iterator();
        while (it.hasNext()) {
            Persona persona = (Persona) it.next();
            modelo.create(persona);
        }
    }

    private void inicializaBotones() {
        vista.getImportar().addActionListener(this);
    }

}
