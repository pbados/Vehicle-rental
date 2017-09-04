package pl.bados.patryk.angularv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bados.patryk.angularv2.model.Producer;

@Repository
public interface ProducerRepository extends JpaRepository<Producer, Long>{
}
