/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Editor;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import proyecto2.Paquetes.ImageHandler;

/**
 *
 * @author Dominic
 */
public class JPEGImageHandlerRotator extends ImageHandler{
    
    private BufferedImage bi;


    public JPEGImageHandlerRotator(String filename) {
        super(filename);
    }

    @Override
    public void readFile() throws Exception {
        
        System.out.println("Imagen: " + this.handledFileName);
        File file = new File(this.handledFileName);
        bi = ImageIO.read(file);
        
    }

    @Override
    public void generateFiles() throws Exception {

        BufferedImage copiaRotarX = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);
        BufferedImage copiaRotarY = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);
        
        for (int i = 0; i < bi.getWidth(); i++) {
            for (int j = 0; j < bi.getHeight(); j++) {
                
                int pixel = bi.getRGB(i, j);
                
                int nuevaPosX = (int)(bi.getWidth() - 1 - i);
                int nuevaPosY = (int)(bi.getHeight() - 1 - j);
                
                copiaRotarX.setRGB(nuevaPosX, j, bi.getRGB(i, j));
                copiaRotarY.setRGB(i, nuevaPosY, bi.getRGB(i, j));
                
            }  
        }
        
        int indexBarra = this.handledFileName.lastIndexOf("\\");
        int indexPunto = this.handledFileName.lastIndexOf(".");
        
        String nombreRotarX = this.handledFileName.substring(indexBarra,indexPunto)+"-RotarX.jpg";
        File nuevoArchivoRotarX = new File("./Temporal/" + nombreRotarX);          
        new File(nuevoArchivoRotarX.getParent()).mkdirs();
        ImageIO.write(copiaRotarX, "jpg", nuevoArchivoRotarX);
        
        String nombreRotarY = this.handledFileName.substring(indexBarra,indexPunto)+"-RotarY.jpg";
        File nuevoArchivoRotarY = new File("./Temporal/" + nombreRotarY);          
        new File(nuevoArchivoRotarY.getParent()).mkdirs();
        ImageIO.write(copiaRotarY, "jpg", nuevoArchivoRotarY);
        
    }
    
}
