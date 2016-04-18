package me.walkersneps.snepsbotx.gui;

import me.walkersneps.snepsbotx.SnepsBotX;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PartIRCChannelGUI extends JFrame{
    private JPanel rootPanel;
    private JTextField channelToPartTextField;
    private JButton partBUTTON;
    private JLabel label1;
    //private JLabel label1;



    PartIRCChannelGUI () {

        super("Part a channel");

        setContentPane(rootPanel);

        partBUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String channel = channelToPartTextField.getText();
                SnepsBotX.part(channel);
            }
        });

        pack();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setLocationRelativeTo(null);

        setVisible(true);





    }





} //end of class
