/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ceedcv.exaprofinal8.modelo;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author paco
 */
public class ModeloDb4o implements IModelo {

    private static String fichero = "bdoo.db4o";
    private File ficherobdoo = new File(fichero);
    private ObjectContainer bd;

    public void conectar() {
        System.out.println("BDOO Connexión establecida");
        bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), fichero);
    }

    public void desconectar() {
        System.out.println("BDOO Connexión cerrada");
        bd.close();
    }

    @Override
    public ArrayList<Telefono> readt() {

        ArrayList<Telefono> telefonos = new ArrayList();
        Telefono telefono;

        Telefono buscado;
        buscado = new Telefono(0, null, null);
        conectar();
        ObjectSet res = bd.queryByExample(buscado);
        while (res.hasNext()) {
            telefono = (Telefono) res.next();
            telefonos.add(telefono);
        }
        desconectar();
        return telefonos;
    }

    @Override
    public ArrayList<Persona> readp() {
        Persona persona;
        ArrayList<Persona> personas = new ArrayList();
        Persona buscado = new Persona(0, null);
        conectar();
        ObjectSet res = bd.queryByExample(buscado);
        while (res.hasNext()) {
            persona = (Persona) res.next();
            personas.add(persona);
        }
        desconectar();
        return personas;
    }

    @Override
    public void create(Persona p) {
        conectar();
        bd.store(p);
        System.out.println("Create Persona " + p);
        desconectar();
    }

    @Override
    public void create(Telefono t) {
        conectar();
        bd.store(t);
        System.out.println("Create Telefono " + t);
        desconectar();
    }

    @Override
    public void iniciar() {

        ficherobdoo.delete();

        Persona p1 = new Persona(1, "Paco");
        Persona p2 = new Persona(2, "Juan");

        Telefono t1 = new Telefono(1, "123", p1);
        Telefono t2 = new Telefono(1, "456", p2);

        create(t1);
        create(t2);

    }

}
