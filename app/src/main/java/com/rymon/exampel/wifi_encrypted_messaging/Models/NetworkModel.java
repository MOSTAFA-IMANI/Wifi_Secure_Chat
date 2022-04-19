package com.rymon.exampel.wifi_encrypted_messaging.Models;

public abstract class NetworkModel {

    private String publicKey;
    private String privateKey;
    private boolean isSecureSupported = false;

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public boolean isSecureSupported() {
        return isSecureSupported;
    }

    public void setSecureSupported(boolean secureSupported) {
        isSecureSupported = secureSupported;
    }
}
