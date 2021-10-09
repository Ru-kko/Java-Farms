package com.fincas.app.services;

import com.fincas.app.crud.category.categoryQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class categoryService {
    @Autowired
    private categoryQuery categoryRep;
}
