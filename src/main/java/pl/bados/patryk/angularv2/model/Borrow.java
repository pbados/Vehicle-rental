package pl.bados.patryk.angularv2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.bados.patryk.angularv2.LocalDateAttributeConverter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Borrow {

    @Id
    @Column(name="borrowId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long borrowId;

    @OneToOne(cascade = CascadeType.ALL)
    public Borrower borrower;

    @Convert(converter = LocalDateAttributeConverter.class)
    public LocalDate borrowDate;

    @ManyToOne
    @JoinColumn(name="vehicleId")
    @JsonIgnore
    public Vehicle vehicle;

    public Borrow() {
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "borrowId=" + borrowId +
                ", borrower=" + borrower +
                ", borrowDate=" + borrowDate +
                ", vehicle=" + vehicle +
                '}';
    }

    public Borrow(Borrower borrower, LocalDate borrowDate, Vehicle vehicle) {
        this.borrower = borrower;
        this.borrowDate = borrowDate;
        this.vehicle = vehicle;
    }

    public Long getBorrowId() {

        return borrowId;
    }

    public void setBorrowId(Long borrowId) {
        this.borrowId = borrowId;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
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
