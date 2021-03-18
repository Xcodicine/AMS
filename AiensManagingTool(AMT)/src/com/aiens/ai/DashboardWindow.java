package com.aiens.ai;

import javax.swing.*;
import java.awt.*;


public class DashboardWindow extends JFrame {
    private DashLeftPanel dashLeftPanel =  new DashLeftPanel();
    private DashTopPanel dashTopPanel = new DashTopPanel();
    private DashCenterContent dashCenterContent = new DashCenterContent();

    private ImageIcon logo;

    DashboardWindow(){
        logo = new ImageIcon("resources/images/logo2.png");

        this.setTitle("Aiens Managing System (AMS)");
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        this.setMinimumSize(new Dimension(1360, 720));
        this.setLocationRelativeTo(null);
        this.setIconImage(logo.getImage());
        this.setLayout(new BorderLayout());
        this.add(dashLeftPanel, BorderLayout.WEST);
        this.add(dashCenterContent, BorderLayout.CENTER);
        this.setVisible(false);



    }
}
