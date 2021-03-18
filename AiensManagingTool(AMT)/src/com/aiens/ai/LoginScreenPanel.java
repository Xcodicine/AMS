package com.aiens.ai;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class LoginScreenPanel extends JPanel {
    LoginScreenContents loginScreenContents = new LoginScreenContents();
    LoginScreenFooter loginScreenFooter = new LoginScreenFooter();

    Image background;
    LoginScreenPanel(){

        this.setPreferredSize(new Dimension(1100, 660));
        this.setBackground(new Color(0, 0, 0, 0));
        this.setLayout(new BorderLayout());
        this.add(loginScreenContents, BorderLayout.NORTH);
        this.add(loginScreenFooter, BorderLayout.SOUTH);

    }

}
