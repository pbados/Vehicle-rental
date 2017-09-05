package pl.bados.patryk.angularv2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.bados.patryk.angularv2.assembler.BorrowAssembler;
import pl.bados.patryk.angularv2.dto.BorrowDto;
import pl.bados.patryk.angularv2.model.Borrow;
import pl.bados.patryk.angularv2.repository.*;

import java.time.LocalDate;

@Component
public class BorrowServiceImpl implements BorrowService {

    private BorrowRepository borrowRepository;

    @Autowired
    BorrowAssembler borrowAssembler;

    @Autowired
    public BorrowServiceImpl(BorrowRepository borrowRepository){
        this.borrowRepository = borrowRepository;
    }

    @Override
    public BorrowDto addBorrow(Long vehicleId, LocalDate date, Long borrowerId) {
        BorrowDto borrowDto = new BorrowDto();
        borrowDto.setVehicleId(vehicleId);
        borrowDto.setLd(date);
        borrowDto.setBorrowerId(borrowerId);

        return borrowDto;

    }

    @Override
    public void saveBorrow(BorrowDto borrowDto) {
        borrowRepository.save(borrowAssembler.fromBorrowDtoToBorrow(borrowDto));
    }
}
