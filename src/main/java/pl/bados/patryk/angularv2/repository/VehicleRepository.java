package pl.bados.patryk.angularv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bados.patryk.angularv2.model.Vehicle;

@Repository
//no repository bean
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}