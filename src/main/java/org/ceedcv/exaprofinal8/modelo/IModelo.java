/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ceedcv.exaprofinal8.modelo;

import java.util.ArrayList;

/**
 *
 * @author paco
 */
public interface IModelo {

    public void create(Persona p);

    public void create(Telefono t);

    public ArrayList<Telefono> readt();

    public ArrayList<Persona> readp();

    public void iniciar();

}
