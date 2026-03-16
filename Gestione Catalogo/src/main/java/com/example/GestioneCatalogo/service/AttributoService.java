package com.example.GestioneCatalogo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GestioneCatalogo.model.Attributo;
import com.example.GestioneCatalogo.repository.AttributoRepository;

@Service
public class AttributoService {
	
	@Autowired
	private AttributoRepository attributoRepository;
	
	public Attributo creaAttributo(Attributo attributo) {
		return attributoRepository.save(attributo);
	}
	
	public List<Attributo> getAllAttributi() {
		return attributoRepository.findAll();
	}

}
