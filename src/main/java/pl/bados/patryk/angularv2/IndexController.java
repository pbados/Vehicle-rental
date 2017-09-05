package pl.bados.patryk.angularv2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.bados.patryk.angularv2.assembler.BikeAssembler;
import pl.bados.patryk.angularv2.assembler.BorrowAssembler;
import pl.bados.patryk.angularv2.assembler.CarAssembler;
import pl.bados.patryk.angularv2.assembler.EditCarAssembler;
import pl.bados.patryk.angularv2.dto.BikeDto;
import pl.bados.patryk.angularv2.dto.BorrowDto;
import pl.bados.patryk.angularv2.dto.CarDto;
import pl.bados.patryk.angularv2.dto.EditCarDto;
import pl.bados.patryk.angularv2.model.*;
import pl.bados.patryk.angularv2.repository.*;
import pl.bados.patryk.angularv2.service.BorrowService;
import pl.bados.patryk.angularv2.service.BorrowServiceImpl;

import java.time.LocalDate;
import java.util.List;

@RestController
public class IndexController {

    @Autowired
    BorrowAssembler borrowAssembler;

    @Autowired
    CarAssembler carAssembler;

    @Autowired
    BikeAssembler bikeAssembler;

    @Autowired
    EditCarAssembler editCarAssembler;

    private VehicleRepository vehicleRepository;
    private BikeRepository bikeRepository;
    private BorrowerRepository borrowerRepository;
    private BorrowRepository borrowRepository;
    private ProducerRepository producerRepository;

    @Autowired
    public IndexController(VehicleRepository vehicleRepository, BikeRepository bikeRepository, BorrowerRepository borrowerRepository, BorrowRepository borrowRepository, ProducerRepository producerRepository) {

        this.vehicleRepository = vehicleRepository;
        this.bikeRepository = bikeRepository;
        this.borrowRepository = borrowRepository;
        this.borrowerRepository = borrowerRepository;
        this.producerRepository = producerRepository;
    }

    @RequestMapping(value="/details/{vehicleId}", method = RequestMethod.GET)
    public Vehicle details(@PathVariable Long vehicleId){
        Vehicle vehicle = vehicleRepository.findOne(vehicleId);
        return vehicle;
    }

    @RequestMapping(value="/delete/{vehicleId}", method = RequestMethod.DELETE)
    public void deleteVehicle(@PathVariable Long vehicleId){
        vehicleRepository.delete(vehicleId);
    }

    @RequestMapping(value="/showAll", method = RequestMethod.GET)
    public List<Vehicle> showAll(){

        return vehicleRepository.findAll();
    }

    @RequestMapping(value="/borrow", method = RequestMethod.POST)
    public String borrow(){
        BorrowDto b = new BorrowDto();
        b.setBorrowerId(2L);
        b.setLd(LocalDate.now());
        b.setVehicleId(2L);
        borrowRepository.save(borrowAssembler.fromBorrowDtoToBorrow(b));

        return "Borrowed!";
    }

    /*@RequestMapping(value="/borrow", method = RequestMethod.POST)
    public String borrow(){
        BorrowService borrowService = new BorrowServiceImpl();

        BorrowDto borrowDto = borrowService.addBorrow(2L, LocalDate.now(), 2L);

        borrowService.saveBorrow(borrowDto);

        return "Borrowed!";
    }*/

    @RequestMapping(value="/addCar", method = RequestMethod.POST)
    public String addCar(){
        CarDto cd = new CarDto();
        cd.setVehicleName("c5");
        cd.setProductionDate(LocalDate.of(2011, 11, 11));
        cd.setColor(Color.BLACK);
        cd.setProducerName(1L);
        vehicleRepository.save(carAssembler.fromCarDtoToCar(cd));

        return "Car added!";
    }

    @RequestMapping(value="/addBike/{vehicleName}", method = RequestMethod.POST)
    public String addBike(@PathVariable String vehicleName){
        BikeDto bikeDto = new BikeDto();
        bikeDto.setVehicleName(vehicleName);
        vehicleRepository.save(bikeAssembler.fromBikeDtoToBike(bikeDto));

        return "Bike added!";
    }

    @RequestMapping(value="/editCar", method = RequestMethod.PUT)
    public String editCar(){
        EditCarDto editCarDto = new EditCarDto();
        editCarDto.setColor(Color.RED);
        editCarDto.setProducerName(2L);
        editCarDto.setProductionDate(LocalDate.now());
        editCarDto.setVehicleName("b99");
        editCarDto.setVehicleId(6L);
        vehicleRepository.save(editCarAssembler.fromEditCarDtoToCar(editCarDto));

        return "Bike updated!";

    }
}
