package com.joucode.campus_x_backend.province.infrastructure.output.persistence.entity;

import com.joucode.campus_x_backend.address.infrastructure.adapters.output.persistence.entity.AddressEntity;
import com.joucode.campus_x_backend.city.infrastructure.output.persistence.entity.CityEntity;
import com.joucode.campus_x_backend.district.infrastructure.output.persistence.entity.DistrictEntity;
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
@Table(name = "province_table")
public class ProvinceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "province_id")
    private Long provinceId;

    @Column(name = "province_name", nullable = false, length = 100)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false)
    private CityEntity city;

    @OneToOne(mappedBy = "province", fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    private AddressEntity address;
}
