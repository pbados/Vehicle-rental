package pl.bados.patryk.angularv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.bados.patryk.angularv2.model.Vehicle;

import java.util.List;

@Repository
//no repository bean
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query(value="SELECT v.vehicle_name from vehicle v", nativeQuery = true)
    List<Vehicle> vehicles();
}