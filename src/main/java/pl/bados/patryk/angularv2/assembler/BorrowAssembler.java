package pl.bados.patryk.angularv2.assembler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.bados.patryk.angularv2.dto.BorrowDto;
import pl.bados.patryk.angularv2.model.Borrow;
import pl.bados.patryk.angularv2.model.Borrower;
import pl.bados.patryk.angularv2.repository.BorrowerRepository;
import pl.bados.patryk.angularv2.repository.VehicleRepository;

import java.util.List;

@Component
public class BorrowAssembler {

    @Autowired
    BorrowerRepository borrowerRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    public BorrowDto fromBorrowToBorrowDto(Borrow borrow){
        BorrowDto borrowDto = new BorrowDto();
        borrowDto.setBorrowerId(borrow.getBorrower().getBorrowerId());
        borrowDto.setLd(borrow.getBorrowDate());
        borrowDto.setVehicleId(borrow.getVehicle_id().getId());

        return borrowDto;
    }

    public Borrow fromBorrowDtoToBorrow(BorrowDto borrowDto){
        Borrow borrow = new Borrow();
        Borrower b1 = borrowerRepository.getOne(1L);
        borrow.setBorrower(b1);
        borrow.setBorrowDate(borrowDto.getLd());
        borrow.setVehicle_id(vehicleRepository.findOne(borrowDto.getVehicleId()));

        return borrow;
    }

    public BorrowAssembler() {
    }
}
