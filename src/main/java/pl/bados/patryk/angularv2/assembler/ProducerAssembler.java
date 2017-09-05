package pl.bados.patryk.angularv2.assembler;

import org.springframework.stereotype.Component;
import pl.bados.patryk.angularv2.dto.ProducerDto;
import pl.bados.patryk.angularv2.model.Producer;

@Component
public class ProducerAssembler {

    public ProducerDto fromProducerToProducerDto(Producer producer){
        ProducerDto producerDto = new ProducerDto();
        producerDto.setProducerName(producer.getProducerName());
        producerDto.setCars(producer.getCars());

        return producerDto;
    }

    public Producer fromProducerDtoToProducer(ProducerDto producerDto){
        Producer producer = new Producer();
        producer.setProducerName(producerDto.getProducerName());
        producer.setCars(producerDto.getCars());

        return producer;
    }
}
