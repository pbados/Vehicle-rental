package pl.bados.patryk.angularv2.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.bados.patryk.angularv2.model.Car;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProducerDto {

private String producerName;
    private List<Car> cars;

    public ProducerDto() {
    }

    public ProducerDto(String producerName, List<Car> cars, Long producerId) {

        this.producerName = producerName;
        this.cars = cars;
        this.producerId = producerId;
    }

    public String getProducerName() {

        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Long producerId;

    public Long getProducerId() {
        return producerId;
    }

    public void setProducerId(Long producerId) {
        this.producerId = producerId;
    }
}
