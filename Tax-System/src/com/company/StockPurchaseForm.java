package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StockPurchaseForm extends JFrame{
    private JTextField itemTextField;
    private JTextField quantityTextField;
    private JTextField amountTextField;
    private JButton submitButton;
    private JLabel itemLabel;
    private JLabel quantityLabel;
    private JLabel amountJLabel;
    private JPanel stockPurchasePanel;

    public StockPurchaseForm() {
        add(stockPurchasePanel);
        setSize(500,700);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
