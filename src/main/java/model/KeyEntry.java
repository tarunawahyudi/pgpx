package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KeyEntry {
    private String name;
    private String email;
    private String keyType;
    private String fingerprint;
    private String validUntil;
}
