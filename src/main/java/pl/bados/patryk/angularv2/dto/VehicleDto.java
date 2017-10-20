package pl.bados.patryk.angularv2.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import pl.bados.patryk.angularv2.model.Borrow;
import pl.bados.patryk.angularv2.model.Color;

import javax.persistence.Transient;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleDto {

    private String vehicleName;
    private Color color;
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate productionDate;
    private String producer;

    public VehicleDto() {
    }

    public String getVehicleName() {

        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public VehicleDto(String vehicleName, Color color, LocalDate productionDate, String producer) {

        this.vehicleName = vehicleName;
        this.color = color;
        this.productionDate = productionDate;
        this.producer = producer;
    }

    //

    @JsonProperty("isBorrowed")
    @Transient
    private Boolean isBorrowed;

    @JsonProperty("isGenerallyBorrowed")
    @Transient
    private Boolean isGenerallyBorrowed;

    @JsonProperty("borrower")
    @Transient
    private BorrowerDto borrowerDto;

    @JsonIgnore
    private List<BorrowDto> borrowsDto = new ArrayList<>();


    public List<BorrowDto> getBorrowsDto() {
        return borrowsDto;
    }

    public void setBorrowsDto(List<Borrow> borrows) {
        this.borrowsDto = borrows.stream().map(borrow -> {
            BorrowDto borrowDto = new BorrowDto(borrow.getBorrowId(), this, borrow.getBorrowDate());
            BorrowerDto borrowerDto = new BorrowerDto(borrow.getBorrower().getBorrowerId(), borrow.getBorrower().getBorrowerName(), borrowDto);
            borrowDto.setBorrowerDto(borrowerDto);
            return borrowDto;
        }).collect(Collectors.toList());

    }

    public BorrowerDto getBorrowerDto() {
        return borrowerDto;
    }

    public void setBorrowerDto(BorrowerDto borrowerDto) {
        this.borrowerDto = borrowerDto;
    }

    @JsonIgnore
    public boolean findAndSetBorrowerIfPresentForDate(LocalDate borrowDate) {
        Optional<BorrowDto> borrow = borrowsDto.stream().filter(borrowDto -> borrowDto.getBorrowDate().equals(borrowDate)).findAny();
        if (borrow.isPresent()) {
            this.isBorrowed = true;
            this.borrowerDto = borrow.get().getBorrowerDto();
            return true;
        }
        this.isBorrowed = false;
        return false;
    }


}