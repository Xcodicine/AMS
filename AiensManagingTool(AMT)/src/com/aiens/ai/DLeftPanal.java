package com.aiens.ai;

import javax.swing.*;
import javax.swing.plaf.metal.MetalCheckBoxIcon;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Locale;

public class DLeftPanal extends JPanel {
    private JPanel namePanel, dashBoardBtn, settingsBtn;
    private JLabel usrname, dashIcon, settingICon;

    private String[] imageBTns = new String[] {
            "resources/images/icons/dashIconActive.png",
            "resources/images/icons/dashIcoNot.png",
            "resources/images/icons/settingIcon.png",
            "resources/images/icons/settingIcoActive.png"
    };
    DLeftPanal(){
        usrname = new JLabel("Y");
        usrname.setFont(new Font("Monospace", Font.PLAIN, 30));
        usrname.setForeground(new Color(0xFDFDFD));
        usrname.setHorizontalAlignment(JLabel.CENTER);
        usrname.setVerticalAlignment(JLabel.CENTER);

        dashIcon = new JLabel(new ImageIcon(imageBTns[0]));
        dashIcon.setHorizontalAlignment(JLabel.CENTER);
        dashIcon.setVerticalAlignment(JLabel.CENTER);

        settingICon = new JLabel(new ImageIcon(imageBTns[2]));
        settingICon.setHorizontalAlignment(JLabel.CENTER);
        settingICon.setVerticalAlignment(JLabel.CENTER);


        namePanel = new JPanel();
        namePanel.setBackground(new Color(0xCC6666));
        namePanel.setLayout(new BorderLayout());
        namePanel.add(usrname, BorderLayout.CENTER);
        namePanel.setPreferredSize(new Dimension(10, 84));
        namePanel.setBounds(0, 0, 78, 84);

        dashBoardBtn = new JPanel();
        dashBoardBtn.setBackground(new Color(255, 255, 255, 20));
        dashBoardBtn.setBounds(0, 84, 78, 60);
        dashBoardBtn.setLayout(new BorderLayout());
        dashBoardBtn.add(dashIcon, BorderLayout.CENTER);
        dashBoardBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        dashBoardBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                boolean isClicked = false;
                do {
                    dashBoardBtn.setBackground(new Color(255, 255, 255, 20));
                    settingsBtn.setBackground(new Color(0, 0, 0, 0));
                    dashBoardBtn.remove(dashIcon);
                    dashIcon = new JLabel(new ImageIcon(imageBTns[0]));
                    dashBoardBtn.add(dashIcon);

                    settingsBtn.remove(settingICon);
                    settingICon = new JLabel(new ImageIcon(imageBTns[2]));
                    settingsBtn.add(settingICon);

                    if (!settingsBtn.isEnabled()){
                        settingsBtn.setEnabled(true);
                        dashBoardBtn.setEnabled(false);
                    }
                }while (isClicked);
            }
        });
        dashBoardBtn.setEnabled(false);


        settingsBtn = new JPanel();
        settingsBtn.setBounds(0, (namePanel.getHeight()+dashBoardBtn.getHeight()), 78, 60);
        settingsBtn.setBackground(new Color(0, 0, 0, 0));
        settingsBtn.setLayout(new BorderLayout());
        settingsBtn.add(settingICon, BorderLayout.CENTER);
        settingsBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        settingsBtn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                boolean isClicked = false;
                do {
                    settingsBtn.setBackground(new Color(255, 255, 255, 20));
                    dashBoardBtn.setBackground(new Color(0, 0, 0, 0));
                    settingsBtn.remove(settingICon);
                    settingICon = new JLabel(new ImageIcon(imageBTns[3]));
                    settingsBtn.add(settingICon);

                    dashBoardBtn.remove(dashIcon);
                    dashIcon = new JLabel(new ImageIcon(imageBTns[1]));
                    dashBoardBtn.add(dashIcon);
                    settingsBtn.setEnabled(false);
                    if (!dashBoardBtn.isEnabled()){
                        dashBoardBtn.setEnabled(true);
                    }
                }while (isClicked);

            }
        });

        this.setPreferredSize(new Dimension( 78,10));
        this.setBackground(new Color(0x463E61));
        this.setBorder(BorderFactory.createLineBorder(new Color(186, 186, 186, 30)));
        this.setLayout(null);
        this.add(namePanel);
        this.add(dashBoardBtn);
        this.add(settingsBtn);

    }
}
