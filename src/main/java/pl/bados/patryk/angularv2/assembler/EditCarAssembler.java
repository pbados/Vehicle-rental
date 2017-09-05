package pl.bados.patryk.angularv2.assembler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.bados.patryk.angularv2.dto.CarDto;
import pl.bados.patryk.angularv2.dto.EditCarDto;
import pl.bados.patryk.angularv2.model.Car;
import pl.bados.patryk.angularv2.repository.ProducerRepository;

@Component
public class EditCarAssembler {
    @Autowired
    ProducerRepository producerRepository;

    public CarDto formCarToEditCarDto(Car car){
        CarDto carDto = new CarDto();
        carDto.setVehicleId(car.getVehicleId());
        carDto.setColor(car.getColor());
        carDto.setProducerName(car.getProducerName().getId());
        carDto.setProductionDate(car.getProductionDate());
        carDto.setVehicleName(car.getVehicleName());

        return carDto;
    }

    public Car fromEditCarDtoToCar(EditCarDto editCarDto){
        Car car = new Car();
        car.setVehicleId(editCarDto.getVehicleId());
        car.setColor(editCarDto.getColor());
        car.setProducerName(producerRepository.getOne(editCarDto.getProducerName()));
        car.setProductionDate(editCarDto.getProductionDate());
        car.setVehicleName(editCarDto.getVehicleName());

        return car;
    }

    public EditCarAssembler() {
    }
}
