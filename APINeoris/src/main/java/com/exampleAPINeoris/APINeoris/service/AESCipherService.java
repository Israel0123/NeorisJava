package com.exampleAPINeoris.APINeoris.service;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESCipherService {

    public static String encrypt(String algorithm, String input, SecretKey key, IvParameterSpec iv) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] cipherText = cipher.doFinal(input.getBytes());
        System.out.println("Este es el algoritmo:"+algorithm);
        System.out.println("Esta es mi entrada:"+input);
        System.out.println("esta es mi salida:"+Base64.getEncoder().encodeToString(cipherText));
        return Base64.getEncoder().encodeToString(cipherText);
    }

    public static void main(String[] args) throws Exception {
        // Supongamos que ya tienes la llave y el IV generados
        SecretKey key = new SecretKeySpec(hexStringToByteArray("tu_llave_aqui"), "AES");
        IvParameterSpec iv = new IvParameterSpec(hexStringToByteArray("tu_iv_aqui"));

        String algorithm = "AES/CBC/PKCS5Padding";
        String input = "Tu texto a cifrar aquí";

        String cipherText = encrypt(algorithm, input, key, iv);
        System.out.println("Cipher Text: " + cipherText);
    }

    private static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }
}
