package pl.bados.patryk.angularv2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.bados.patryk.angularv2.assembler.BikeAssembler;
import pl.bados.patryk.angularv2.assembler.BorrowAssembler;
import pl.bados.patryk.angularv2.assembler.CarAssembler;
import pl.bados.patryk.angularv2.dto.BikeDto;
import pl.bados.patryk.angularv2.dto.BorrowDto;
import pl.bados.patryk.angularv2.dto.CarDto;
import pl.bados.patryk.angularv2.model.*;
import pl.bados.patryk.angularv2.repository.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class IndexController {

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
    public List<Vehicle> details(){

        return vehicleRepository.findAll();
    }

    @RequestMapping(value="/borrow", method = RequestMethod.POST)
    public String borrow(){
        /*BorrowDto b = new BorrowDto();
        b.setBorrowerId(4L);
        b.setLd(LocalDate.now());
        b.setVehicleId(vehicleRepository.getOne(7L));

        BorrowAssembler ba = new BorrowAssembler();
        borrowRepository.save(ba.getBorrow(b));*/

        /* DZIALA, ALE BEZPOSREDNIO NA BORROW, A NIE NA BORROWDTO
        Borrow b = new Borrow();

        b.setBorrower(borrowerRepository.getOne(3L));
        b.setBorrowDate(LocalDate.now());
        b.setVehicleId(vehicleRepository.getOne(3L));

        borrowRepository.save(b);*/

        return "Wypozyczono!";
    }

    @RequestMapping(value="/addCar", method = RequestMethod.POST)
    public String addCar(){
        CarDto cd = new CarDto();
        cd.setVehicleName("c5");
        cd.setProductionDate(LocalDate.of(2011, 11, 11));
        cd.setColor(Color.BLACK);
        //cd.setProducerName(producerRepository.getOne(1L));

        CarAssembler cA = new CarAssembler();
        vehicleRepository.save(cA.fromCarDtoToCar(cd));

        return "Dodano samochod!";
    }

    /*@RequestMapping(value="/details/{vehicleId}", method = RequestMethod.GET)
    public Vehicle details(@PathVariable Long vehicleId){
        Vehicle vehicle = vehicleRepository.findOne(vehicleId);
        return vehicle;
    }*/

    @RequestMapping(value="/addBike/{vehicleName}", method = RequestMethod.POST)
    public String addBike(@PathVariable String vehicleName){
        BikeDto bikeDto = new BikeDto();
        bikeDto.setVehicleName(vehicleName);

        //dodrawne
        BikeAssembler bikeAssembler = new BikeAssembler();
        //vehicleRepository.save(bikeAssembler.fromBikeDtoToBike(bikeDto));

        return "Dodano rower!";
    }
}
