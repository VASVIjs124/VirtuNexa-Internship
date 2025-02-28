package com.converter;

import com.converter.gui.CurrencyConverterGUI;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            SwingUtilities.invokeLater(() -> {
                CurrencyConverterGUI gui = new CurrencyConverterGUI();
                gui.setVisible(true);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
