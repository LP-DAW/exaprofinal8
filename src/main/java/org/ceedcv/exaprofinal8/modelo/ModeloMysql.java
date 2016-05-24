/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ceedcv.exaprofinal8.modelo;

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
public class ModeloMysql implements IModelo {

    private final String BD = "exaprofinal8";
    private final String USER = "alumno";
    private final String PASS = "alumno";
    private Connection con = null;
    private Statement st = null;
    private ResultSet rs = null;

    public void desconectar() {
        try {
            System.out.println("BDR Mysql Connexión cerrada");
            con.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void conectar() {

        try {
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver).newInstance();
            String jdbcUrl = "jdbc:mysql://localhost:3306/" + BD;
            con = (com.mysql.jdbc.Connection) DriverManager.getConnection(jdbcUrl, USER, PASS);
            System.out.println("Conexion establecida con la Base de datos: " + BD);

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<Telefono> readt() {

        ArrayList<Telefono> telefonos = new ArrayList();

        try {

            conectar();
            st = con.createStatement();
            String sql = "select t.idt,numero,t.idp,nombre from telefono as t, persona as p "
              + "where t.idp=p.idp order by idp;";
            System.out.println(sql);
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Telefono telefono = new Telefono();
                Persona persona = new Persona();

                Integer idt;
                String numero;
                Integer idp;
                String nombre;

                idt = rs.getInt("idt");
                numero = rs.getString("numero");
                idp = rs.getInt("idp");
                nombre = rs.getString("nombre");

                telefono.setIdt(idt);
                telefono.setNumero(numero);

                persona.setIdp(idp);
                persona.setNom(nombre);

                telefono.setPersona(persona);

                telefonos.add(telefono);
            }

        } catch (SQLException se) {
            //Errores de JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Errores de Class.forNameCliente
            e.printStackTrace();
        }
        desconectar();
        return telefonos;
    }

    @Override
    public ArrayList<Persona> readp() {
        ArrayList<Persona> personas = new ArrayList();

        try {

            conectar();
            st = con.createStatement();
            String sql = "select idp,nombre from persona order by idp;";
            System.out.println(sql);
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Persona persona = new Persona();

                Integer idp;
                String nombre;

                idp = rs.getInt("idp");
                nombre = rs.getString("nombre");

                persona.setIdp(idp);
                persona.setNom(nombre);

                personas.add(persona);
            }

        } catch (SQLException se) {
            //Errores de JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Errores de Class.forNameCliente
            e.printStackTrace();
        }
        desconectar();
        return personas;
    }

    @Override
    public void create(Persona p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Telefono t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void iniciar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
