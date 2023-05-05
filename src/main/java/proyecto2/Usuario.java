/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

import java.util.ArrayList;
import java.util.Arrays;
import proyecto2.Lista.ListaDoble;

/**
 *
 * @author Dominic
 */
public class Usuario {
    
    private String Nombre;
    private ListaDoble Imagenes;

    public Usuario(String Nombre) {
        this.Nombre = Nombre;
        this.Imagenes = Imagenes;
        this.Imagenes = new ListaDoble();
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public ListaDoble getImagenes() {
        return Imagenes;
    }

    public void setImagenes(ListaDoble Imagenes) {
        this.Imagenes = Imagenes;
    }

}
