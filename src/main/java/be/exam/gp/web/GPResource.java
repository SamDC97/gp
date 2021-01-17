package be.exam.gp.web;

import be.exam.gp.service.GPService;
import be.exam.gp.service.dto.GP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GPResource {

    @Autowired
    private GPService gpService;

    @PostMapping("/add-gp")
    public void addGP(@RequestBody GP gp){
        gpService.addGP(gp);
    }

    @GetMapping("/gps")
    public ResponseEntity<List<GP>> getAll(){
        return new ResponseEntity<>(gpService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/gp/{id}")
    public ResponseEntity<GP> getById(@PathVariable Long id){
        return new ResponseEntity<>(gpService.getById(id), HttpStatus.OK);
    }
}
