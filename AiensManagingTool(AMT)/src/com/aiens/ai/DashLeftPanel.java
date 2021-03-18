package com.aiens.ai;

import javax.swing.*;
import java.awt.*;

public class DashLeftPanel extends JPanel {
    private  DLeftPanal dLeftPanal = new DLeftPanal();
    private DRightPanel dRightPanel = new DRightPanel();
    DashLeftPanel(){
        this.setPreferredSize(new Dimension(280, 10));
        this.setBackground(new Color(0, 0, 0, 0));
        this.setLayout(new BorderLayout());
        this.add(dLeftPanal, BorderLayout.WEST);
        this.add(dRightPanel, BorderLayout.CENTER);

    }
}
