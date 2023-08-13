package com.joucode.campus_x_backend.address.infrastructure.adapters.district.output.persistence.entity;


import com.joucode.campus_x_backend.address.infrastructure.adapters.province.output.persistence.entity.ProvinceEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "district_table")
public class DistrictEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "district_id")
    private Long districtId;

    @Column(name = "district_name", nullable = false, length = 100)
    private String name;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "province_id", nullable = false)
    private ProvinceEntity provinceEntity;

}
