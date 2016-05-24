package org.ceedcv.exaprofinal8.modelo;
// Generated 12-may-2016 16:28:58 by Hibernate Tools 4.3.1

/**
 * Telefono generated by hbm2java
 */
public class Telefono implements java.io.Serializable {

    private int idt;
    private String numero;
    private Persona persona;

    public Telefono() {
    }

    public Telefono(Persona persona, String numero) {
        this.persona = persona;
        this.numero = numero;
    }

    public Telefono(int idt, String numero, Persona persona) {
        this.idt = idt;
        this.persona = persona;
        this.numero = numero;
    }

    public int getIdt() {
        return this.idt;
    }

    public void setIdt(int idt) {
        this.idt = idt;
    }

    public Persona getPersona() {
        return this.persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String toString() {
        return idt + " " + numero;
    }

}
