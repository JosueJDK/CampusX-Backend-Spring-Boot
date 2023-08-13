package com.joucode.campus_x_backend.address.infrastructure.adapters.country.output.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "country_table")
public class CountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Long countryId;

    @Column(name = "country_name", nullable = false, length = 100)
    private String name;

    @Column(name = "country_code", nullable = false, length = 4)
    private String code;

}
