package com.exampleAPINeoris.APINeoris.commons;

import org.springframework.stereotype.Component;

@Component
public class EncriptadoConstantes {

    public static final String ALGORITHM = "AES";
    public static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
    public static final String KEY = "1234567890123456";
    public static final String IV = "1234567890123456";
}
