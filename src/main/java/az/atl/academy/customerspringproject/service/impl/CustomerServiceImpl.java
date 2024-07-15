package az.atl.academy.customerspringproject.service.impl;

import az.atl.academy.customerspringproject.dao.entity.CustomerEntity;
import az.atl.academy.customerspringproject.dao.repository.CustomerRepository;
import az.atl.academy.customerspringproject.exception.CustomerNotFoundException;
import az.atl.academy.customerspringproject.mapper.CustomerMapper;
import az.atl.academy.customerspringproject.model.CustomerDto;
import az.atl.academy.customerspringproject.model.request.CustomerRequest;
import az.atl.academy.customerspringproject.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    @Override
    public CustomerDto createCustomer(CustomerRequest customerRequest) {

        CustomerEntity customerEntity = customerMapper.toEntity(customerRequest);
        return customerMapper.toDto(customerRepository.save(customerEntity));
    }

    @Override
    public CustomerDto findById(Long id) {
        return customerRepository.findById(id)
                .map(customerMapper :: toDto)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with this id " + id));
    }

    @Override
    public List<CustomerDto> findAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customerMapper :: toDto)
                .toList();
    }

    @Override
    public void updateCustomer(Long id, CustomerDto customerDto) {
//        CustomerEntity customerEntity = customerRepository.findById(id)
//                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with this id " + id));

        customerRepository.findById(id)
                .map(customerMapper :: toDto)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with this id " + id));
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.findById(id)
                .ifPresent(customerEntity -> customerRepository.deleteById(id));
    }
}
