package pl.bados.patryk.angularv2.dto;

import pl.bados.patryk.angularv2.model.Color;

import java.time.LocalDate;

public class EditCarDto {

    private Long vehicleId;
    private String vehicleName;
    private Color color;
    private LocalDate productionDate;
    private Long producerName;

    @Override
    public String toString() {
        return "EditCarDto{" +
                "vehicleId=" + vehicleId +
                ", vehicleName='" + vehicleName + '\'' +
                ", color=" + color +
                ", productionDate=" + productionDate +
                ", producerName=" + producerName +
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

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public Long getProducerName() {
        return producerName;
    }

    public void setProducerName(Long producerName) {
        this.producerName = producerName;
    }

    public EditCarDto() {

    }

    public EditCarDto(Long vehicleId, String vehicleName, Color color, LocalDate productionDate, Long producerName) {

        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
        this.color = color;
        this.productionDate = productionDate;
        this.producerName = producerName;
    }
}
