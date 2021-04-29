package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JButton signupButton;
    private JPasswordField passwordField;
    private JLabel passwordLabel;
    private JPanel panel;
    private JPasswordField passwordField1;
    private JButton cancelButton;

    public LoginForm() {
        add(panel);
        setSize(500,700);
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TransactionPage().setVisible(true);
                dispose();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
