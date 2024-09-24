package com.cholildev.ayam_bertelur.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cholildev.ayam_bertelur.dto.EggProductionDTO;
import com.cholildev.ayam_bertelur.dto.EggProductionRequestDTO;
import com.cholildev.ayam_bertelur.dto.MessageResponseDTO;
import com.cholildev.ayam_bertelur.dto.ResponseBodyDTO;
import com.cholildev.ayam_bertelur.model.Chicken;
import com.cholildev.ayam_bertelur.model.EggProduction;
import com.cholildev.ayam_bertelur.repository.ChickenRepository;
import com.cholildev.ayam_bertelur.repository.EggProductionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EggProductionService {

    private final EggProductionRepository eggProductionRepository;
    private final ChickenRepository chickenRepository;

    public MessageResponseDTO createEggProduction(EggProductionRequestDTO request) {
        Optional<Chicken> chickenOpt = chickenRepository.findById(request.getChickenId());

        if (!chickenOpt.isPresent()) {
            String message = "Chicken with id " + request.getChickenId() + " not found";
            return new MessageResponseDTO(message, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name());
        }

        Chicken chicken = chickenOpt.get();

        EggProduction eggProduction = new EggProduction();
        eggProduction.setChicken(chicken);
        eggProduction.setEggsProduced(request.getEggsProduced());
        eggProduction.setProductionDate(request.getProductionDate());

        eggProductionRepository.save(eggProduction);

        return new MessageResponseDTO("Egg production recorded successfully", HttpStatus.OK.value(),
                HttpStatus.OK.name());
    }

    public ResponseBodyDTO getEggProductionRecap() {
        List<EggProduction> productions = eggProductionRepository.findAll();

        List<EggProductionDTO> data = productions.stream().map(production -> {
            EggProductionDTO dto = new EggProductionDTO();
            dto.setProductionId(production.getId());
            dto.setChickenId(production.getChicken().getId());
            dto.setEggsProduced(production.getEggsProduced());
            dto.setProductionDate(production.getProductionDate());
            return dto;
        }).collect(Collectors.toList());

        return new ResponseBodyDTO(HttpStatus.OK.name(),
                HttpStatus.OK.value(),
                "Berhasil memuat data produksi telur", data);
    }
}
