package pl.bados.patryk.angularv2.model;

import javax.persistence.*;

@Entity
public class Borrower {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long borrowerId;

    private String borrowerName;

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public Borrower(String borrowerName) {

        this.borrowerName = borrowerName;
    }

    public Borrower() {
    }

    @Override
    public String toString() {
        return "Borrower{" +
                "borrower=" + borrowerId +
                ", borrowerName='" + borrowerName + '\'' +
                '}';
    }

    public Long getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Long borrowerId) {
        this.borrowerId = borrowerId;
    }
}
