package pl.bados.patryk.angularv2.dto;

import pl.bados.patryk.angularv2.model.Car;

import java.util.List;

public class ProducerDto {
    private String producerName;
    private List<Car> cars;

    @Override
    public String toString() {
        return "ProducerDto{" +
                "producerName='" + producerName + '\'' +
                ", cars=" + cars +
                '}';
    }

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
