package com.exampleAPINeoris.APINeoris.service;

import com.exampleAPINeoris.APINeoris.entity.Item;
import com.exampleAPINeoris.APINeoris.repository.ItemRepository;
import com.exampleAPINeoris.APINeoris.serviceImplements.ItemServiceImplements;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemServiceImplements itemService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testBuscarCategoria() {
        String category = "Categoria1";
        Item item1 = new Item();
        item1.setCategory(category);
        item1.setNombre("Item1");

        Item item2 = new Item();
        item2.setCategory(category);
        item2.setNombre("Item2");

        List<Item> mockItems = Arrays.asList(item1, item2);

        when(itemRepository.findByCategory(category)).thenReturn(mockItems);

        List<Item> result = itemService.buscarCategoria(category);
        assertEquals(2, result.size());
        assertEquals("Item1", result.get(0).getNombre());
        assertEquals("Item2", result.get(1).getNombre());
    }
}
