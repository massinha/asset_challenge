package br.com.srm.challenge.endpoint;

import br.com.srm.challenge.model.Customer;
import br.com.srm.challenge.model.Risk;
import br.com.srm.challenge.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/customer")
public class CustomerEndpoint {

    @Autowired
    CustomerRepository repository;

    @GetMapping
    public List<Customer> getCustomers(){
        return repository.findAll();
    }

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer) throws Exception {
        customer.setTax(Risk.getTaxByRisk(customer.getRisk()));
        return repository.save(customer);
    }

}
