package pl.bados.patryk.angularv2.service;

import pl.bados.patryk.angularv2.dto.BorrowerDto;
import pl.bados.patryk.angularv2.model.Borrower;

import java.util.List;

public interface BorrowerService {
    List<BorrowerDto> findAll();
}
