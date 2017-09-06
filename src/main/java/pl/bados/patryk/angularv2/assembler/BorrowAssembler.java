package pl.bados.patryk.angularv2.assembler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.bados.patryk.angularv2.dto.BorrowDto;
import pl.bados.patryk.angularv2.model.Borrow;
import pl.bados.patryk.angularv2.repository.BorrowerRepository;
import pl.bados.patryk.angularv2.repository.VehicleRepository;

@Component
public class BorrowAssembler {

    @Autowired
    BorrowerRepository borrowerRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    public BorrowDto fromBorrowToBorrowDto(Borrow borrow){
        BorrowDto borrowDto = new BorrowDto();
        borrowDto.setBorrowerId(borrow.getBorrower().getBorrowerId());
        borrowDto.setBorrowDate(borrow.getBorrowDate());
        borrowDto.setVehicleId(borrow.getVehicle().getVehicleId());

        return borrowDto;
    }

    public Borrow fromBorrowDtoToBorrow(BorrowDto borrowDto){
        Borrow borrow = new Borrow();
        borrow.setBorrower(borrowerRepository.getOne(borrowDto.getBorrowerId()));
        borrow.setBorrowDate(borrowDto.getBorrowDate());
        borrow.setVehicle(vehicleRepository.findOne(borrowDto.getVehicleId()));

        return borrow;
    }

    public BorrowAssembler() {
    }
}
