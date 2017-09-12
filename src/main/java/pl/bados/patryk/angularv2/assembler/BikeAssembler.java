package pl.bados.patryk.angularv2.assembler;

import org.springframework.stereotype.Component;
import pl.bados.patryk.angularv2.dto.BikeDto;
import pl.bados.patryk.angularv2.dto.VehicleDto;
import pl.bados.patryk.angularv2.model.Bike;

@Component
public class BikeAssembler {

    public Bike fromBikeDtoToBike(BikeDto bikeDto){
        Bike bike = new Bike();
        bike.setVehicleName(bikeDto.getVehicleName());

        return bike;
    }

    public VehicleDto fromBikeToVehicleDto(Bike bike){
        VehicleDto vehicleDto = new VehicleDto();
        vehicleDto.setVehicleName(bike.getVehicleName());
        vehicleDto.setBorrowsDto(bike.getBorrows());
        return vehicleDto;
    }

    public BikeDto fromBikeToBikeDto(Bike bike){
        BikeDto bikeDto = new BikeDto();
        bikeDto.setVehicleName(bike.getVehicleName());
        bikeDto.setBorrowsDto(bike.getBorrows());

        return bikeDto;
    }
}
