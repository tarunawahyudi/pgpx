package controller;

import model.KeyModel;
import view.AppView;

import javax.swing.*;

public class AppController {
    private final AppView view;
    private final KeyModel model;

    public AppController(AppView view, KeyModel model) {
        this.view = view;
        this.model = model;

        initListeners();
        view.loadKeyTable(model.getAsTableModel());
    }

    private void initListeners() {
        view.onEncryptClicked(e -> showEncryptDialog());

        view.onImportKeyClicked(e ->
            JOptionPane.showMessageDialog(view, "Import dialog to be implemented"));
        view.onExportKeyClicked(e ->
            JOptionPane.showMessageDialog(view, "Export dialog to be implemented"));
        view.onCertificateClicked(e ->
            JOptionPane.showMessageDialog(view, "Certificate details to be implemented"));
    }

    private void showEncryptDialog() {
        new EncryptController(view);
    }
}
