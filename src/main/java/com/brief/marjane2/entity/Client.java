package com.brief.marjane2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Client")
public class Client extends User{

    @OneToOne(mappedBy = "client")
    private CarteFidelité carteFidelité;

}
