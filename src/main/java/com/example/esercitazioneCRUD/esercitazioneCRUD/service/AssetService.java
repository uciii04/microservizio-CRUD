package com.example.esercitazioneCRUD.esercitazioneCRUD.service;

import java.util.List;
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

        return assets.stream()                       //Collections .stream() per creare uno stream dalla lista
                     .map(AssetMapper::toDTO)        //Method reference che abbrevia il codice
                     .collect(Collectors.toList());  //Collectors .toList() per convertire lo stream in una lista
    }

    public void cancellaAsset(Long id) {
        AssetModel asset = assetRepository.findById(id)   //Optional
                .orElseThrow(() ->                        //Lambda expression e Concetto di Eccezioni unchecked per gestire il caso in cui l'asset non venga trovato
                        new RuntimeException("Asset non trovato con ID: " + id)
                );

        assetRepository.delete(asset);
    }

}