package com.vpk.tutorial.springcloud.currencyconversionservice.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CurrencyConversion {

    private Integer id;
    private String from;
    private String to;
    private Double quantity;
    private Double conversionMultiple;
    private Double totalCalculatedAmount;
    private String environment;
}
