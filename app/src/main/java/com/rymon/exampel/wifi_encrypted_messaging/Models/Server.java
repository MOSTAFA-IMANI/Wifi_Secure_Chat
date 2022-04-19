package com.rymon.exampel.wifi_encrypted_messaging.Models;

public class Server extends NetworkModel{
    private String serverIp;
    private static final Server ourInstance = new Server();

    public static Server getInstance() {
        return ourInstance;
    }

    private Server(){

    }
    public void setProperty(String publicKey , String privateKey, boolean isSecureSupported ) {
        this.setPrivateKey(privateKey);
        this.setPublicKey(publicKey);
        this.setSecureSupported(isSecureSupported);
    }
    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }
}
