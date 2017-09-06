package pl.bados.patryk.angularv2.service;

import pl.bados.patryk.angularv2.dto.BikeDto;

public interface BikeService {

    BikeDto addBike(String vehicleName);
    void saveBike(BikeDto bikeDto);
}
