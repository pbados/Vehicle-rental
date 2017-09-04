package pl.bados.patryk.angularv2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Producer {

    @Id
    @Column(name="producer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long producerId;

    @Column
    private String producerName;

    @OneToMany(mappedBy="producerName")
    private List<Car> cars;

    public Producer(List<Car> cars) {
        this.cars = cars;
    }

    public Producer() {
    }

    @Override
    public String toString() {
        return "Producer{" +
                "id=" + producerId +
                ", cars=" + cars +
                '}';
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
