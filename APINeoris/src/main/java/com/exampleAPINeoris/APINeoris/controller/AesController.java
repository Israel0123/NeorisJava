package com.exampleAPINeoris.APINeoris.controller;
import com.exampleAPINeoris.APINeoris.service.AESCipherService;
import org.springframework.web.bind.annotation.*;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

@RestController
@RequestMapping("/aes")

public class AesController {

    private final SecretKey key;
    private final IvParameterSpec iv;

    public AesController() throws Exception {
        // Inicializar llave y IV
        this.key = new SecretKeySpec(hexStringToByteArray("614a64201a433d40261837f58fcfdf3a6a471b2f779dd4cf290a76336e5ab57e"), "AES");
        this.iv = new IvParameterSpec(hexStringToByteArray("a277c70415adb9f062f793a08c4c2d5f"));
    }

    @PostMapping("/encrypt")
    public String encrypt(@RequestBody String plainText) throws Exception {
        System.out.println("plainText:"+plainText);
        return AESCipherService.encrypt("AES/CBC/PKCS5Padding", plainText, key, iv);
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
