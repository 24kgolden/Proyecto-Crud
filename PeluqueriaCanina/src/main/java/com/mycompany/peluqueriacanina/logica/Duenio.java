package com.mycompany.peluqueriacanina.logica;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;

@Entity
public class Duenio implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id_duenio;
    private String nombre;
    private String cel_duenio;

    public Duenio() {
    }

    public Duenio(int id_duenio, String nombre, String cel_duenio) {
        this.id_duenio = id_duenio;
        this.nombre = nombre;
        this.cel_duenio = cel_duenio;
    }

    public int getId_duenio() {
        return id_duenio;
    }

    public void setId_duenio(int id_duenio) {
        this.id_duenio = id_duenio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCelDuenio() {
        return cel_duenio;
    }

    public void setCelDuenio(String cel_duenio) {
        this.cel_duenio = cel_duenio;
    }
    
    
}
