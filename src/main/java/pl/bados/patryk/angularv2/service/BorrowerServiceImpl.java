package pl.bados.patryk.angularv2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bados.patryk.angularv2.assembler.BorrowerAssembler;
import pl.bados.patryk.angularv2.dto.BorrowerDto;
import pl.bados.patryk.angularv2.model.Borrower;
import pl.bados.patryk.angularv2.repository.BorrowerRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BorrowerServiceImpl implements BorrowerService {

    private final BorrowerRepository borrowerRepository;
    private final BorrowerAssembler borrowerAssembler;

    @Autowired
    public BorrowerServiceImpl(BorrowerRepository borrowerRepository, BorrowerAssembler borrowerAssembler){
        this.borrowerRepository = borrowerRepository;
        this.borrowerAssembler = borrowerAssembler;
    }

    @Override
    public List<BorrowerDto> findAll() {
        return borrowerRepository.findAll().stream().map(borrower ->{
            return borrowerAssembler.fromBorrowerToBorrowerDto(borrower);
        }).collect(Collectors.toList());

        /*return vehicleRepository.findAll().stream().map(vehicle ->{
            if(vehicle instanceof Car){
                return carAssembler.fromCarToCarDtoWithId((Car) vehicle);
            }
            else if(vehicle instanceof Bike){
                return bikeAssembler.fromBikeToBikeDto((Bike) vehicle);
            }
            return null;
        }).collect(Collectors.toList());*/
    }
}
