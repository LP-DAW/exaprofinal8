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
        //TODO
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO
    }

    //Modelo de examen A
    private void exportardeMysqlaFichero() {
        //TODO
    }

    //Modelo de examen B
    private void exportardeDb4oaFichero() {
        //TODO
    }

    private void inicializaBotones() {
        //TODO
    }

}
