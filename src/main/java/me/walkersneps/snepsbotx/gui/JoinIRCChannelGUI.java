package me.walkersneps.snepsbotx.gui;

import me.walkersneps.snepsbotx.SnepsBotX;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class JoinIRCChannelGUI extends JFrame{

    private JPanel rootPanel;
    private JTextField channelToJoinTextField;
    private JButton joinBUTTON;
    private JLabel channelToJoinLABEL;

    JoinIRCChannelGUI () {

        super("Join a Channel");

        setContentPane(rootPanel);

        joinBUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String channel = channelToJoinTextField.getText();
                SnepsBotX.join(channel);
            }
        });

        pack();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setLocationRelativeTo(null);

        setVisible(true);




    }







} //end of class
