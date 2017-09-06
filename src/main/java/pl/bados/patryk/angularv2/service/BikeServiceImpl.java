package pl.bados.patryk.angularv2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.bados.patryk.angularv2.assembler.BikeAssembler;
import pl.bados.patryk.angularv2.dto.BikeDto;
import pl.bados.patryk.angularv2.repository.VehicleRepository;

@Component
public class BikeServiceImpl implements BikeService {

    private VehicleRepository vehicleRepository;
    private BikeAssembler bikeAssembler;

    @Autowired
    public BikeServiceImpl(VehicleRepository vehicleRepository, BikeAssembler bikeAssembler){
        this.vehicleRepository = vehicleRepository;
        this.bikeAssembler = bikeAssembler;
    }

    @Override
    public BikeDto addBike(String vehicleName) {
        BikeDto bikeDto = new BikeDto(vehicleName);

        return bikeDto;
    }

    @Override
    public void saveBike(BikeDto bikeDto) {
        vehicleRepository.save(bikeAssembler.fromBikeDtoToBike(bikeDto));
    }
}
