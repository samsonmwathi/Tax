package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreditorForm extends JFrame {
    private JPanel creditorFormPanel;
    private JTextField creditorTextField;
    private JTextField amountTextField;
    private JButton submitButton;
    private JLabel creditorJLabel;
    private JLabel amountJLabel;
    private JLabel deadlineJLabel;
    private JFormattedTextField deadlineFormattedTextField;
    private JButton cancelButton;

    public static void success(String success) {
        JOptionPane.showMessageDialog(null,"Success");

    }
    public CreditorForm() {
        add(creditorFormPanel);
        setSize(500,700);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String creditor=creditorTextField.getText();
                long amount= Long.parseLong(amountTextField.getText());
                String deadline=deadlineFormattedTextField.getText();

                Account debt= new Account();
                debt.debt(creditor,amount,deadline);
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
