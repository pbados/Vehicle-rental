package pl.bados.patryk.angularv2.service;

import pl.bados.patryk.angularv2.dto.BorrowDto;

import java.time.LocalDate;

public interface BorrowService {

    void addBorrow(BorrowDto borrowDto);
}
