package com.exampleAPINeoris.APINeoris.controller;

import com.exampleAPINeoris.APINeoris.commons.EncriptadoConstantes;
import com.exampleAPINeoris.APINeoris.service.ObtienePokemonService;
import com.exampleAPINeoris.APINeoris.serviceImplements.ObtienePokemonServiceImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@RestController
public class PokemonController {

    @Autowired
    private ObtienePokemonService obtienePokemonService;


    @GetMapping("/pokemon/{name}")
    public String getPokemon(@PathVariable String name) throws  Exception{
        String obtienePokemon="";

             if(!name.equals("") || !name.equalsIgnoreCase("null")){
            obtienePokemon=obtienePokemonService.obtienePokemon(name);
        }
        return obtienePokemon;
    }

    /*public static String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance(EncriptadoConstantes.TRANSFORMATION);
        SecretKeySpec secretKeySpec = new SecretKeySpec(EncriptadoConstantes.KEY.getBytes(), EncriptadoConstantes.ALGORITHM);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(EncriptadoConstantes.IV.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

        byte[] encrypted = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }*/

    @PostMapping("/encrypt")
    public String encriptarCadena(@RequestBody String cadenaAEncriptar) throws Exception {
        String obtieneCadenaEncriptada="";

        if(!cadenaAEncriptar.equals("") || !cadenaAEncriptar.equalsIgnoreCase("null")){
            obtieneCadenaEncriptada=obtienePokemonService.encriptarCadena(cadenaAEncriptar);
        }
        return obtieneCadenaEncriptada;
    }
}
