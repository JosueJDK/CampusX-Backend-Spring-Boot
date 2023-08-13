package com.joucode.campus_x_backend.address.infrastructure.adapters.address.output.persistence.entity;

import com.joucode.campus_x_backend.address.infrastructure.adapters.city.output.persistence.entity.CityEntity;
import com.joucode.campus_x_backend.address.infrastructure.adapters.country.output.persistence.entity.CountryEntity;
import com.joucode.campus_x_backend.address.infrastructure.adapters.district.output.persistence.entity.DistrictEntity;
import com.joucode.campus_x_backend.address.infrastructure.adapters.province.output.persistence.entity.ProvinceEntity;
import com.joucode.campus_x_backend.profile.infrastructure.adapters.output.persistence.entity.UserProfileEntity;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

@Entity
@Table(name = "address_table")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id", nullable = false)
    private CountryEntity country;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id", nullable = false)
    private CityEntity city;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "province_id", nullable = false)
    private ProvinceEntity province;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "district_id", nullable = false)
    private DistrictEntity district;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    private UserProfileEntity userProfile;


}
