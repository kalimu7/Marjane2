package com.brief.marjane2.entity;

import com.brief.marjane2.enums.roles;
import com.brief.marjane2.enums.roles.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor

@Entity
@Table(name = "Caissier")
public class Caissier extends User {


}
