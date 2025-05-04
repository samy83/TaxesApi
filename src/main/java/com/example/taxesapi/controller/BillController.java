package com.example.taxesapi.controller;

import com.example.taxesapi.dto.BillOutputDTO;
import com.example.taxesapi.dto.ProductInputDTO;
import com.example.taxesapi.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/api/bill")
public class BillController {
    @Autowired
    private BillService billService;

    @PostMapping
    public BillOutputDTO calculateBill(@RequestBody List<ProductInputDTO> products) {
        return billService.generateBill(products);
    }
}
