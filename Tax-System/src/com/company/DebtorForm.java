package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DebtorForm extends JFrame {
    private JTextField debtorTextField;
    private JTextField amountTextField;
    private JButton submitButton;
    private JFormattedTextField deadlineFormattedTextField;
    private JLabel debtorJLabel;
    private JLabel amountJLabel;
    private JLabel deadlineJLabel;
    private JPanel debtorFormPanel;
    private JButton cancelButton;


    public DebtorForm() {
        add(debtorFormPanel);
        setSize(500,700);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String debtor=debtorTextField.getText();
                long amount= Long.parseLong(amountTextField.getText());
                String deadline=deadlineFormattedTextField.getText();

                Account debt= new Account();
                debt.debtor(debtor,amount,deadline);
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
