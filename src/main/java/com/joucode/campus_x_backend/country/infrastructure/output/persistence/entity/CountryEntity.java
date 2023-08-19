package com.joucode.campus_x_backend.country.infrastructure.output.persistence.entity;

import com.joucode.campus_x_backend.address.infrastructure.adapters.output.persistence.entity.AddressEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @OneToOne(mappedBy = "country", fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    private AddressEntity address;


}
