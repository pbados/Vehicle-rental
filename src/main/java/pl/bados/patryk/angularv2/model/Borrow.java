package pl.bados.patryk.angularv2.model;

import pl.bados.patryk.angularv2.LocalDateAttributeConverter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Borrow {

    @Id
    @Column(name="borrow_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long borrow_id; //borrowId

    @OneToOne(cascade = CascadeType.ALL)
    public Borrower borrowerId;

    @Convert(converter = LocalDateAttributeConverter.class)
    public LocalDate borrowDate;

    @ManyToOne
    @JoinColumn(name="vehicle_id")
    public Vehicle vehicle_id; //dsa

    public Borrow(Borrower borrowerId, LocalDate borrowDate, Vehicle vehicle_id) {
        this.borrowerId = borrowerId;
        this.borrowDate = borrowDate;
        this.vehicle_id = vehicle_id;
    }

    public Borrow(){}

    @Override
    public String toString() {
        return "Borrow{" +
                "borrow_id=" + borrow_id +
                ", borrowerId=" + borrowerId +
                ", borrowDate=" + borrowDate +
                ", vehicle_id=" + vehicle_id +
                '}';
    }

    public Long getBorrow_id() {
        return borrow_id;
    }

    public void setBorrow_id(Long borrow_id) {
        this.borrow_id = borrow_id;
    }

    public Borrower getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Borrower borrower) {
        this.borrowerId = borrower;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Vehicle getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(Vehicle vehicle_id) {
        this.vehicle_id = vehicle_id;
    }
}