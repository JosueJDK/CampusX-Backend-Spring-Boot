package com.joucode.campus_x_backend.district.infrastructure.output.persistence.entity;


import com.joucode.campus_x_backend.address.infrastructure.adapters.output.persistence.entity.AddressEntity;
import com.joucode.campus_x_backend.city.infrastructure.output.persistence.entity.CityEntity;
import com.joucode.campus_x_backend.province.infrastructure.output.persistence.entity.ProvinceEntity;
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
@Table(name = "district_table")
public class DistrictEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "district_id")
    private Long districtId;

    @Column(name = "district_name", nullable = false, length = 100)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "province_id", nullable = false)
    private ProvinceEntity province;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false)
    private CityEntity city;

    @OneToOne(mappedBy = "district", fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    private AddressEntity address;
}
