package com.example.esercitazioneCRUD.esercitazioneCRUD;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.esercitazioneCRUD.esercitazioneCRUD.dto.AssetDTO;
import com.example.esercitazioneCRUD.esercitazioneCRUD.model.AssetModel;
import com.example.esercitazioneCRUD.esercitazioneCRUD.repository.AssetRepository;
import com.example.esercitazioneCRUD.esercitazioneCRUD.service.AssetService;

@ExtendWith(MockitoExtension.class)
public class AssetServiceTest {

    @Mock
    private AssetRepository assetRepository;

    @InjectMocks
    private AssetService assetService;

    @Test
    void returnsAssets() {
        when(assetRepository.findAll()).thenReturn(List.of(new AssetModel()));

        List<AssetDTO> result = assetService.trovaTutti();

        verify(assetRepository).findAll();
        assertFalse(result.isEmpty());
    }
    
}
