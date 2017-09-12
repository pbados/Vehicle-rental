package pl.bados.patryk.angularv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import pl.bados.patryk.angularv2.dto.VehicleDto;
import pl.bados.patryk.angularv2.model.Car;
import pl.bados.patryk.angularv2.model.Color;
import pl.bados.patryk.angularv2.model.Vehicle;

import java.util.List;
import java.util.Optional;

@Repository
//no repository bean
//@NoRepositoryBean //- uzywamy, gdy metoda vehicle nie wywolywala sie na vehiclerepository tylko na repo bike/car
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query(value="SELECT dtype, vehicle_name, color, production_date, producer_id  from vehicle", nativeQuery = true)
    List<Object> vehicles();

}