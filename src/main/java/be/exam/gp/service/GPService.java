package be.exam.gp.service;

import be.exam.gp.domain.GPEntity;
import be.exam.gp.domain.repository.GPRepository;
import be.exam.gp.service.dto.Circuit;
import be.exam.gp.service.dto.GP;
import be.exam.gp.service.mapper.GPMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GPService {

    @Autowired
    private GPRepository gpRepository;
    @Autowired
    private GPMapper gpMapper;
    @Value("${url.circuit}")
    private String circuitURL;

    @Autowired
    private RestTemplate restTemplate;

    public void addGP(GP gp){
        gpRepository.save(gpMapper.toEntity(gp));
    }

    public GP getById(Long id){
        Optional<GPEntity> optionalGP = gpRepository.findById(id);
        if (optionalGP.isPresent()){
            GP gp = gpMapper.toDTO(optionalGP.get());
            gp.setCircuit(getRESTCircuit(gp.getCircuitId()));
            return gp;
        }
        return null;
    }

    public List<GP> getAll(){
        List<GP> gpList = StreamSupport.stream(gpRepository.findAll().spliterator(), false)
                .map(g -> gpMapper.toDTO(g))
                .collect(Collectors.toList());
        for (GP gp : gpList){
            gp.setCircuit(getRESTCircuit(gp.getCircuitId()));
        }
        return gpList;
    }

    private Circuit getRESTCircuit(Long id){
        try{
            URI circuitURI = new URI(circuitURL + id);
            return restTemplate.getForObject(circuitURI, Circuit.class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }
}
