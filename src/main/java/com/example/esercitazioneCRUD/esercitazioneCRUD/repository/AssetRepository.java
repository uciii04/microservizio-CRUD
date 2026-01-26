package com.example.esercitazioneCRUD.esercitazioneCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.esercitazioneCRUD.esercitazioneCRUD.model.AssetModel;

public interface AssetRepository extends JpaRepository<AssetModel, Long>{

}
