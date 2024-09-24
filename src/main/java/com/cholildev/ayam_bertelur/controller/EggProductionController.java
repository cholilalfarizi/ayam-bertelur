package com.cholildev.ayam_bertelur.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cholildev.ayam_bertelur.dto.EggProductionRequestDTO;
import com.cholildev.ayam_bertelur.dto.MessageResponseDTO;
import com.cholildev.ayam_bertelur.dto.ResponseBodyDTO;
import com.cholildev.ayam_bertelur.service.EggProductionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/eggs")
@RequiredArgsConstructor
public class EggProductionController {

    private final EggProductionService eggProductionService;

    @PostMapping
    public ResponseEntity<MessageResponseDTO> produceEggs(@RequestBody EggProductionRequestDTO request) {
        MessageResponseDTO response = eggProductionService.createEggProduction(request);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }

    @GetMapping
    public ResponseEntity<ResponseBodyDTO> getSales() {
        ResponseBodyDTO responseBodyDTO = eggProductionService.getEggProductionRecap();
        return ResponseEntity.ok(responseBodyDTO);
    }
}
