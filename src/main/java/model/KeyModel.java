package model;

import lombok.Getter;

import javax.swing.table.DefaultTableModel;
import java.util.Arrays;
import java.util.List;

@Getter
public class KeyModel {

    private final List<KeyEntry> keys = Arrays.asList(
        new KeyEntry("John Doe", "john@example.com", "RSA 4096", "F4A1 2B3C D4E5 ...", "20-20-20"),
        new KeyEntry("Jane Smith", "jane@example.com", "ECC 256", "8A9B C1D2 E3F4 ...", "20-20-20")
    );

    public DefaultTableModel getAsTableModel() {
        String[] columnNames = {"Name", "Email", "Key Type", "Fingerprint", "Valid Until"};

        Object[][] data = keys.stream()
            .map(key -> new Object[]{
                key.getName(),
                key.getEmail(),
                key.getKeyType(),
                key.getFingerprint(),
                key.getValidUntil()
            })
            .toArray(Object[][]::new);

        return new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }
}
