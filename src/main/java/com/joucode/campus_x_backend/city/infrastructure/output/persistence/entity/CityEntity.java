package com.joucode.campus_x_backend.city.infrastructure.output.persistence.entity;

import com.joucode.campus_x_backend.address.infrastructure.adapters.output.persistence.entity.AddressEntity;
import com.joucode.campus_x_backend.country.infrastructure.output.persistence.entity.CountryEntity;
import com.joucode.campus_x_backend.province.infrastructure.output.persistence.entity.ProvinceEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "city_table")
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Long cityId;

    @Column(name = "city_name", nullable = false, length = 100)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false)
    private CountryEntity country;

    @OneToOne(mappedBy = "city", fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    private AddressEntity address;

}
