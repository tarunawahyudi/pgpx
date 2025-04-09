package view;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.io.File;

@Getter
public class EncryptView extends JDialog {
    private final JTextField recipientEmailField = new JTextField();
    private final JTextField senderEmailField = new JTextField();
    private final JTextField filePathField = new JTextField();
    private final JCheckBox armorCheckbox = new JCheckBox("Use ASCII Armor (.asc)");
    private final JButton chooseFileBtn = new JButton("Choose File");
    private final JButton encryptBtn = new JButton("Encrypt");
    private final JButton cancelBtn = new JButton("Cancel");

    private File selectedFile;

    public EncryptView(JFrame parent) {
        super(parent, "🔐 Encrypt File", true);
        setSize(500, 400);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout(10, 10));

        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        form.setBorder(BorderFactory.createEmptyBorder(15, 20, 10, 20));

        filePathField.setEditable(false);

        addLabeledField(form, "📧 Recipient Email (Public Key):", recipientEmailField);
        addLabeledField(form, "📧 Your Email (Private Key):", senderEmailField);
        addLabeledField(form, "📁 File to Encrypt:", filePathField);

        form.add(Box.createRigidArea(new Dimension(0, 5)));
        form.add(chooseFileBtn);
        form.add(Box.createRigidArea(new Dimension(0, 10)));
        form.add(armorCheckbox);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(cancelBtn);
        buttonPanel.add(encryptBtn);

        chooseFileBtn.addActionListener(e -> chooseFile());
        cancelBtn.addActionListener(e -> dispose());

        add(form, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addLabeledField(JPanel panel, String labelText, JTextField textField) {
        JLabel label = new JLabel(labelText);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        textField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        textField.setPreferredSize(new Dimension(400, 30));
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(textField);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
    }

    private void chooseFile() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            selectedFile = chooser.getSelectedFile();
            filePathField.setText(selectedFile.getAbsolutePath());
        }
    }
}
