package com.aiens.ai;

import javax.swing.*;
import java.awt.*;

public class LoginScreenFooter extends JPanel {
    private JPanel footerLeftText, footerVerticalLine;
    private JLabel aiensLogo, note, versionAndBuilds;

    private static String[] versions = {
            "20.001.2", "20.021.4", "21.12.23"
    };
    private static String[] builds = {
            "Build202015-56", "Build202154-001"
    };

    LoginScreenFooter(){
        aiensLogo = new JLabel(new ImageIcon("resources/images/aiensLogo.png"));
        aiensLogo.setBounds(30, 0, 80, 80);

        versionAndBuilds = new JLabel("Version " + versions[0] + " " + builds[0]);
        versionAndBuilds.setBounds(900, 28, 200, 30);
        versionAndBuilds.setFont(new Font("Monospace", Font.PLAIN, 10));
        versionAndBuilds.setForeground(new Color(255, 255, 255, 100));


        note = new JLabel(new ImageIcon("resources/images/copy.png"));
        note.setLayout(null);

        footerVerticalLine = new JPanel();
        footerVerticalLine.setBounds(125, 28, 1, 30);
        footerVerticalLine.setBackground(new Color(255, 255, 255, 40));

        footerLeftText = new JPanel();
        footerLeftText.setBounds(140, 30, 600, 50);
        footerLeftText.setBackground(new Color(0, 0, 0, 0));
        footerLeftText.setLayout(new FlowLayout(FlowLayout.LEADING));
        footerLeftText.add(note);


        this.setBackground(new Color(0x4E4570));
        this.setPreferredSize(new Dimension(1100, 80));
        this.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 20), 1));
        this.add(aiensLogo);
        this.add(footerVerticalLine);
        this.add(footerLeftText);
        this.add(versionAndBuilds);
        this.setLayout(null);
    }
}
