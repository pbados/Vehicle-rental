package pl.bados.patryk.angularv2.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import pl.bados.patryk.angularv2.model.Bike;
import pl.bados.patryk.angularv2.model.Car;
import pl.bados.patryk.angularv2.model.Vehicle;

import java.rmi.activation.UnknownObjectException;
import java.time.LocalDate;

public class BorrowDto {

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate borrowDate;
    private Long vehicleId;
    private Long id;
    private Long borrowerId;
    private VehicleDto vehicleDto;
    private BorrowerDto borrowerDto;

    public BorrowDto() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVehicleDto(VehicleDto vehicleDto) {
        this.vehicleDto = vehicleDto;
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

    public BorrowDto(Long id, VehicleDto vehicleDto, LocalDate borrowDate) {
        this.id = id;
        this.vehicleDto = vehicleDto;
        this.borrowDate = borrowDate;
    }

    public VehicleDto getVehicleDto() {
        return vehicleDto;
    }

    public BorrowerDto getBorrowerDto() {
        return borrowerDto;
    }

    public void setBorrowerDto(BorrowerDto borrowerDto) {
        this.borrowerDto = borrowerDto;
    }
}
