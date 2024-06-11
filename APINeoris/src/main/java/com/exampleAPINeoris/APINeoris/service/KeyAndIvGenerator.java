package com.exampleAPINeoris.APINeoris.service;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;

public class KeyAndIvGenerator {

    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256); // Puedes usar 128, 192 o 256 bits para AES
        return keyGen.generateKey();
    }

    public static IvParameterSpec generateIv() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    public static void main(String[] args) throws Exception {
        SecretKey key = generateKey();
        IvParameterSpec iv = generateIv();
        System.out.println("Key: " + bytesToHex(key.getEncoded()));
        System.out.println("IV: " + bytesToHex(iv.getIV()));
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
