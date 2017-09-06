package pl.bados.patryk.angularv2.model;

import pl.bados.patryk.angularv2.LocalDateAttributeConverter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Car extends Vehicle{

    @ManyToOne
    @JoinColumn(name="producer_id")
    private Producer producer;

    @Column
    @Enumerated(EnumType.STRING)
    private Color color;

    //dodac do vehicle, usuac z bike
    @Column
    private String vehicleName;

    @Column
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate productionDate;

    public Car() {
    }

    @Override
    public String toString() {
        return "Car{" +
                "producer=" + producer +
                ", color=" + color +
                ", vehicleName='" + vehicleName + '\'' +
                ", productionDate=" + productionDate +
                '}';
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Car(Producer producer, Color color, String vehicleName, LocalDate productionDate) {

        this.producer = producer;
        this.color = color;
        this.vehicleName = vehicleName;
        this.productionDate = productionDate;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getVehicleName() {

        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }


    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }


}
