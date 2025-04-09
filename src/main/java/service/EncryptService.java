package service;

import org.pgpainless.exception.WrongPassphraseException;
import org.pgpainless.sop.SOPImpl;
import sop.SOP;
import sop.exception.SOPGPException;

import javax.swing.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class EncryptService {

    public File execute(File inputFile, String senderEmail, String recipientEmail, boolean armor) throws Exception {
        SOP sop = new SOPImpl();

        Path senderPrivateKeyPath = Path.of("secret", senderEmail + "_private_key.asc");
        Path senderCertPath = Path.of("secret", senderEmail + "_public_key.asc");
        Path recipientCertPath = Path.of("secret", recipientEmail + "_public_key.asc");

        if (!Files.exists(senderPrivateKeyPath) || !Files.exists(senderCertPath) || !Files.exists(recipientCertPath)) {
            throw new IllegalArgumentException("Kunci tidak ditemukan untuk pengirim atau penerima.");
        }

        byte[] senderPrivateKey = Files.readAllBytes(senderPrivateKeyPath);
        byte[] senderCert = Files.readAllBytes(senderCertPath);
        byte[] recipientCert = Files.readAllBytes(recipientCertPath);
        byte[] content = Files.readAllBytes(inputFile.toPath());

        // Input passphrase
        String passphrase = JOptionPane.showInputDialog(null, "Masukkan passphrase untuk " + senderEmail + ":");

        if (passphrase == null) {
            throw new IllegalStateException("Passphrase dibatalkan.");
        }

        try {
            var encryption = sop.encrypt()
                .withCert(recipientCert)
                .withCert(senderCert)
                .signWith(senderPrivateKey)
                .withKeyPassword(passphrase);

            byte[] result = encryption.plaintext(content).toByteArrayAndResult().getBytes();

            File output = new File(inputFile.getParentFile(), inputFile.getName() + ".pgp");
            Files.write(output.toPath(), result);

            return output;
        } catch (SOPGPException e) {
            if (e.getCause() instanceof WrongPassphraseException) {
                throw new IllegalArgumentException("Passphrase salah!");
            }
            throw e;
        }
    }
}
