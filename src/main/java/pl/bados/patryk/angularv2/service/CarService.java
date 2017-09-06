package pl.bados.patryk.angularv2.service;

import pl.bados.patryk.angularv2.dto.CarDto;
import pl.bados.patryk.angularv2.dto.EditCarDto;
import pl.bados.patryk.angularv2.model.Color;

import java.time.LocalDate;

public interface CarService {

    CarDto addCar(String vehicleName, Color color, LocalDate productionDate, Long producer);
    void saveCar(CarDto carDto);
    void saveEditedCar(EditCarDto editCarDto);
    EditCarDto editCar(Long vehicleId, String vehicleName, Color color, LocalDate productionDate, Long producer);

}
