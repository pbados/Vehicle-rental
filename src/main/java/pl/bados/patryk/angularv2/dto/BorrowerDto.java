package pl.bados.patryk.angularv2.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BorrowerDto {

    private Long id;
    private String borrowerName;
    @JsonIgnore
    private BorrowDto borrowDto;

    public BorrowerDto(Long id, String borrowerName) {
        this.id = id;
        this.borrowerName = borrowerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public BorrowDto getBorrowDto() {
        return borrowDto;
    }

    public void setBorrowDto(BorrowDto borrowDto) {
        this.borrowDto = borrowDto;
    }

    public BorrowerDto(Long id, String borrowerName, BorrowDto borrowDto) {

        this.id = id;
        this.borrowerName = borrowerName;
        this.borrowDto = borrowDto;
    }

    public BorrowerDto() {
    }

    /*
    private String borrowerName;
    @JsonIgnore
    private BorrowDto borrowDto;

    @Override
    public String toString() {
        return "BorrowerDto{" +
                "borrowerName='" + borrowerName + '\'' +
                '}';
    }

    public BorrowerDto() {
    }

    public BorrowerDto(String borrowerName) {

        this.borrowerName = borrowerName;
    }

    public String getBorrowerName() {

        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public BorrowerDto(String borrowerName, BorrowDto borrowDto) {
        this.borrowerName = borrowerName;
        this.borrowDto = borrowDto;
    }*/
}
