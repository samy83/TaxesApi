package com.example.taxesapi.service;

import com.example.taxesapi.dto.BillOutputDTO;
import com.example.taxesapi.dto.ProductInputDTO;
import com.example.taxesapi.model.Product;
import com.example.taxesapi.util.TaxUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillService {
    public BillOutputDTO generateBill(List<ProductInputDTO> inputs) {
        List<BillOutputDTO.Item> items = new ArrayList<>();
        double totalTaxes = 0;
        double total = 0;

        for (ProductInputDTO input : inputs) {
            Product p = new Product(input.name(), input.price(), input.imported(), input.category());
            double taxRate = 0;
            if (!p.isExempt()) taxRate += 0.10;
            if (p.isImported()) taxRate += 0.05;

            double tax = TaxUtils.roundTax(p.getPrice() * taxRate);
            double priceTTC = p.getPrice() + tax;

            totalTaxes += tax;
            total += priceTTC;
            items.add(new BillOutputDTO.Item(p.getName(), TaxUtils.roundTo2Decimals(priceTTC)));
        }

        return new BillOutputDTO(
            items,
            TaxUtils.roundTo2Decimals(totalTaxes),
            TaxUtils.roundTo2Decimals(total)
        );
    }
}
