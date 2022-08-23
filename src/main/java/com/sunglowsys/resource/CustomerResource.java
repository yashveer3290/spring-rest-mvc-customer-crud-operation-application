package com.sunglowsys.resource;

import com.sunglowsys.domain.Customer;
import com.sunglowsys.service.impl.impl.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerResource.class);
    private final CustomerService customerService;

    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {

        LOGGER.debug("Rest request to create Customer / {}",customer);
        Customer result = customerService.save(customer);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable("id") Long id){
        Customer result = customerService.update(customer,id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAll() {
        List<Customer> result = customerService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id) {

        Customer result = customerService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        customerService.delete(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
