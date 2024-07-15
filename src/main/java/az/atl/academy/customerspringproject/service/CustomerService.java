package az.atl.academy.customerspringproject.service;

import az.atl.academy.customerspringproject.model.CustomerDto;
import az.atl.academy.customerspringproject.model.request.CustomerRequest;

import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer(CustomerRequest customerRequest);
    CustomerDto findById(Long id);
    List<CustomerDto> findAllCustomers();
    void updateCustomer(Long id, CustomerDto customerDto);
    void deleteCustomer (Long id);
}
