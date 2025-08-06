package com.fastturtle.reactivestreamsdemo.services;

import com.fastturtle.reactivestreamsdemo.models.Employee;
import com.fastturtle.reactivestreamsdemo.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Flux<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Mono<Employee> createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

}
