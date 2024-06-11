package com.exampleAPINeoris.APINeoris.serviceImplements;

import com.exampleAPINeoris.APINeoris.commons.EncriptadoConstantes;
import com.exampleAPINeoris.APINeoris.service.ObtienePokemonService;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Component
public class ObtienePokemonServiceImplements implements ObtienePokemonService {
    @Override
    public String obtienePokemon(String nombrePokemon) {

        try {
            String url = "https://pokeapi.co/api/v2/pokemon/" + nombrePokemon;
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(url, String.class);
            return result;
        }catch (Exception e){
            return "Este pokemon no se encontro";
        }
    }

    @Override
    public String encriptarCadena(String cadena) throws Exception{
        Cipher cipher = Cipher.getInstance(EncriptadoConstantes.TRANSFORMATION);
        SecretKeySpec secretKeySpec = new SecretKeySpec(EncriptadoConstantes.KEY.getBytes(), EncriptadoConstantes.ALGORITHM);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(EncriptadoConstantes.IV.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

        byte[] encrypted = cipher.doFinal(cadena.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }
}
