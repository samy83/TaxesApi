package com.example.taxesapi.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxUtils {
    public static double roundTax(double value) {
        return new BigDecimal(Math.ceil(value * 20.0) / 20.0)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }


    public static double roundTo2Decimals(double value) {
        return BigDecimal.valueOf(value)
                         .setScale(2, RoundingMode.HALF_UP)
                         .doubleValue();
    }
}
