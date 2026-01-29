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

import com.example.esercitazioneCRUD.esercitazioneCRUD.dto.AssetDTO;
import com.example.esercitazioneCRUD.esercitazioneCRUD.service.AssetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/assets")
public class AssetController {
	
	@Autowired
	private AssetService assetService;
	
	@PostMapping
	public AssetDTO createAsset(@Valid @RequestBody AssetDTO assetDTO) {
		return assetService.salvaAsset(assetDTO);
	}
	
	@GetMapping
	public List<AssetDTO> getAllAssets() {
		return assetService.trovaTutti();
	}
	
	@DeleteMapping("/{id}")
	public void deleteAsset(@PathVariable Long id) {
	    assetService.cancellaAsset(id);
	}

}
