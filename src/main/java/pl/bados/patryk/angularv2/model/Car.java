package pl.bados.patryk.angularv2.model;

import pl.bados.patryk.angularv2.LocalDateAttributeConverter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Car extends Vehicle{

    @ManyToOne
    @JoinColumn(name="producerName")
    private Producer producerName;

    @Column
    @Enumerated(EnumType.STRING)
    private Color color;

    @Column
    private String vehicleName;

    @Column
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate productionDate;

    public Car() {
    }

    public Car(Producer producerName, Color color, String vehicleName, LocalDate productionDate) {
        this.producerName = producerName;
        this.color = color;
        this.vehicleName = vehicleName;
        this.productionDate = productionDate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "producerName=" + producerName +
                ", color=" + color +
                ", vehicleName='" + vehicleName + '\'' +
                ", productionDate='" + productionDate + '\'' +
                '}';
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

    public Producer getProducerName() {
        return producerName;
    }

    public void setProducerName(Producer producerName) {
        this.producerName = producerName;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }


}
