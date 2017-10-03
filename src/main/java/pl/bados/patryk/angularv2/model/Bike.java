package pl.bados.patryk.angularv2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Bike extends Vehicle{

    @Column(unique = true)
    String vehicleName;

    @Transient
    private final String type = "Bike";

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public Bike(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public Bike() {
    }

    public String getType() {
        return type;
    }
}
