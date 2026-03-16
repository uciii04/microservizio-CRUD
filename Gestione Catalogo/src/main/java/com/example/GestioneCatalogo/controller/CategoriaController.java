package com.example.GestioneCatalogo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GestioneCatalogo.model.Categoria;
import com.example.GestioneCatalogo.service.CategoriaService;

@RestController
@RequestMapping("categories")
public class CategoriaController {
	
	@Autowired
    private CategoriaService categoriaService;

	// http://localhost:8080/categories
    @PostMapping
    public Categoria creaCategoria(@RequestBody Categoria categoria) {
        return categoriaService.creaCategoria(categoria);
    }
    
    // http://localhost:8080/categories
    @GetMapping
    public List<Categoria> getCategorie() {
        return categoriaService.recuperaTutte();
    }

}
