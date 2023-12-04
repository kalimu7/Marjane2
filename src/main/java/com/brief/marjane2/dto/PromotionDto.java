package com.brief.marjane2.dto;

import com.brief.marjane2.enums.category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromotionDto {

    private int IdPr;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String status;
    private category category;


}
