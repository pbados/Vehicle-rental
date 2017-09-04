package pl.bados.patryk.angularv2.model;

import javax.persistence.*;
import java.util.List;

@Entity
//map super class
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Vehicle {

    @Id
    @Column(name = "vehicle_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy="borrow_id")
    private List<Borrow> borrows;

    /*public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Borrow> getBorrows() {
        return borrows;
    }

    public void setBorrows(List<Borrow> borrows) {
        this.borrows = borrows;
    }*/
}
