package pl.bados.patryk.angularv2.dto;

import pl.bados.patryk.angularv2.model.Color;
import pl.bados.patryk.angularv2.model.Producer;

import java.time.LocalDate;

public class CarDto {

    private Long vehicleId;
    private String vehicleName;
    private Color color;
    private LocalDate productionDate;
    private Long producerName;

    public CarDto(Long vehicleId, String vehicleName, Color color, LocalDate localDate, Long producerName) {
        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
        this.color = color;
        this.productionDate = localDate;
        this.producerName = producerName;
    }

    public CarDto() {
    }

    @Override
    public String toString() {
        return "CarDto{" +
                "vehicleId=" + vehicleId +
                ", vehicleName='" + vehicleName + '\'' +
                ", color=" + color +
                ", localDate=" + productionDate +
                ", producerName='" + producerName + '\'' +
                '}';
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
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
        return producerName;
    }

    public void setProducerName(Long producerName) {
        this.producerName = producerName;
    }
}
