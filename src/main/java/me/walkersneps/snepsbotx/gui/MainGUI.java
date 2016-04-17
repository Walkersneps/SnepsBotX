package me.walkersneps.snepsbotx.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainGUI extends JFrame{
    private JPanel rootPanel;
    private JButton sendMessageBUTTON;
    private JButton leaveChannelBUTTON;
    private JButton quitBUTTON;
    private JButton joinChannelBUTTON;

    public MainGUI () {

        super("SnepsBotX");

        setContentPane(rootPanel);

        //what to do when sendMessageBUTTON is pressed
        sendMessageBUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SendIRCMessageGUI();
            }
        });

        //what to do when joinChannelBUTTON is pressed
        joinChannelBUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new JoinIRCChannelGUI();
            }
        });

        //what to do when leaveChannelBUTTON is pressed
        leaveChannelBUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PartIRCChannelGUI();
            }
        });

        //what to do when quitBUTTON is pressed
        quitBUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Quitting program NOW!");
                System.exit(0);
            }
        });

        pack();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setVisible(true);


    }






} //end of class
