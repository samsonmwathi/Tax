package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaleForm extends JFrame{
    private JTextField itemTextField;
    private JTextField amountJField;
    private JButton submitButton;
    private JLabel itemJLabel;
    private JTextField quantityJTextField;
    private JLabel quantityJLabel;
    private JLabel amountJLabel;
    private JPanel salesFormPanel;
    private JButton cancelButton;

    public static void success(String success) {
        JOptionPane.showMessageDialog(null,"Success");


    }
    public SaleForm()  {
        add(salesFormPanel);
        setSize(500,700);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //transaction information
                String account= itemTextField.getText();
                String description= quantityJTextField.getText();
                Long amount= Long.valueOf(amountJField.getText());
                Account sale = new Account();
                sale.sales(account,description,amount);
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
