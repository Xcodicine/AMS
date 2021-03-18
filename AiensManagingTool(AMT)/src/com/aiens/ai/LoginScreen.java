package com.aiens.ai;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class LoginScreen{
    private LoadingScreenEntry loadingScreenEntry = new LoadingScreenEntry();
    private LoginScreenTopPanel loginScreenTopPanel = new LoginScreenTopPanel();
    private LoginScreenPanel loginScreenPanel = new LoginScreenPanel();
    private DashboardWindow dashboardWindow = new DashboardWindow();
    private LoginScreenContents loginScreenContents = new LoginScreenContents();

    private ImageIcon logo;
    private JFrame window;

    private JLabel minimize, closeWindow;
    private JPanel rightHeaderBtn;

    private JPanel coverBG, splashImageBg;
    private JLabel splashImage;
    private JProgressBar progressBar;

    private int max = 1, min = 3;
    private int mouseX, mouseY;

    LoginScreen() {

        String[] images = new String[] {
                "resources/images/splash/img1.png",
                "resources/images/splash/img2.jpg",
                "resources/images/splash/img3.jpg"
        };




        logo = new ImageIcon("resources/images/logo2.png");

        minimize = new JLabel(new ImageIcon("resources/images/mini.png"));
        minimize.setBounds(0, 0, 40, 40);
        minimize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        minimize.setBackground(new Color(204, 102, 102, 0));
        minimize.setOpaque(true);
        minimize.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (minimize.getBackground().equals(new Color(204, 102, 102, 0))){
                    minimize.setBackground(new Color(204, 102, 102, 60));
                }else {
                    minimize.setBackground(new Color(204, 102, 102, 0));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (minimize.getBackground().equals(new Color(204, 102, 102, 60))){
                    minimize.setBackground(new Color(204, 102, 102, 0));
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                window.setExtendedState(JFrame.ICONIFIED);
            }
        });
        minimize.setToolTipText("Minimize");

        closeWindow = new JLabel(new ImageIcon("resources/images/close.png"));
        closeWindow.setBounds(40, 0, 40, 40);
        closeWindow.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        closeWindow.setBackground(new Color(204, 102, 102, 0));
        closeWindow.setOpaque(true);
        closeWindow.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (closeWindow.getBackground().equals(new Color(204, 102, 102, 0))){
                    closeWindow.setBackground(new Color(204, 102, 102, 60));
                }else closeWindow.setBackground(new Color(204, 102, 102, 0));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (closeWindow.getBackground().equals(new Color(204, 102, 102, 60))){
                    closeWindow.setBackground(new Color(204, 102, 102, 0));
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }
        });
        closeWindow.setToolTipText("Close");

        rightHeaderBtn = new JPanel();
        rightHeaderBtn.setPreferredSize(new Dimension(80, 40));
        rightHeaderBtn.setBackground(new Color(0, 0, 0,  0));
        rightHeaderBtn.add(minimize);
        rightHeaderBtn.add(closeWindow);
        rightHeaderBtn.setLayout(null);

        loginScreenPanel.add(loginScreenContents);

        loginScreenTopPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });
        loginScreenTopPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                window.setLocation(window.getX() + e.getX() - mouseX, window.getY() + e.getY() - mouseY);
            }
        });
        loginScreenTopPanel.setLayout(new BorderLayout());
        loginScreenTopPanel.add(rightHeaderBtn, BorderLayout.EAST);

        window = new JFrame();
        window.setSize(1150 , 700);
        window.setUndecorated(true);
        window.setLayout(new BorderLayout());
        window.add(loginScreenPanel, BorderLayout.CENTER);
        window.add(loginScreenTopPanel, BorderLayout.NORTH);
        window.setIconImage(logo.getImage());
        window.setLocationRelativeTo(null);
        window.pack();
        window.setVisible(true);


        //-------< LOADING PROGRESS >----------------
        progressBar = new JProgressBar();
        progressBar.setPreferredSize(new Dimension(400, 5));
        progressBar.setValue(0);
        progressBar.setBorder(BorderFactory.createLineBorder(new Color(78, 69, 122, 30), 0));
        progressBar.setForeground(new Color(0xB40041));
        progressBar.setBackground(new Color(0xE8E8E8));
        progressBar.setLayout(null);



        splashImage = new JLabel(new ImageIcon(images[(int)Math.floor(Math.random()*images.length)]));

        splashImageBg = new JPanel();
        splashImageBg.setPreferredSize(new Dimension(500, 295));
        splashImageBg.setBackground(new Color(0, 0, 0, 0));
        splashImageBg.setLayout(new BorderLayout());
        splashImageBg.add(splashImage);


        coverBG = new JPanel();
        coverBG.setBackground(new Color(0, 0, 0, 0));
        coverBG.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        coverBG.setLayout(new BorderLayout());
        coverBG.add(splashImageBg, BorderLayout.NORTH);
        coverBG.add(progressBar, BorderLayout.CENTER);

        loadingScreenEntry.add(coverBG, BorderLayout.CENTER);
        loadingScreenEntry.setVisible(false);

//        loadBar();

        //----------</////////////////////>----------------------

        dashboardWindow.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                Dimension d = dashboardWindow.getContentPane().getSize();
                dashboardWindow.validate();
            }

            @Override
            public void componentMoved(ComponentEvent e) {

            }

            @Override
            public void componentShown(ComponentEvent e) {

            }

            @Override
            public void componentHidden(ComponentEvent e) {

            }
        });

        //------------</////////////////////////>--------------------------
        loginScreenContents.setBackground(new Color(0x48416));
    }

//    public void loadBar(){
//        int count = -50;
//
//        while (count <= 100){
//            progressBar.setValue(count);
//            splashImageBg.setToolTipText(progressBar.getString());
//            try {
//                Thread.sleep(90);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            count+=1;
//            if (progressBar.getValue() == 100){
//                loadingScreenEntry.setVisible(false);
//                window.setVisible(true);
//            }else {
//                window.setVisible(false);
//            }
//        }
//    }


}
