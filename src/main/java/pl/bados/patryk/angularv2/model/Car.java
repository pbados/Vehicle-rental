package pl.bados.patryk.angularv2.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pl.bados.patryk.angularv2.LocalDateAttributeConverter;
import pl.bados.patryk.angularv2.dto.ProducerDto;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

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
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate productionDate;

    public Car() {
    }

    @Transient
    private final String type = "Car";

    public String getType() {
        return type;
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
