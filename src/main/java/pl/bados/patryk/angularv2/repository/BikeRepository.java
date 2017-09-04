package pl.bados.patryk.angularv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bados.patryk.angularv2.model.Bike;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long> {
}
