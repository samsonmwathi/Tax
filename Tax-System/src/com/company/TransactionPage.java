package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransactionPage extends JFrame {
    private JButton addAPaymentButton;
    private JButton addASaleButton;
    private JButton addACreditorButton;
    private JButton addABorrowerButton;
    private JButton manageInventoryButton;
    private JPanel homePanel;
    private JButton quitButton;

    public TransactionPage() {
        add(homePanel);
        setSize(500,700);
        addAPaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PaymentForm().setVisible(true);

            }
        });
        addASaleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SaleForm().setVisible(true);
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        addACreditorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreditorForm() .setVisible(true);
            }
        });
        addABorrowerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DebtorForm().setVisible(true);
            }
        });
    }
}
