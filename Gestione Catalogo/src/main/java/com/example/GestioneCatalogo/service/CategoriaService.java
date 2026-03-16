package com.example.GestioneCatalogo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GestioneCatalogo.model.Categoria;
import com.example.GestioneCatalogo.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria creaCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
    
    public List<Categoria> recuperaTutte() {
        return categoriaRepository.findAll();
    }

}
