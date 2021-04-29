package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;


public class PaymentForm extends JFrame{
    private JTextField paymentAmountJTextField;
    private JButton submitButton;
    private JLabel paymentReceiverLabel;
    private JTextField paymentReceiverTextField;
    private JLabel paymentDescriptionLabel;
    private JTextField paymentDescriptionJTextField;
    private JLabel paymentAmountJLabel;
    private JPanel paymentFormPanel;
    private JButton cancelButton;

    public static void success(String success) {
        JOptionPane.showMessageDialog(null,"Success");

    }

    public PaymentForm() {
        add(paymentFormPanel);
        setSize(500,700);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //transaction information
                String receiver=paymentReceiverTextField.getText();
                String description= paymentDescriptionJTextField.getText();
                Long amount= Long.valueOf(paymentAmountJTextField.getText());

                Account payment = new Account();
                payment.payment(receiver,description,amount);
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

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }
}
