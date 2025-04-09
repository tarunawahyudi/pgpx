package core;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Keyring implements Serializable {
    private final Map<String, byte[]> publicKeys = new HashMap<>();
    private final Map<String, byte[]> privateKeys = new HashMap<>();

    public void addPublicKey(String name, byte[] key) {
        publicKeys.put(name, key);
    }

    public void addPrivateKey(String name, byte[] key) {
        privateKeys.put(name, key);
    }

    public byte[] getPublicKey(String name) {
        return publicKeys.get(name);
    }

    public byte[] getPrivateKey(String name) {
        return privateKeys.get(name);
    }

    public Set<String> listPublicKeys() {
        return publicKeys.keySet();
    }

    public Set<String> listPrivateKeys() {
        return privateKeys.keySet();
    }
}
