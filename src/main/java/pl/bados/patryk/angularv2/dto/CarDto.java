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
    private Long producer;

    public CarDto(String vehicleName, Color color, LocalDate localDate, Long producer) {
        this.vehicleName = vehicleName;
        this.color = color;
        this.productionDate = localDate;
        this.producer = producer;
    }

    public CarDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProducer() {
        return producer;
    }

    public void setProducer(Long producer) {
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


}
