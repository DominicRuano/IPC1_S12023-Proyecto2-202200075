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
import proyecto2.Lista.Nodo;
import proyecto2.Paquetes.JPEGHandler;

/**
 *
 * @author Dominic
 */
public class Hilo extends Thread{
    
    public static int val = Proyecto2.listaDoble1.getSize();
    public static int val1 = 0;
    public static Nodo actual2 = (Nodo) Proyecto2.listaDoble1.peek();
    
    @Override
    public void run(){
        String filename;
        filename = actual2.getDato().toString();
        
        if (actual2.getSiguiente() != null) {
            actual2 = actual2.getSiguiente();
        }

        
        while (val1 < val) {            
            Hilo hilo1 = new Hilo();
            hilo1.start();
            val1 ++;
        }

        if (Convertidor.jRadioButton1.isSelected()) {
            try {
                JPEGHandler.runHandler(new JPEGtoBMPImage(filename));
                Convertidor.model2.addElement(filename + " -> JPEGtoBMPImage");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }if (Convertidor.jRadioButton2.isSelected()) {
            try {
                JPEGHandler.runHandler(new JPEGImageCopy(filename));
                Convertidor.model2.addElement(filename + " -> JPEGImageCopy");
            } catch (Exception e) { 
                e.printStackTrace();
            }
        }if (Convertidor.jRadioButton3.isSelected()) {
            try {
                JPEGHandler.runHandler(new JPEGImageHandlerColors(filename));
            Convertidor.model2.addElement(filename + " -> JPEGImageHandlerColors");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }if (Convertidor.jRadioButton4.isSelected()) {
            try {
                JPEGHandler.runHandler(new JPEGImageHandlerRotator(filename));
                Convertidor.model2.addElement(filename + " -> JPEGImageHandlerRotator");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }if (Convertidor.jRadioButton5.isSelected()) {
            try {
                JPEGHandler.runHandler(new JPEGImageHandlerBN(filename));
                Convertidor.model2.addElement(filename + " -> JPEGImageHandlerBN");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
}
