package com.example.GestioneCatalogo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GestioneCatalogo.model.Listino;
import com.example.GestioneCatalogo.repository.ListinoRepository;

@Service
public class ListinoService {
    @Autowired
    private ListinoRepository listinoRepository;

    public Listino creaListino(Listino listino) {
        return listinoRepository.save(listino);
    }

    public List<Listino> recuperaTutti() {
        return listinoRepository.findAll();
    }

}
