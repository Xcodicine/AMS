package com.aiens.ai;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class LoginScreenContents extends JPanel {
    private LeftBG leftBG = new LeftBG();
    private JPanel leftbg, rightContent, logoHandler, inputHandler, logoUnderLine, inputUnderLine1, inputUnderLine2,nameAndPasswordHandler, btnhandler, btn;
    private JLabel logoTitle, titleBOld, icon, btnText, logoHeader, name, pass, errorMsg, countDown;
    private ImageIcon logo, helpIcon;
    private JTextField nameField;
    private JPasswordField passwordField;


    Image background;

    private int pwd = 1234;
    private String usrnm = "yasin";

    private int cDown = 10;
    LoginScreenContents(){

        String[] errormsg = new String[]{
                "Invalid user name or password!",
                "Enter correct user name and password.",
                "That wasn't correct at all!"
        };
        String[] lastWrng = new String[]{
                "Unauthorised login attempt detected",
                "Quiting application in:"
        };

        background = new ImageIcon("resources/images/backg.png").getImage();


        name = new JLabel("Name ");
        name.setBounds(25, 7, 100, 30);
        name.setForeground(new Color(255, 255, 255, 120));
        name.setFont(new Font("Monospace", Font.PLAIN, 14));
        pass = new JLabel("Password ");
        pass.setBounds(name.getX(), 47, 100, 30);
        pass.setForeground(new Color(255, 255, 255, 120));
        pass.setFont(new Font("Monospace", Font.PLAIN, 14));

        logo = new ImageIcon("resources/images/logo6.png");
        helpIcon = new ImageIcon("resources/images/helpIcon.png");

        logoHeader = new JLabel(new ImageIcon("resources/images/headerLo.png"));
        logoHeader.setBounds(100, 50, 120, 120);
//        logoHeader.setOpaque(true);

        icon = new JLabel();
        icon.setIcon(helpIcon);
        icon.setBounds(285, 5, 40, 30);
        icon.setHorizontalAlignment(JLabel.CENTER);
        icon.setVerticalAlignment(JLabel.CENTER);
        icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        icon.setToolTipText("Get help if you're having problem with signing in.");

        nameField = new JTextField();
        nameField.setBounds(name.getWidth()+name.getX()-15, 5, 175, 30);
        nameField.setBackground(new Color(0, 0, 0, 0));
        nameField.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 20), 1));
        nameField.setFont(new Font("Monospace", Font.PLAIN, 14));
        nameField.setForeground(new Color(255, 255, 255, 130));

        passwordField = new JPasswordField();
        passwordField.setBounds(nameField.getX(), 47, nameField.getWidth(), 30);
        passwordField.setBackground(new Color(0, 0, 0, 0));
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 20), 1));
        passwordField.setFont(new Font("Monospace", Font.PLAIN, 14));
        passwordField.setForeground(new Color(255, 255, 255, 130));

        btnText = new JLabel("Enter");
        btnText.setForeground(new Color(255, 255, 255, 160));
        btnText.setFont(new Font("Monospace", Font.BOLD, 16));
        btnText.setHorizontalAlignment(JLabel.CENTER);

        titleBOld = new JLabel("Aiens");
        titleBOld.setFont(new Font("Tahoma", Font.BOLD, 20));
        titleBOld.setForeground(new Color(0xCC6666));

        logoTitle = new JLabel( new ImageIcon());
        logoTitle.setIcon(logo);
        logoTitle.setVerticalTextPosition(JLabel.BOTTOM);
        logoTitle.setHorizontalTextPosition(JLabel.CENTER);
        logoTitle.setIconTextGap(5);
        logoTitle.setFont(new Font("Monospace", Font.BOLD, 20));
        logoTitle.setBackground(new Color(0, 0, 0, 0));
        logoTitle.setForeground(new Color(255, 255, 255, 160));
        logoTitle.setBounds(0, 0, 400, 200);
        logoTitle.add(logoHeader);
        logoTitle.setOpaque(true);
        logoTitle.setLayout(null);
        logoTitle.setHorizontalAlignment(JLabel.CENTER);

        errorMsg = new JLabel();
        errorMsg.setBounds(name.getX(), 400, 280, 40);
        errorMsg.setForeground(new Color(0xFF4D00));
        errorMsg.setFont(new Font("Monospace", Font.PLAIN, 14));

        countDown = new JLabel();
        countDown.setBounds(120, 120, 280, 40);
        countDown.setBounds(150, errorMsg.getY()+80, 280, 40);
        countDown.setFont(new Font("Monospace", Font.BOLD, 30));
        countDown.setForeground(new Color(255, 255, 255, 120));


        inputUnderLine1 = new JPanel();
        inputUnderLine1.setBounds(nameField.getX(), 35, nameField.getWidth()+30, 1);
        inputUnderLine1.setBackground(new Color(255, 255, 255, 80));

        inputUnderLine2 = new JPanel();
        inputUnderLine2.setBounds(passwordField.getX(), 77, nameField.getWidth()+30, 1);
        inputUnderLine2.setBackground(new Color(255, 255, 255, 90));

        logoUnderLine = new JPanel();
        logoUnderLine.setBounds(90, 195, 220, 2);
        logoUnderLine.setBackground(new Color(255, 255, 255, 30));

        nameAndPasswordHandler = new JPanel();
        nameAndPasswordHandler.setBounds(0, 30, 350, 80);
        nameAndPasswordHandler.setPreferredSize(new Dimension(400, 80));
        nameAndPasswordHandler.setBackground(new Color(0, 0, 0, 0));
        nameAndPasswordHandler.add(name);
        nameAndPasswordHandler.add(nameField);
        nameAndPasswordHandler.add(passwordField);
        nameAndPasswordHandler.add(pass);
        nameAndPasswordHandler.add(icon);
        nameAndPasswordHandler.setLayout(null);

        btn = new JPanel();
        btn.setBounds(name.getX(), 0 , 285, 40);
        btn.setBackground(new Color(0xCC6666));
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.setLayout(new BorderLayout());
        btn.add(btnText, BorderLayout.CENTER);
        btn.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 40), 1));
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (btn.getBackground().equals(new Color(0xCC6666))){
                    btn.setBackground(new Color(0xAC6464));
                }else {
                    btn.setBackground(new Color(0xCC6666));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (btn.getBackground().equals(new Color(0xAC6464))){
                    btn.setBackground(new Color(0xCC6666));
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int count = 0;

                if (!nameField.getText().equals(usrnm)){
                    Random ran = new Random();
                    int index = ran.nextInt(errormsg.length);

                       errorMsg.setText(""+errormsg[index]);
                    System.out.println(errormsg[index]);
                    cDown--;

                    countDown.setText(""+cDown);
                    if (cDown < 1){
                        btn.setVisible(false);
                        countDown.setText("0");

                        try {

                            errorMsg.setText(""+lastWrng[1]);
                            Timer timer = new Timer();
                            TimerTask timerTask = new TimerTask() {
                                int  counterTIme = 5;
                                @Override
                                public void run() {
                                    if (counterTIme > 0){
                                        countDown.setText("" + counterTIme);
                                        counterTIme--;
                                    }else {
                                        System.out.println("quited");
                                        System.exit(0);
                                        timer.cancel();
                                    }
                                }
                            };
                            timer.scheduleAtFixedRate(timerTask, 2000, 1000);

                        Thread.sleep(2000);
                        }catch (Exception l){
                            System.out.println("err" + e);
                        }
                    }
                }

            }
        });

        btnhandler = new JPanel();
        btnhandler.setBounds(0, nameAndPasswordHandler.getY()+nameAndPasswordHandler.getHeight()+30,400, 40 );
        btnhandler.setPreferredSize(new Dimension(400, 45));
        btnhandler.setBackground(new Color(0, 0, 0, 0));
        btnhandler.add(btn);
        btnhandler.setLayout(null);


        logoHandler = new JPanel();
        logoHandler.setPreferredSize(new Dimension(400, 200));
        logoHandler.setLayout(null);
        logoHandler.add(logoTitle);
        logoHandler.setBackground(new Color(0, 0, 0, 0));


        inputHandler = new JPanel();
        inputHandler.setPreferredSize(new Dimension(400, 200));
        inputHandler.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
        inputHandler.setBackground(new Color(0, 0, 0, 0));
        inputHandler.setLayout(null);
        inputHandler.add(nameAndPasswordHandler);
        inputHandler.add(btnhandler);
        inputHandler.setBounds(0, 200, 400, 200);

//        content = new JPanel();
//        content.setPreferredSize(new Dimension(300, 500));
//        content.setBackground(new Color(0xF3ee ));
//        content.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 30));
//        content.setBounds(400, 30, 300, 450);
//        content.add(logoHandler);
//        content.add(inputHandler);

        rightContent = new JPanel();
        rightContent.setPreferredSize(new Dimension(340, 10));
        rightContent.setBackground(new Color(0x463E61));
        rightContent.setLayout(null);
        rightContent.add(logoHeader);
        rightContent.add(inputHandler);
        rightContent.add(errorMsg);
        rightContent.add(countDown);


        this.setBackground(new Color(0, 0, 0));
        this.setPreferredSize(new Dimension(1280, 580));
        this.setLayout(new BorderLayout());
        this.add(rightContent, BorderLayout.EAST);
        this.add(leftBG, BorderLayout.WEST);

    }

}
