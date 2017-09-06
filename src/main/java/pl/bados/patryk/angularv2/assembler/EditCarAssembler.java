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

    public EditCarDto formCarToEditCarDto(Car car){
        EditCarDto editCarDto = new EditCarDto();
        editCarDto.setVehicleId(car.getVehicleId());
        editCarDto.setColor(car.getColor());
        editCarDto.setProducerName(car.getProducer().getId());
        editCarDto.setProductionDate(car.getProductionDate());
        editCarDto.setVehicleName(car.getVehicleName());

        return editCarDto;
    }

    public Car fromEditCarDtoToCar(EditCarDto editCarDto){
        Car car = new Car();
        car.setVehicleId(editCarDto.getVehicleId());
        car.setColor(editCarDto.getColor());
        car.setProducer(producerRepository.getOne(editCarDto.getProducerName()));
        car.setProductionDate(editCarDto.getProductionDate());
        car.setVehicleName(editCarDto.getVehicleName());

        return car;
    }

    public EditCarAssembler() {
    }
}
