package at.technikum.javafx.service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ExporterService {

    public void export(BufferedImage bufferedImage, String filename) {
        File file = new File("%s.png".formatted(filename));
        try {
            ImageIO.write(bufferedImage, "png", file);
            System.out.println("Image saved to " + file.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
