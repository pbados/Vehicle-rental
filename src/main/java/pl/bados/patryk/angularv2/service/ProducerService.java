package pl.bados.patryk.angularv2.service;

import pl.bados.patryk.angularv2.dto.ProducerDto;
import pl.bados.patryk.angularv2.model.Car;

import java.util.List;

public interface ProducerService {

    ProducerDto addProducer(String producerName, List<Car> cars, Long producerId);
    void saveProducer(ProducerDto producerDto);
    List<ProducerDto> findAll();
}
