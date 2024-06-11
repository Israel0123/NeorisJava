package com.exampleAPINeoris.APINeoris.serviceImplements;

import com.exampleAPINeoris.APINeoris.entity.Item;
import com.exampleAPINeoris.APINeoris.repository.ItemRepository;
import com.exampleAPINeoris.APINeoris.service.ItemService;
import com.exampleAPINeoris.APINeoris.service.ObtienePokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemServiceImplements implements ItemService {

    @Autowired
    public ItemRepository itemRepository;

    @Override
    public List<Item> buscarCategoria(String category) {
        System.out.println("mensaje:"+itemRepository.findByCategory(category).toString());
        return itemRepository.findByCategory(category);
    }
}
