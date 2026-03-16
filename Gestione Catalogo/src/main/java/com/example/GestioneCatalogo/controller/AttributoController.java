package com.example.GestioneCatalogo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GestioneCatalogo.model.Attributo;
import com.example.GestioneCatalogo.service.AttributoService;

@RestController
@RequestMapping("/attributes")
public class AttributoController {
	
	@Autowired
    private AttributoService attributoService;

    // http://localhost:8080/attributes
    @PostMapping
    public Attributo creaAttributo(@RequestBody Attributo attributo) {
        return attributoService.creaAttributo(attributo);
    }

    // http://localhost:8080/attributes
    @GetMapping
    public List<Attributo> getAllAttributi() {
        return attributoService.getAllAttributi();
    }

}
