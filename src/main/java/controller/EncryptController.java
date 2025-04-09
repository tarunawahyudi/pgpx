package controller;

import service.EncryptService;
import view.EncryptView;

import javax.swing.*;
import java.io.File;

public class EncryptController {

    private final EncryptView view;
    private final EncryptService encryptService;

    public EncryptController(JFrame parent) {
        this.view = new EncryptView(parent);
        this.encryptService = new EncryptService();

        initController();
    }

    private void initController() {
        view.getEncryptBtn().addActionListener(e -> handleEncrypt());
        view.setVisible(true);
    }

    private void handleEncrypt() {
        String recipientEmail = view.getRecipientEmailField().getText().trim();
        String senderEmail = view.getSenderEmailField().getText().trim();
        File selectedFile = view.getSelectedFile();
        boolean useArmor = view.getArmorCheckbox().isSelected();

        // Validasi
        if (recipientEmail.isEmpty() || senderEmail.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Please enter both emails.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (selectedFile == null || !selectedFile.exists()) {
            JOptionPane.showMessageDialog(view, "Please choose a valid file to encrypt.", "File Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            File outputFile = encryptService.execute(selectedFile, recipientEmail, senderEmail, useArmor);

            JOptionPane.showMessageDialog(view, STR."""
                File successfully encrypted:
                \{outputFile.getAbsolutePath()}""", "Success", JOptionPane.INFORMATION_MESSAGE);
            view.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, STR."""
            Encryption failed:
            \{ex.getMessage()}""", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
