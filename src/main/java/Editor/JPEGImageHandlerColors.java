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
public class JPEGImageHandlerColors extends ImageHandler{
    
    private BufferedImage bi;

    public JPEGImageHandlerColors(String filename) {
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
        
        BufferedImage copiaRoja = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);
        BufferedImage copiaVerde = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);
        BufferedImage copiaAzul = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);
        BufferedImage copiaSepia = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < bi.getWidth(); i++) {
            for (int j = 0; j < bi.getHeight(); j++) {
                
                int pixel = bi.getRGB(i, j);
                Color color = new Color(pixel);
                
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                int alpha = color.getAlpha();
                
                Color colorRojo = new Color(red,0,0,alpha);
                Color colorAzul = new Color(0,0,blue,alpha);
                Color colorVerde = new Color(0,green,0,alpha);
                
                int nuevoRojo = (int) (red*0.393 + green*0.769 + blue*0.189);
                int nuevoVerde = (int) (red*0.349 + green*0.686 + blue*0.168);
                int nuevoAzul = (int) (red*0.272 + green*0.534 + blue*0.131);
                
                if (nuevoRojo > 255) {
                    nuevoRojo = 255;
                }
                if (nuevoVerde > 255) {
                    nuevoVerde = 255;
                }
                if (nuevoAzul > 255) {
                    nuevoAzul = 255;
                }
                
                Color colorSepia = new Color(nuevoRojo, nuevoVerde,nuevoAzul, alpha);
                
                copiaRoja.setRGB(i, j, colorRojo.getRGB());
                copiaAzul.setRGB(i, j, colorAzul.getRGB());
                copiaVerde.setRGB(i, j, colorVerde.getRGB());
                copiaSepia.setRGB(i, j, colorSepia.getRGB());
                
            }
        }
        
        int indexBarra = this.handledFileName.lastIndexOf("\\");
        int indexPunto = this.handledFileName.lastIndexOf(".");
        
        String nombreRojo = this.handledFileName.substring(indexBarra,indexPunto)+"-Rojo.jpg";
        File nuevoArchivoRojo = new File("./Temporal/" + nombreRojo);          
        new File(nuevoArchivoRojo.getParent()).mkdirs();
        ImageIO.write(copiaRoja, "jpg", nuevoArchivoRojo);
        
        
        String nombreazul = this.handledFileName.substring(indexBarra,indexPunto)+"-Azul.jpg";
        File nuevoArchivoAzul = new File("./Temporal/" + nombreazul);          
        new File(nuevoArchivoAzul.getParent()).mkdirs();
        ImageIO.write(copiaAzul, "jpg", nuevoArchivoAzul);
        
        
        String nombreVerde = this.handledFileName.substring(indexBarra,indexPunto)+"-Verde.jpg";
        File nuevoArchivoVerde = new File("./Temporal/" + nombreVerde);           
        new File(nuevoArchivoVerde.getParent()).mkdirs();
        ImageIO.write(copiaVerde, "jpg", nuevoArchivoVerde);
        
        
        String nombreSepia = this.handledFileName.substring(indexBarra,indexPunto)+"-Sepia.jpg";
        File nuevoArchivoSepia = new File("./Temporal/" + nombreSepia);           
        new File(nuevoArchivoSepia.getParent()).mkdirs();
        ImageIO.write(copiaSepia, "jpg", nuevoArchivoSepia);
        
    }
    
}
