package pl.bados.patryk.angularv2.service;

import pl.bados.patryk.angularv2.dto.CarDto;
import pl.bados.patryk.angularv2.dto.EditCarDto;
import pl.bados.patryk.angularv2.dto.VehicleDto;

import java.time.LocalDate;
import java.util.List;

public interface VehicleService {

    VehicleDto findVehicle(Long id);
    void createBike(String name);
    void createCar(CarDto carDto);
    void editCar(EditCarDto editCarDto);
    void deleteVehicle(Long id);
    List<VehicleDto> findAll();
    List<VehicleDto> getVehiclesByBorrowDate(LocalDate date);

}
