package pl.bados.patryk.angularv2.repository;

import org.springframework.stereotype.Repository;
import pl.bados.patryk.angularv2.model.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Long>{
}
