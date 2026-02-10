package com.example.esercitazioneCRUD.esercitazioneCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.esercitazioneCRUD.esercitazioneCRUD.model.AssetModel;

                                                      //Uso Generics per specificare il tipo di entità e il tipo della chiave primaria
public interface AssetRepository extends JpaRepository<AssetModel, Long>{

}
