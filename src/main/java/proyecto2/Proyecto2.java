/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package proyecto2;

import proyecto2.Lista.ListaDoble;
import proyecto2.Lista.ListaSimple;
import proyecto2.Lista.Nodo;

/**
 *
 * @author Dominic
 */
public class Proyecto2 {
    public static ListaDoble listaDoble = new ListaDoble();
    public static ListaDoble listaDoble1 = new ListaDoble();
    public static ListaSimple lista = new ListaSimple();

    public static void main(String[] args) {

        
        MenuInicial u = new MenuInicial();
            u.setVisible(true);
            u.setLocationRelativeTo(null);
        
        lista.add(new Usuario("Dominic"));
        
        Funciones.recorrerUsuarios();
        
        System.out.println("------------------");
    }
}
