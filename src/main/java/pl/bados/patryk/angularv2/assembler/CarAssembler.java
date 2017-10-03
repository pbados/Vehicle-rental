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
        vehicleDto.setProducer(car.getProducer().getProducerName());
        vehicleDto.setProductionDate(car.getProductionDate());
        vehicleDto.setVehicleName(car.getVehicleName());
        vehicleDto.setBorrowsDto(car.getBorrows());

        return vehicleDto;
    }

    public CarDto fromCarToCarDtoWithoutId(Car car){
        CarDto carDto = new CarDto(car.getVehicleName(), car.getColor(), car.getProductionDate(), car.getProducer().getId(), car.getType());
        carDto.setBorrowsDto(car.getBorrows());
        return carDto;
    }

    public CarDto fromCarToCarDtoWithId(Car car){
        CarDto carDto = new CarDto(car.getVehicleName(), car.getColor(), car.getProductionDate(), car.getProducer().getProducerName(), car.getVehicleId(), car.getType());
        carDto.setBorrowsDto(car.getBorrows());
        return carDto;
    }

    public Car fromCarDtoToCar(CarDto carDto){
        Car car = new Car();
        car.setColor(carDto.getColor());
        car.setVehicleId(carDto.getId());
        car.setProducer(producerRepository.getOne(carDto.getProducerId()));
        car.setProductionDate(carDto.getProductionDate());
        car.setVehicleName(carDto.getVehicleName());

        return car;
    }

    public Car fromCarDtoToCarWithoutId(CarDto carDto){
        Car car = new Car();
        car.setColor(carDto.getColor());
        car.setProducer(producerRepository.getOne(carDto.getProducerId()));
        car.setProductionDate(carDto.getProductionDate());
        car.setVehicleName(carDto.getVehicleName());

        return car;
    }

    public CarAssembler() {
    }
}
