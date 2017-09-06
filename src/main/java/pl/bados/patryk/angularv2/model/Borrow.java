package pl.bados.patryk.angularv2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.bados.patryk.angularv2.LocalDateAttributeConverter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long borrowId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="borrower_id")
    public Borrower borrower;

    @Convert(converter = LocalDateAttributeConverter.class)
    public LocalDate borrowDate;

    @ManyToOne
    @JoinColumn(name="vehicleId")
    @JsonIgnore
    public Vehicle vehicle;

    public Borrow() {
    }

    public Long getBorrowId() {

        return borrowId;
    }

    public void setBorrowId(Long borrowId) {
        this.borrowId = borrowId;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "borrowId=" + borrowId +
                ", borrowerId=" + borrower +
                ", borrowDate=" + borrowDate +
                ", vehicle=" + vehicle +
                '}';
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    public Borrow(Borrower borrowerId, LocalDate borrowDate, Vehicle vehicle) {

        this.borrower = borrowerId;
        this.borrowDate = borrowDate;
        this.vehicle = vehicle;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
