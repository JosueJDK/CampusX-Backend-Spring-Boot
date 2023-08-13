package com.joucode.campus_x_backend.address.infrastructure.adapters.province.output.persistence.entity;

import com.joucode.campus_x_backend.address.infrastructure.adapters.city.output.persistence.entity.CityEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "province_table")
public class ProvinceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "province_id")
    private Long provinceId;

    @Column(name = "province_name", nullable = false, length = 100)
    private String name;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id", nullable = false)
    private CityEntity city;

}
