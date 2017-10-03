package pl.bados.patryk.angularv2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import pl.bados.patryk.angularv2.dto.*;
import pl.bados.patryk.angularv2.model.Borrower;
import pl.bados.patryk.angularv2.model.Color;
import pl.bados.patryk.angularv2.service.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
//@RequestMapping("/api/rent")
public class IndexController {

    private final VehicleService vehicleService;
    private final BorrowService borrowService;
    private final BorrowerService borrowerService;
    private final ProducerService producerService;

    @Autowired
    public IndexController(VehicleService vehicleService, BorrowService borrowService, BorrowerService borrowerService, ProducerService producerService) {
        this.vehicleService = vehicleService;
        this.borrowService = borrowService;
        this.borrowerService = borrowerService;
        this.producerService = producerService;
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public VehicleDto details(@PathVariable("id") Long id){
        return vehicleService.findVehicle(id);
    }

    @RequestMapping(value="/addBike/{name}", method = RequestMethod.POST)
    public void addBike(@PathVariable("name") String name){
        vehicleService.createBike(name);
    }

    @RequestMapping(value = "/addCar", method = RequestMethod.POST)
    public void addCar(@RequestBody CarDto carDto) {
        vehicleService.createCar(carDto);
    }

    @RequestMapping(value = "/editCar", method = RequestMethod.PUT)
    public void editCar(@RequestBody EditCarDto editcarDto) {
        vehicleService.editCar(editcarDto);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        vehicleService.deleteVehicle(id);
    }

    @RequestMapping(value="/borrow", method = RequestMethod.POST)
    public BorrowDto borrow(@RequestBody BorrowDto borrowDto){
        borrowService.addBorrow(borrowDto);
        return borrowDto;
    }

    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public List<VehicleDto> showAll() {
        return vehicleService.findAll();
    }

    @RequestMapping(value = "/allBorrowers", method = RequestMethod.GET)
    public List<BorrowerDto> showAllBorrowers(){
        return borrowerService.findAll();
    }

    /*@RequestMapping(value= "/showAllQuery", method = RequestMethod.GET)
    public List<Object> showAllQuery(){
        return vehicleRepository.vehicles();
    }*/

    @RequestMapping(value = "/show/{date}", method = RequestMethod.GET)
    public List<VehicleDto> show(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
        return vehicleService.getVehiclesByBorrowDate(date);
    }

    @RequestMapping(value = "/allProducers", method = RequestMethod.GET)
    public List<ProducerDto> showAllProducers(){
        return producerService.findAll();
    }

    @RequestMapping(value = "/allColors", method = RequestMethod.GET)
    public Color[] showAllColors(){
        Color[] possibleValues = Color.RED.getDeclaringClass().getEnumConstants();
        return possibleValues;

    }

}
