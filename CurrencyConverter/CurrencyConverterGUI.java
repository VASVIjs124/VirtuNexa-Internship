package com.converter.gui;

import javax.swing.*;
import java.awt.*;
import com.converter.service.ExchangeRateService;

public class CurrencyConverterGUI extends JFrame {
    private JTextField amountField;
    private JComboBox<String> fromCurrency;
    private JComboBox<String> toCurrency;
    private JLabel resultLabel;
    private ExchangeRateService service;

    public CurrencyConverterGUI() {
        service = new ExchangeRateService();
        setupUI();
    }

    private void setupUI() {
        setTitle("Currency Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(4, 2, 10, 10));

        String[] currencies = {"USD", "EUR", "GBP", "JPY", "AUD", "CAD"};

        add(new JLabel("Amount:"));
        amountField = new JTextField();
        add(amountField);

        add(new JLabel("From:"));
        fromCurrency = new JComboBox<>(currencies);
        add(fromCurrency);

        add(new JLabel("To:"));
        toCurrency = new JComboBox<>(currencies);
        add(toCurrency);

        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(e -> convertCurrency());
        add(convertButton);

        resultLabel = new JLabel("Result: ");
        add(resultLabel);

        setLocationRelativeTo(null);
    }

    private void convertCurrency() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            String from = (String) fromCurrency.getSelectedItem();
            String to = (String) toCurrency.getSelectedItem();

            double rate = service.getExchangeRate(from, to);
            double result = amount * rate;

            resultLabel.setText(String.format("Result: %.2f %s", result, to));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
}
