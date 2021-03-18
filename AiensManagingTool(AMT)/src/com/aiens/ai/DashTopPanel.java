package com.aiens.ai;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DashTopPanel extends JPanel{
    private JLabel leftProfile, notificationBell, time, date, cvText;
    private JPanel topTimeDisplay, createNewEvent;

    private Date datey, timey;
    private SimpleDateFormat sfD, sfT;
    DashTopPanel(){
        time = new JLabel();
        time.setForeground(new Color(0x686868));
        time.setFont(new Font("Monospace", Font.BOLD, 16));
        time.setHorizontalAlignment(JLabel.CENTER);
        time.setBounds(0, 35, 149, 20);

        date = new JLabel();
        date.setBounds(0, 10, 149, 20);
        date.setHorizontalAlignment(JLabel.CENTER);
        date.setVerticalAlignment(JLabel.CENTER);
        date.setFont(new Font("Monospace", Font.PLAIN, 12));
        date.setForeground(new Color(0x494949));

        cvText = new JLabel("CREATE NEW EVENT");
        cvText.setFont(new Font("Monospace", Font.PLAIN, 12));
        cvText.setForeground(new Color(0xFFFFFF));
        cvText.setHorizontalAlignment(JLabel.CENTER);
        cvText.setVerticalAlignment(JLabel.CENTER);
        cvText.setBounds(0, 0, 148, 40);

        Thread clock = new Thread(){
            public void run(){
                try{
                while (true){
                    String add = "0";

                    datey = new Date();
                    sfD = new SimpleDateFormat("E dd/MM/yyyy");
                    date.setText(sfD.format(datey));

                    timey = new Date();
                    sfT = new SimpleDateFormat("hh:mm:ss a");
                    time.setText(sfT.format(timey));

                  sleep(1000);
                }
            }catch (Exception e){
                }
            }
        };
        clock.start();


        leftProfile = new JLabel(new ImageIcon("resources/images/profile.png"));
        leftProfile.setBounds(980, 0, 50, 70);
        leftProfile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        leftProfile.setToolTipText("Notifications");

        notificationBell = new JLabel(new ImageIcon("resources/images/bellIdle.png"));
        notificationBell.setBounds(930, 0, 30, 70);
        notificationBell.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        notificationBell.setToolTipText("Profile");

        topTimeDisplay = new JPanel();
        topTimeDisplay.setBounds(720, -2, 149, 60);
        topTimeDisplay.setOpaque(true);
        topTimeDisplay.setBackground(new Color(0xECEDF1));
        topTimeDisplay.setBorder(BorderFactory.createLineBorder(new Color(168, 168, 168, 30), 1));
        topTimeDisplay.add(date);
        topTimeDisplay.add(time);
        topTimeDisplay.setLayout(null);

        createNewEvent = new JPanel();
        createNewEvent.setBounds(500, 15, 149, 40);
        createNewEvent.setBackground(new Color(0xCC6666));
        createNewEvent.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 20), 1));
        createNewEvent.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        createNewEvent.add(cvText);
        createNewEvent.setLayout(null);

        this.setPreferredSize(new Dimension(10, 70));
        this.setBackground(new Color(0xFDFDFD));
        this.setLayout(null);
        this.add(createNewEvent);
        this.add(topTimeDisplay);
        this.add(notificationBell);
        this.add(leftProfile);
    }
}
