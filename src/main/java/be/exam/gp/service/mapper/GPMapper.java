package be.exam.gp.service.mapper;

import be.exam.gp.domain.GPEntity;
import be.exam.gp.service.dto.Circuit;
import be.exam.gp.service.dto.GP;
import org.springframework.stereotype.Component;

@Component
public class GPMapper {

    public GPEntity toEntity(GP gp){
        return new GPEntity(gp.getId(), gp.getName(), gp.getCircuitId(), gp.getDate());
    }

    public GP toDTO(GPEntity gpEntity){
        return new GP(gpEntity.getId(), gpEntity.getName(), gpEntity.getDate(), gpEntity.getCircuitId(),  new Circuit());
    }
}
