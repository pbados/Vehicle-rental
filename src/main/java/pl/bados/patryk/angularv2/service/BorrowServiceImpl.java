package pl.bados.patryk.angularv2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.bados.patryk.angularv2.assembler.BorrowAssembler;
import pl.bados.patryk.angularv2.dto.BorrowDto;
import pl.bados.patryk.angularv2.repository.*;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@Transactional
public class BorrowServiceImpl implements BorrowService {

    private BorrowRepository borrowRepository;
    private BorrowAssembler borrowAssembler;

    @Autowired
    public BorrowServiceImpl(BorrowRepository borrowRepository, BorrowAssembler borrowAssembler){
        this.borrowRepository = borrowRepository;
        this.borrowAssembler = borrowAssembler;
    }

    @Override
    public void addBorrow(BorrowDto borrowDto) {
        borrowRepository.save(borrowAssembler.fromBorrowDtoToBorrow(borrowDto));
    }
}
