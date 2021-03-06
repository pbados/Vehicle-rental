package pl.bados.patryk.angularv2.model;

import pl.bados.patryk.angularv2.dto.BorrowDto;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
//map super class
//@MappedSuperclass - poniewaz nie tworze obiektu
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Vehicle {

    @Id
    @Column(name = "vehicleId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vehicleId;

    @OneToMany(mappedBy="vehicle")
    private List<Borrow> borrows;

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public List<Borrow> getBorrows() {
        return borrows;
    }

    public void setBorrows(List<Borrow> borrows) {
        this.borrows = borrows;
    }

    public Vehicle() {
    }
}
