package com.example.esercitazioneCRUD.esercitazioneCRUD.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.esercitazioneCRUD.esercitazioneCRUD.dto.AssetDTO;
import com.example.esercitazioneCRUD.esercitazioneCRUD.mapper.AssetMapper;
import com.example.esercitazioneCRUD.esercitazioneCRUD.model.AssetModel;
import com.example.esercitazioneCRUD.esercitazioneCRUD.repository.AssetRepository;

@Service
public class AssetService {

    @Autowired
    private AssetRepository assetRepository;

    public AssetDTO salvaAsset(AssetDTO dto) {
        AssetModel model = AssetMapper.toEntity(dto);
        AssetModel savedModel = assetRepository.save(model);
        return AssetMapper.toDTO(savedModel);
    }

    public List<AssetDTO> trovaTutti() {
        List<AssetModel> assets = assetRepository.findAll();
        return assets.stream()                          // Collection
                     .map(AssetMapper::toDTO)           // Method reference
                     .collect(Collectors.toList());     // Collectors
    }

    public void cancellaAsset(Long id) {
    Optional<AssetModel> assetOpt = assetRepository.findById(id); //Utilizzo Optional

    AssetModel asset = assetOpt.orElseThrow(() -> new RuntimeException("Asset non trovato con ID: " + id) //Concetto di Eccezioni unchecked + Lambda expression
    );

    assetRepository.delete(asset);
    }

}