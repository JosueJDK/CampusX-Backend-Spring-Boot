package com.joucode.campus_x_backend.address.application.use_cases;

import com.joucode.campus_x_backend.address.domain.models.Address;
import com.joucode.campus_x_backend.address.domain.ports.input.CreateAddressUserProfileUseCase;
import com.joucode.campus_x_backend.address.domain.ports.output.AddressRepositoryPort;
import com.joucode.campus_x_backend.city.application.services.CityService;
import com.joucode.campus_x_backend.country.application.services.CountryService;
import com.joucode.campus_x_backend.district.application.services.DistrictService;
import com.joucode.campus_x_backend.province.application.services.ProvinceService;
import com.joucode.campus_x_backend.user_profile.application.service.UserProfileService;
import com.joucode.campus_x_backend.user_profile.domain.models.UserProfile;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateAddressUserProfileUseCaseImpl implements CreateAddressUserProfileUseCase {

    private final AddressRepositoryPort repositoryPort;
    private final UserProfileService userProfileService;
    private final CountryService countryService;
    private final CityService cityService;
    private final ProvinceService provinceService;
    private final DistrictService districtService;

    @Override
    public UserProfile save(Long userProfileId, Address address) {
        UserProfile userProfile = userProfileService.findById(userProfileId);
        address.setCountry(countryService.getById(address.getCountry().getCountryId()));
        address.setCity(cityService.getById(address.getCity().getCityId()));
        address.setProvince(provinceService.getById(address.getProvince().getProvinceId()));
        address.setDistrict(districtService.getById(address.getDistrict().getDistrictId()));
        userProfile.setInfoAddress(repositoryPort.save(address));
        return  userProfileService.save(userProfile);
    }
}
