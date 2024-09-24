package com.cholildev.ayam_bertelur.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EggProductionRequestDTO {
    private Long chickenId;
    private Integer eggsProduced;
    private Date productionDate;
}
