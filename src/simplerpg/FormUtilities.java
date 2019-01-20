package simplerpg;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public final class FormUtilities {
    public static void addImage(JPanel panel, String path) {
        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File(path));
        } catch (IOException e) {
            return;
        }
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panel.add(picLabel);
    }
    public static void updateBar(JProgressBar bar, int current, int max){
        bar.setMaximum(max);
        bar.setValue(current);
    }
    public static void removeAllListeners(JButton button){
        for( ActionListener al : button.getActionListeners() ) {
            button.removeActionListener( al );
        }
    }
}
