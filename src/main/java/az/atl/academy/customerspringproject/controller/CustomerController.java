package az.atl.academy.customerspringproject.controller;

import az.atl.academy.customerspringproject.model.CustomerDto;
import az.atl.academy.customerspringproject.model.request.CustomerRequest;
import az.atl.academy.customerspringproject.service.CustomerService;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customersSpring")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer (@Valid @RequestBody CustomerRequest customerRequest) {
        if (customerRequest.getName() == null || customerRequest.getLastName() == null ||
                customerRequest.getEmail() == null || customerRequest.getCountry() == null) {
            throw new NullPointerException("field is null");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customerRequest));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomerDto>> findAlStudents() {
        return ResponseEntity.ok(customerService.findAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> findById(@NonNull @PathVariable Long id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStudent(@PathVariable Long id, @RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(id, customerDto);
        return  ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
