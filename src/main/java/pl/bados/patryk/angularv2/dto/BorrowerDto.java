package pl.bados.patryk.angularv2.dto;

public class BorrowerDto {

    private String borrowerName;

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
}
