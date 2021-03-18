package com.aiens.ai;

import javax.swing.*;
import java.awt.*;

public class DashCenterContent extends JPanel {
    private DashTopPanel dashTopPanel = new DashTopPanel();
    private DashCenterContentViwer dashCenterContentViwer = new DashCenterContentViwer();

    DashCenterContent(){
        this.setPreferredSize(new Dimension(10, 10));
        this.setBackground(new Color(0, 0, 0,0));
        this.setLayout(new BorderLayout());
        this.add(dashTopPanel, BorderLayout.NORTH);
        this.add(dashCenterContentViwer, BorderLayout.CENTER);
    }
}
