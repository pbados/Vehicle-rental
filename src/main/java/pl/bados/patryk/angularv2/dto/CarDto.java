package pl.bados.patryk.angularv2.dto;

import pl.bados.patryk.angularv2.model.Color;

import java.time.LocalDate;

public class CarDto {

    private String vehicleName;
    private Color color;
    private LocalDate productionDate;
    private Long producer;

    public CarDto(String vehicleName, Color color, LocalDate localDate, Long producer) {
        this.vehicleName = vehicleName;
        this.color = color;
        this.productionDate = localDate;
        this.producer = producer;
    }

    public CarDto() {
    }

    @Override
    public String toString() {
        return "CarDto{" +
                ", vehicleName='" + vehicleName + '\'' +
                ", color=" + color +
                ", localDate=" + productionDate +
                ", producer='" + producer + '\'' +
                '}';
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate localDate) {
        this.productionDate = localDate;
    }

    public Long getProducerName() {
        return producer;
    }

    public void setProducerName(Long producerName) {
        this.producer = producerName;
    }
}
