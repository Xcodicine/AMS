package com.aiens.ai;

import javax.swing.*;
import java.awt.*;

public class LeftBG extends JPanel {
    Image background;

    LeftBG(){
        background = new ImageIcon("resources/images/back5.png").getImage();

        this.setPreferredSize(new Dimension(780, 10));
    }
    public void paint(Graphics g){
        super.paint(g);
        Graphics g2d = (Graphics2D) g;
        g2d.drawImage(background, 0, 0, null);

    }
}
