package com.cholildev.ayam_bertelur.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EggProductionDTO {
    private Long productionId;
    private Long chickenId;
    private Integer eggsProduced;
    private Date productionDate;
}
