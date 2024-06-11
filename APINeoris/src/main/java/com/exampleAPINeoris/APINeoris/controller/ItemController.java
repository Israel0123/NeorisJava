package com.exampleAPINeoris.APINeoris.controller;

import com.exampleAPINeoris.APINeoris.entity.Item;
import com.exampleAPINeoris.APINeoris.repository.ItemRepository;
import com.exampleAPINeoris.APINeoris.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PATCH})
@RestController
public class ItemController {

    @Autowired
    public ItemService itemService;
    /*@Autowired
    public ItemRepository itemRepository;*/

    /*@GetMapping("/items")
    public List<Item> getAllItems(@RequestParam(required = false) String category) {
        System.out.println("category::"+category);
        category="Categoria1";
        List<Item> ListaItems=new ArrayList<>();
        if (category != null) {
            System.out.println("category2:"+category);
            ListaItems=itemService.buscarCategoria(category);
            System.out.println("salida::::"+ListaItems.toString());
        };
        return ListaItems;
    }*/

    @GetMapping("/items")
    public List<Item> getAllItems(@RequestBody(required = true) String category) {
        System.out.println("category::"+category);
        category="Categoria1";
        List<Item> ListaItems=new ArrayList<>();
        if (category != null) {
            System.out.println("category2:"+category);
            ListaItems=itemService.buscarCategoria(category);
            System.out.println("salida::::"+ListaItems.toString());
        };
        return ListaItems;
    }
}
