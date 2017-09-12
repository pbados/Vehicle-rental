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

    public ProducerDto(String producerName, List<Car> cars) {

        this.producerName = producerName;
        this.cars = cars;
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
}
