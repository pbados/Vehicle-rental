package pl.bados.patryk.angularv2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.bados.patryk.angularv2.assembler.CarAssembler;
import pl.bados.patryk.angularv2.assembler.EditCarAssembler;
import pl.bados.patryk.angularv2.dto.CarDto;
import pl.bados.patryk.angularv2.dto.EditCarDto;
import pl.bados.patryk.angularv2.model.Color;
import pl.bados.patryk.angularv2.repository.VehicleRepository;

import java.time.LocalDate;

@Component
public class CarServiceImpl implements CarService {

    private VehicleRepository vehicleRepository;
    private CarAssembler carAssembler;
    private EditCarAssembler editCarAssembler;

    @Autowired
    public CarServiceImpl(VehicleRepository vehicleRepository, CarAssembler carAssembler, EditCarAssembler editCarAssembler){
        this.vehicleRepository = vehicleRepository;
        this.carAssembler = carAssembler;
        this.editCarAssembler = editCarAssembler;
    }

    @Override
    public CarDto addCar(String vehicleName, Color color, LocalDate productionDate, Long producer) {
        CarDto carDto = new CarDto(vehicleName, color, productionDate, producer);
        return carDto;
    }

    @Override
    public void saveCar(CarDto carDto) {
        vehicleRepository.save(carAssembler.fromCarDtoToCar(carDto));

    }

    @Override
    public void saveEditedCar(EditCarDto editCarDto) {
        vehicleRepository.save(editCarAssembler.fromEditCarDtoToCar(editCarDto));
    }

    @Override
    public EditCarDto editCar(Long vehicleId, String vehicleName, Color color, LocalDate productionDate, Long producer) {
        EditCarDto editCarDto = new EditCarDto(vehicleId, vehicleName, color, productionDate, producer);
        return editCarDto;
    }
}
