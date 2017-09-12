package pl.bados.patryk.angularv2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bados.patryk.angularv2.assembler.BikeAssembler;
import pl.bados.patryk.angularv2.assembler.BorrowAssembler;
import pl.bados.patryk.angularv2.assembler.CarAssembler;
import pl.bados.patryk.angularv2.assembler.EditCarAssembler;
import pl.bados.patryk.angularv2.dto.BorrowDto;
import pl.bados.patryk.angularv2.dto.CarDto;
import pl.bados.patryk.angularv2.dto.EditCarDto;
import pl.bados.patryk.angularv2.dto.VehicleDto;
import pl.bados.patryk.angularv2.model.Bike;
import pl.bados.patryk.angularv2.model.Borrow;
import pl.bados.patryk.angularv2.model.Car;
import pl.bados.patryk.angularv2.model.Vehicle;
import pl.bados.patryk.angularv2.repository.BorrowRepository;
import pl.bados.patryk.angularv2.repository.VehicleRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService{

    private final VehicleRepository vehicleRepository;
    private final CarAssembler carAssembler;
    private final EditCarAssembler editCarAssembler;
    private final BikeAssembler bikeAssembler;
    private final BorrowAssembler borrowAssembler;
    private final BorrowRepository borrowRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository, CarAssembler carAssembler, BikeAssembler bikeAssembler, EditCarAssembler editCarAssembler, BorrowRepository borrowRepository, BorrowAssembler borrowAssembler) {
        this.vehicleRepository = vehicleRepository;
        this.carAssembler = carAssembler;
        this.bikeAssembler = bikeAssembler;
        this.editCarAssembler = editCarAssembler;
        this.borrowRepository = borrowRepository;
        this.borrowAssembler = borrowAssembler;
    }

    @Override
    public VehicleDto findVehicle(Long id) {
        Vehicle vehicle = vehicleRepository.findOne(id);
        if(vehicle instanceof Car){
            return carAssembler.fromCarToCarDto((Car) vehicle);
        }else if(vehicle instanceof Bike){
            return bikeAssembler.fromBikeToBikeDto((Bike) vehicle);
        }
        return null;
    }

    @Override
    public void createBike(String name) {
        Bike bike = new Bike(name);
        vehicleRepository.save(bike);
    }

    @Override
    public void createCar(CarDto carDto) {
        vehicleRepository.save(carAssembler.fromCarDtoToCar(carDto));
    }

    @Override
    public void editCar(EditCarDto editCarDto) {
        Car car = (Car) vehicleRepository.findOne(editCarDto.getVehicleId());
        car = editCarAssembler.fromEditCarDtoToCar(editCarDto);
        vehicleRepository.save(car);
    }

    @Override
    public void deleteVehicle(Long id) {
        vehicleRepository.delete(id);
    }

    @Override
    public List<VehicleDto> findAll() {
        return vehicleRepository.findAll().stream().map(vehicle ->{
            if(vehicle instanceof Car){
                return carAssembler.fromCarToCarDto((Car) vehicle);
            }
            else if(vehicle instanceof Bike){
                return bikeAssembler.fromBikeToBikeDto((Bike) vehicle);
            }
            return null;
        }).collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> getVehiclesByBorrowDate(LocalDate date) {
        List<VehicleDto> vehicleDtos = findAll();
        vehicleDtos.forEach(vehicleDto -> vehicleDto.findAndSetBorrowerIfPresentForDate(date));
        return vehicleDtos;
    }


}
