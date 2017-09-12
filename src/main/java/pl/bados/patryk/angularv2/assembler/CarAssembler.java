package pl.bados.patryk.angularv2.assembler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.bados.patryk.angularv2.dto.CarDto;
import pl.bados.patryk.angularv2.dto.VehicleDto;
import pl.bados.patryk.angularv2.model.Car;
import pl.bados.patryk.angularv2.repository.ProducerRepository;

@Component
public class CarAssembler {

    @Autowired
    ProducerRepository producerRepository;

    public VehicleDto fromCarToVehicleDto(Car car){
        VehicleDto vehicleDto = new VehicleDto();
        vehicleDto.setColor(car.getColor());
        vehicleDto.setProducer(car.getProducer().getId());
        vehicleDto.setProductionDate(car.getProductionDate());
        vehicleDto.setVehicleName(car.getVehicleName());
        vehicleDto.setBorrowsDto(car.getBorrows());

        return vehicleDto;
    }

    public CarDto fromCarToCarDto(Car car){
        CarDto carDto = new CarDto(car.getVehicleName(), car.getColor(), car.getProductionDate(), car.getProducer().getId());
        carDto.setBorrowsDto(car.getBorrows());
        return carDto;
    }

    public Car fromCarDtoToCar(CarDto carDto){
        Car car = new Car();
        car.setColor(carDto.getColor());
        car.setProducer(producerRepository.getOne(carDto.getProducer()));
        car.setProductionDate(carDto.getProductionDate());
        car.setVehicleName(carDto.getVehicleName());

        return car;
    }

    public CarAssembler() {
    }
}
