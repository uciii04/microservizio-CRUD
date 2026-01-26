package com.example.esercitazioneCRUD.esercitazioneCRUD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.esercitazioneCRUD.esercitazioneCRUD.model.AssetModel;
import com.example.esercitazioneCRUD.esercitazioneCRUD.repository.AssetRepository;

@RestController
@RequestMapping("/api/assets")
public class AssetController {
	
	@Autowired
	private AssetRepository assetRepository;
	
	@PostMapping
	public AssetModel createAsset(@RequestBody AssetModel assetModel) {
		return assetRepository.save(assetModel);
	}
	
	@GetMapping
	public List<AssetModel> getAllAssets() {
		return assetRepository.findAll();
	}
	
	@DeleteMapping("/{id}")
	public void deleteAsset(@PathVariable Long id) {
	    assetRepository.deleteById(id);
	}

}
