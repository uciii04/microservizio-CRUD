package com.example.esercitazioneCRUD.esercitazioneCRUD.mapper;

import com.example.esercitazioneCRUD.esercitazioneCRUD.dto.AssetDTO;
import com.example.esercitazioneCRUD.esercitazioneCRUD.model.AssetModel;

public class AssetMapper {
	
	// Trasforma il DTO in Model (per salvare nel DB)
	public static AssetModel toEntity(AssetDTO dto) {
		if (dto == null ) return null;
		AssetModel model = new AssetModel();
		model.setNome(dto.getNome());
		model.setTipo(dto.getTipo());
		model.setCodiceSeriale(dto.getCodiceSeriale());
		return model;
    }
	
	// Trasforma il Model in DTO (per rispondere all'utente)
	public static AssetDTO toDTO(AssetModel model) {
		if (model == null) return null;
		AssetDTO dto = new AssetDTO();
		dto.setId(model.getId());
		dto.setNome(model.getNome());
		dto.setTipo(model.getTipo());
		dto.setCodiceSeriale(model.getCodiceSeriale());
		return dto;
	}

}
