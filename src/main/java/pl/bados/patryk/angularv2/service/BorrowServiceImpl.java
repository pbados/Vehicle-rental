package pl.bados.patryk.angularv2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.bados.patryk.angularv2.assembler.BorrowAssembler;
import pl.bados.patryk.angularv2.dto.BorrowDto;
import pl.bados.patryk.angularv2.repository.*;

import java.time.LocalDate;

@Component
public class BorrowServiceImpl implements BorrowService {

    private BorrowRepository borrowRepository;
    private BorrowAssembler borrowAssembler;

    @Autowired
    public BorrowServiceImpl(BorrowRepository borrowRepository, BorrowAssembler borrowAssembler){
        this.borrowRepository = borrowRepository;
        this.borrowAssembler = borrowAssembler;
    }

    @Override
    public BorrowDto addBorrow(Long vehicleId, LocalDate date, Long borrowerId) {
        BorrowDto borrowDto = new BorrowDto(date, vehicleId, borrowerId);

        return borrowDto;
    }

    @Override
    public void saveBorrow(BorrowDto borrowDto) {
        borrowRepository.save(borrowAssembler.fromBorrowDtoToBorrow(borrowDto));
    }
}
