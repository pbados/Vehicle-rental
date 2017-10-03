package pl.bados.patryk.angularv2.assembler;

import org.springframework.stereotype.Component;
import pl.bados.patryk.angularv2.dto.BorrowerDto;
import pl.bados.patryk.angularv2.model.Borrower;

@Component
public class BorrowerAssembler {

    public Borrower fromBorrowerDtoToBorrower(BorrowerDto borrowerDto){
        Borrower borrower = new Borrower();
        borrower.setBorrowerId(borrowerDto.getId());
        borrower.setBorrowerName(borrowerDto.getBorrowerName());

        return borrower;
    }

    public BorrowerDto fromBorrowerToBorrowerDto(Borrower borrower){
        BorrowerDto borrowerDto = new BorrowerDto();
        borrowerDto.setId(borrower.getBorrowerId());
        borrowerDto.setBorrowerName(borrower.getBorrowerName());

        return borrowerDto;
    }
}
