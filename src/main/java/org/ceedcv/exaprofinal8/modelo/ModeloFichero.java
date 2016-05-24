/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ceedcv.exaprofinal8.modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author paco
 */
public class ModeloFichero implements IModelo {

    File ft = new File("telefonos.txt");
    File fp = new File("personas.txt");

    @Override
    public void create(Persona p) {
        try {
            FileWriter fw = new FileWriter(fp, true);
            //TODO


        } catch (IOException ex) {
            Logger.getLogger(ModeloFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void create(Telefono t) {
        try {
            FileWriter fw = new FileWriter(ft, true);
            //TODO

        } catch (IOException ex) {
            Logger.getLogger(ModeloFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Telefono> readt() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Persona> readp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void iniciar() {
        if (ft.exists()) {
            ft.delete();
        }
        if (fp.exists()) {
            fp.delete();
        }
    }

}
