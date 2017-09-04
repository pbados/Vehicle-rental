package pl.bados.patryk.angularv2.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Bike extends Vehicle{

    @Column
    private String vehicleName;

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public Bike() {
    }

    public Bike(String vehicleName) {
        this.vehicleName = vehicleName;
    }
}