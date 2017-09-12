package pl.bados.patryk.angularv2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.bados.patryk.angularv2.dto.CarDto;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Producer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long producerId;

    @Column
    private String producerName;

    @OneToMany(mappedBy="producer")
    private List<Car> cars;

    public Producer(List<Car> cars) {
        this.cars = cars;
    }

    public Producer() {
    }

    public Long getId() {
        return producerId;
    }

    public void setId(Long id) {
        this.producerId = id;
    }

    @JsonIgnore
    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

}
