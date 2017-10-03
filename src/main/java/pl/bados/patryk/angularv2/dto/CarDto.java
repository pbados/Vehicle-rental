package pl.bados.patryk.angularv2.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import pl.bados.patryk.angularv2.model.Color;
import pl.bados.patryk.angularv2.model.Producer;

import java.time.LocalDate;

public class CarDto extends VehicleDto{

    private Long id;
    private String vehicleName;
    private Color color;
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate productionDate;
    private String producer;
    private Long producerId;
    private final String type = "Car";

    public CarDto(String vehicleName, Color color, LocalDate localDate, String producer, Long vehicleId, String type) {
        this.vehicleName = vehicleName;
        this.color = color;
        this.productionDate = localDate;
        this.producer = producer;
        this.id = vehicleId;
    }

    public CarDto(String vehicleName, Color color, LocalDate localDate, Long producerId, String type) {
        this.vehicleName = vehicleName;
        this.color = color;
        this.productionDate = localDate;
        this.producerId = producerId;
    }


    public CarDto() {
    }

    public String getType() {
        return type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
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

    public Long getProducerId() {
        return producerId;
    }

    public void setProducerId(Long producerId) {
        this.producerId = producerId;
    }
}
