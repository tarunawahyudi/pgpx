package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class AppView extends JFrame {
    private final JTable keyTable;
    private final JButton btnEncrypt;
    private final JMenuItem importKeyItem;
    private final JMenuItem exportKeyItem;
    private final JMenuItem certificateItem;

    public AppView() {
        setTitle("Kleopatra-like PGP Desktop App");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();

        JMenu menuCertificates = new JMenu("Certificates");
        importKeyItem = new JMenuItem("Import...");
        exportKeyItem = new JMenuItem("Export...");
        certificateItem = new JMenuItem("Certificate Details");
        menuCertificates.add(importKeyItem);
        menuCertificates.add(exportKeyItem);
        menuCertificates.addSeparator();
        menuCertificates.add(certificateItem);

        JMenu menuView = new JMenu("View");
        menuView.add(new JMenuItem("View Standard"));

        menuBar.add(menuCertificates);
        menuBar.add(menuView);
        menuBar.add(new JMenu("Tools"));
        menuBar.add(new JMenu("Help"));

        setJMenuBar(menuBar);

        keyTable = new JTable();
        keyTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        keyTable.setRowHeight(30);
        keyTable.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JScrollPane tableScrollPane = new JScrollPane(keyTable);
        tableScrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(tableScrollPane, BorderLayout.CENTER);

        // Toolbar panel
        JPanel toolbar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnEncrypt = new JButton("Encrypt");
        JButton btnDecrypt = new JButton("Decrypt");
        JButton btnGenerateKey = new JButton("Generate Key");

        toolbar.add(btnEncrypt);
        toolbar.add(btnDecrypt);
        toolbar.add(btnGenerateKey);
        toolbar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(toolbar, BorderLayout.NORTH);
    }

    public void loadKeyTable(DefaultTableModel model) {
        keyTable.setModel(model);
    }

    public void onEncryptClicked(ActionListener listener) {
        btnEncrypt.addActionListener(listener);
    }

    public void onImportKeyClicked(ActionListener listener) {
        importKeyItem.addActionListener(listener);
    }

    public void onExportKeyClicked(ActionListener listener) {
        exportKeyItem.addActionListener(listener);
    }

    public void onCertificateClicked(ActionListener listener) {
        certificateItem.addActionListener(listener);
    }
}
