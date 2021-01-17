package be.exam.gp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GPEntity {

    @Id
    private Long id;
    private String name;
    private Long circuitId;
    private Date date;
}
