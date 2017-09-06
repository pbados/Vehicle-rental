package pl.bados.patryk.angularv2.dto;

import java.time.LocalDate;

public class BorrowDto {

    private LocalDate borrowDate;
    private Long vehicleId;
    private Long borrowerId;

    public BorrowDto() {
    }


    @Override
    public String toString() {
        return "BorrowDto{" +
                "borrowDate=" + borrowDate +
                ", vehicleId=" + vehicleId +
                ", borrowerId=" + borrowerId +
                '}';
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Long getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Long borrowerId) {
        this.borrowerId = borrowerId;
    }

    public BorrowDto(LocalDate borrowDate, Long vehicleId, Long borrowerId) {

        this.borrowDate = borrowDate;
        this.vehicleId = vehicleId;
        this.borrowerId = borrowerId;
    }
}
