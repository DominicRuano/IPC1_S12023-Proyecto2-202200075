/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

import proyecto2.Lista.ListaDoble;
import proyecto2.Lista.ListaSimple;
import proyecto2.Lista.Nodo;
import static proyecto2.Proyecto2.lista;

/**
 *
 * @author Dominic
 */
public class Funciones {
    
    public static void recorrerImagenes(){
    Nodo actual = (Nodo) Proyecto2.listaDoble.peek();
    while (actual != null) {
        if ((actual.getDato()) != null) {
            System.out.println("Imagen: " + (actual.getDato()));
        }
        actual = actual.getSiguiente();
    }
    }
    
    
    public static void recorrerUsuarios(){
    Nodo actual = (Nodo) lista.peek();
    while(actual != null){
        System.out.println("Usuario: " + ((Usuario)actual.getDato()).getNombre());
        actual = actual.getSiguiente();
    }
    }
    
   public static int validarUsuario (String a){
        Nodo actual = (Nodo) lista.peek();
        String name = a;
        
        while(actual != null){
            if (((Usuario)actual.getDato()).getNombre().contains(a)) {
                return 1;
                }
            actual = actual.getSiguiente();
        }
       return 0;
   }   
}
   
