/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Editor;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import proyecto2.Paquetes.ImageHandler;

/**
 *
 * @author Dominic
 */
public class JPEGImageHandlerBN extends ImageHandler{
    
    private BufferedImage bi;


    public JPEGImageHandlerBN(String filename) {
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
        
        BufferedImage copiaBN = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < bi.getWidth(); i++) {
            for (int j = 0; j < bi.getHeight(); j++) {
                
                int pixel = bi.getRGB(i, j);
                Color color = new Color(pixel);
                
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                int alpha = color.getAlpha();
                
                int nuevoBN = (int) ((red+green+blue)/3);
                
                Color colorSepia = new Color(nuevoBN, nuevoBN,nuevoBN, alpha);
                
                copiaBN.setRGB(i, j, colorSepia.getRGB());
                
            }
        }
        
        int indexBarra = this.handledFileName.lastIndexOf("\\");
        int indexPunto = this.handledFileName.lastIndexOf(".");
        
        String nombreBN = this.handledFileName.substring(indexBarra,indexPunto)+"-BN.bmp";
        File nuevoArchivoBN = new File("./Temporal/" + nombreBN);          
        new File(nuevoArchivoBN.getParent()).mkdirs();
        ImageIO.write(copiaBN, "bmp", nuevoArchivoBN);        
        
    }
    
}
