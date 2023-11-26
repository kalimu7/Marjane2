package com.brief.marjane2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private int IdP;

    private String Titre;

    private float Prix;

    private String Image;

    private String Description;

    private Integer quantite;

    //private CategoryDto category;




}
