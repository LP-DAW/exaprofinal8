/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ceedcv.exaprofinal8.controlador;

import org.ceedcv.exaprofinal8.modelo.IModelo;
import org.ceedcv.exaprofinal8.modelo.Telefono;
import org.ceedcv.exaprofinal8.vista.Vista;

/**
 *
 * @author paco
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        IModelo modelo = null;
        Vista vista = new Vista();
        Controlador controlador = new Controlador(modelo, vista);

    }

}
