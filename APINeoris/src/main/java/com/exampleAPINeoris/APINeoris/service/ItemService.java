package com.exampleAPINeoris.APINeoris.service;

import com.exampleAPINeoris.APINeoris.entity.Item;

import java.util.List;

public interface ItemService {

    public List<Item> buscarCategoria(String category);
}
