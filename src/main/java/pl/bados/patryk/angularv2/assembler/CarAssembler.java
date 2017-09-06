package pl.bados.patryk.angularv2.assembler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.bados.patryk.angularv2.dto.CarDto;
import pl.bados.patryk.angularv2.model.Car;
import pl.bados.patryk.angularv2.repository.ProducerRepository;

@Component
public class CarAssembler {

    @Autowired
    ProducerRepository producerRepository;

    public CarDto formCarToCarDto(Car car){
        CarDto carDto = new CarDto();
        carDto.setColor(car.getColor());
        carDto.setProducerName(car.getProducer().getId());
        carDto.setProductionDate(car.getProductionDate());
        carDto.setVehicleName(car.getVehicleName());

        return carDto;
    }

    public Car fromCarDtoToCar(CarDto carDto){
        Car car = new Car();
        car.setColor(carDto.getColor());
        car.setProducer(producerRepository.getOne(carDto.getProducerName()));
        car.setProductionDate(carDto.getProductionDate());
        car.setVehicleName(carDto.getVehicleName());

        return car;
    }

    public CarAssembler() {
    }
}
