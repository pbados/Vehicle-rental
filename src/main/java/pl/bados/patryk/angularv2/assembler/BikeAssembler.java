package pl.bados.patryk.angularv2.assembler;

import pl.bados.patryk.angularv2.dto.BikeDto;
import pl.bados.patryk.angularv2.model.Bike;

public class BikeAssembler {

    public Bike fromBikeDtoToBike(BikeDto bikeDto){
        Bike bike = new Bike();
        bike.setVehicleName(bikeDto.getVehicleName());

        return bike;
    }

    public BikeDto fromBikeToBikeDto(Bike bike){
        BikeDto bikeDto = new BikeDto();
        bikeDto.setVehicleName(bike.getVehicleName());

        return bikeDto;
    }
}
