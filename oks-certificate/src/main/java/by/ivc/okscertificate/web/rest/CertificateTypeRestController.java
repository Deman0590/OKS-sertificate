package by.ivc.okscertificate.web.rest;


import by.ivc.okscertificate.dto.CertificateTypeDTO;
import by.ivc.okscertificate.service.CertificateTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "certificate/type")
public class CertificateTypeRestController {

    private final CertificateTypeService typeService;

    @Autowired
    public CertificateTypeRestController(CertificateTypeService typeService) {
        this.typeService = typeService;
    }

    @PostMapping(produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public ResponseEntity create(@RequestBody CertificateTypeDTO certificateTypeDTO){
        return new ResponseEntity<>(typeService.save(certificateTypeDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id){
        typeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<CertificateTypeDTO> findAll(){
        return typeService.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public CertificateTypeDTO findById(@PathVariable(name="id") Long id){
        return typeService.findById(id);
    }

    @GetMapping(path = "name/{name}", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<CertificateTypeDTO> findByName(@PathVariable(name = "name") String name){
        return typeService.findByName(name);
    }
}