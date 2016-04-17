package me.walkersneps.snepsbotx.gui;

import me.walkersneps.snepsbotx.SnepsBotX;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SendIRCMessageGUI extends JFrame{

    private JPanel rootPanel;
    private JTextField reciepientTextField;
    private JTextField messageTextField;
    private JButton sendBUTTON;
    private JLabel messageLabel;

    SendIRCMessageGUI() {

        super ("Send a message");

        setContentPane(rootPanel);

        sendBUTTON.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String target = reciepientTextField.getText();
                String message = messageTextField.getText();
                SnepsBotX.sendMessage(target, message);
            }
        });


        pack();

        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        setLocationRelativeTo(null);

        setVisible(true);
    }





} //end of class
