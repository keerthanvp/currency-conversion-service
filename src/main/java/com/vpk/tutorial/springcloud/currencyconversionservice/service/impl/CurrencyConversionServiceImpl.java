package com.vpk.tutorial.springcloud.currencyconversionservice.service.impl;

import com.vpk.tutorial.springcloud.currencyconversionservice.model.CurrencyConversion;
import com.vpk.tutorial.springcloud.currencyconversionservice.proxy.CurrencyExchangeProxy;
import com.vpk.tutorial.springcloud.currencyconversionservice.service.CurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {

    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;

    @Override
    public CurrencyConversion convert(String from, String to, Double quantity) {
        CurrencyConversion currencyConversion = currencyExchangeProxy.retrieve(from, to);
        currencyConversion.setQuantity(quantity);
        currencyConversion.setTotalCalculatedAmount(quantity * currencyConversion.getConversionMultiple());
        return currencyConversion;
    }

}
