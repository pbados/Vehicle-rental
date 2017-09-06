package pl.bados.patryk.angularv2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.bados.patryk.angularv2.assembler.ProducerAssembler;
import pl.bados.patryk.angularv2.dto.ProducerDto;
import pl.bados.patryk.angularv2.model.Car;
import pl.bados.patryk.angularv2.repository.ProducerRepository;

import java.util.List;

@Component
public class ProducerServiceImpl implements ProducerService {

    private ProducerRepository producerRepository;
    private ProducerAssembler producerAssembler;

    @Autowired
    public ProducerServiceImpl(ProducerRepository producerRepository, ProducerAssembler producerAssembler){
        this.producerRepository = producerRepository;
        this.producerAssembler = producerAssembler;
    }

    @Override
    public ProducerDto addProducer(String producerName, List<Car> cars) {
        ProducerDto producerDto = new ProducerDto(producerName, cars);

        return producerDto;
    }

    @Override
    public void saveProducer(ProducerDto producerDto) {
        producerRepository.save(producerAssembler.fromProducerDtoToProducer(producerDto));
    }
}
