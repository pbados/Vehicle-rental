package pl.bados.patryk.angularv2.dto;

import java.time.LocalDate;

public class BorrowDto {

    private LocalDate ld;
    private Long vehicleId;
    private Long borrowerId;

    public BorrowDto() {
    }

    @Override
    public String toString() {
        return "BorrowDto{" +
                "ld=" + ld +
                ", vehicleId=" + vehicleId +
                ", borrowerId=" + borrowerId +
                '}';
    }

    public LocalDate getLd() {
        return ld;
    }

    public void setLd(LocalDate ld) {
        this.ld = ld;
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

    public BorrowDto(LocalDate ld, Long vehicleId, Long borrowerId) {

        this.ld = ld;
        this.vehicleId = vehicleId;
        this.borrowerId = borrowerId;
    }
}
