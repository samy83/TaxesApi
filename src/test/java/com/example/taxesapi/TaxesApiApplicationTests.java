package com.example.taxesapi;

import com.example.taxesapi.dto.BillOutputDTO;
import com.example.taxesapi.dto.ProductInputDTO;
import com.example.taxesapi.model.Category;
import com.example.taxesapi.service.BillService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TaxesApiApplicationTests {

    private final BillService billService = new BillService();

    @Test
    void testInput1() {
        List<ProductInputDTO> products = List.of(
            new ProductInputDTO("livre", 12.49, false, Category.BOOK),
            new ProductInputDTO("CD musical", 14.99, false, Category.OTHER),
            new ProductInputDTO("barre de chocolat", 0.85, false, Category.FOOD)
        );
        BillOutputDTO result = billService.generateBill(products);

        assertEquals(29.83, result.total(), 0.001);
        assertEquals(1.50, result.totalTaxes(), 0.001);
    }

    @Test
    void testInput2() {
        List<ProductInputDTO> products = List.of(
            new ProductInputDTO("boîte de chocolats importée", 10.00, true, Category.FOOD),
            new ProductInputDTO("flacon de parfum importé", 47.50, true, Category.OTHER)
        );
        BillOutputDTO result = billService.generateBill(products);

        assertEquals(65.15, result.total(), 0.001);
        assertEquals(7.65, result.totalTaxes(), 0.001);
    }

    @Test
    void testInput3() {
        List<ProductInputDTO> products = List.of(
            new ProductInputDTO("flacon de parfum importé", 27.99, true, Category.OTHER),
            new ProductInputDTO("flacon de parfum", 18.99, false, Category.OTHER),
            new ProductInputDTO("boîte de pilules contre la migraine", 9.75, false, Category.MEDICAL),
            new ProductInputDTO("boîte de chocolats importés", 11.25, true, Category.FOOD)
        );
        BillOutputDTO result = billService.generateBill(products);

        assertEquals(74.68, result.total(), 0.001);
        assertEquals(6.70, result.totalTaxes(), 0.001);
    }
}
