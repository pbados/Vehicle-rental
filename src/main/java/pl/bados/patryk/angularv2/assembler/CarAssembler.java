package pl.bados.patryk.angularv2.assembler;

import pl.bados.patryk.angularv2.dto.CarDto;
import pl.bados.patryk.angularv2.model.Car;

public class CarAssembler {

//    public CarDto formCarToCarDto(Car car){
//        CarDto carDto = new CarDto();
//        carDto.setColor(car.getColor());
//        //carDto.setProducerName(car.getProducerName().getProducerName());
//        carDto.setProductionDate(car.getProductionDate());
//        carDto.setVehicleName(car.getVehicleName());
//
//        return carDto;
//    }
//
    public Car fromCarDtoToCar(CarDto carDto){
        Car car = new Car();
        car.setColor(carDto.getColor());
        //car.setProducerName(carDto.get);
        car.setProductionDate(carDto.getProductionDate());
        car.setVehicleName(carDto.getVehicleName());

        return car;
    }

    public CarAssembler() {
    }
}
