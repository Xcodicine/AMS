package com.aiens.ai;

import javax.swing.*;
import java.awt.*;

public class LoadingScreenEntry extends JFrame {
    private ImageIcon logo;

    LoadingScreenEntry() {
        logo = new ImageIcon("resources/images/logo2.png");



        this.setUndecorated(true);
        this.setSize(500, 300);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setLocationRelativeTo(null);
        this.setIconImage(logo.getImage());
        this.setLayout(new BorderLayout());

    }
}
