/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Editor;

import proyecto2.Paquetes.BmpHandlerCopy;
import proyecto2.Paquetes.ImageHandler;

/**
 *
 * @author Dominic
 */
public class JPEGImageCopy extends ImageHandler{

    public JPEGImageCopy(String filename) {
        super(filename);
    }

    @Override
    public void readFile() throws Exception {
        
        BmpHandlerCopy bmpHandlerCopy = new BmpHandlerCopy(this.handledFileName);
        bmpHandlerCopy.readFile();
        
        bmpHandlerCopy.generateFiles();
        
    }

    @Override
    public void generateFiles() throws Exception {
    }
    
}
