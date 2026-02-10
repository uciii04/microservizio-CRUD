package com.example.esercitazioneCRUD.esercitazioneCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.esercitazioneCRUD.esercitazioneCRUD.model.AssetModel;
                                                      
                                                       //Generics (per legare il repository ad AssetModel e con tipo di ID)
public interface AssetRepository extends JpaRepository<AssetModel, Long>{

}
