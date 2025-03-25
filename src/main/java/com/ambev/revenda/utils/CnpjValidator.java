package com.ambev.revenda.utils;

import org.springframework.stereotype.Service;

@Service
public class CnpjValidator {
    public boolean isValid(String cnpj) {
        return cnpj != null && cnpj.matches("\\d{14}");
    }
}
