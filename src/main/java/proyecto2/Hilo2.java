/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

import Editor.JPEGImageCopy;
import Editor.JPEGImageHandlerBN;
import Editor.JPEGImageHandlerColors;
import Editor.JPEGImageHandlerRotator;
import Editor.JPEGtoBMPImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto2.Lista.Nodo;
import proyecto2.Paquetes.JPEGHandler;

/**
 *
 * @author Dominic
 */
public class Hilo2 extends Thread{
    
    public static int val = Proyecto2.listaDoble1.getSize();
    public static int val1 = 0;
    public static Nodo actual2 = (Nodo) Proyecto2.listaDoble1.peek();
    
    @Override
    public void run(){
        
        Convertidor.jProgressBar1.setMaximum(30);
        Convertidor.jProgressBar1.setMinimum(0);
        
        for (int i = 0; i <= 30; i++) {
            Convertidor.jProgressBar1.setValue(i);
            try {
                Thread.sleep(i);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}