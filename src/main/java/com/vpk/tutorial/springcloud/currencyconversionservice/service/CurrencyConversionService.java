package com.vpk.tutorial.springcloud.currencyconversionservice.service;

import com.vpk.tutorial.springcloud.currencyconversionservice.model.CurrencyConversion;

public interface CurrencyConversionService {
    CurrencyConversion convert(String from, String to, Double quantity);
}
