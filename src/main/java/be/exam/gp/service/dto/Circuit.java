package be.exam.gp.service.dto;

import lombok.Data;

@Data
public class Circuit {

    private Long id;
    private String name;
    private Long length;
    private String location;
}
