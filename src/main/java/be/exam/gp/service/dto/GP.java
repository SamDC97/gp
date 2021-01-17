package be.exam.gp.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class GP {

    private Long id;
    private String name;
    private Date date;
    private Long circuitId;

    private Circuit circuit;
}
