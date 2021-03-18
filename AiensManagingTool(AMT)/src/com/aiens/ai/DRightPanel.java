package com.aiens.ai;

import javax.swing.*;
import java.awt.*;

public class DRightPanel extends JPanel {
    private JLabel header;
    DRightPanel(){
        header = new JLabel(new ImageIcon("resources/images/dash.png"));
        header.setBounds(0, 20, 210, 20);
        header.setHorizontalAlignment(JLabel.CENTER);
        header.setVerticalAlignment(JLabel.CENTER);


        this.setPreferredSize(new Dimension(285, 10));
        this.setBackground(new Color(0x403958));
        this.setLayout(null);
        this.add(header);
    }
}
