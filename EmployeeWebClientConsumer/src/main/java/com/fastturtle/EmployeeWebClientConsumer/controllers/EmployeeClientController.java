package com.fastturtle.EmployeeWebClientConsumer.controllers;

import com.fastturtle.EmployeeWebClientConsumer.dtos.Employee;
import com.fastturtle.EmployeeWebClientConsumer.services.EmployeeClient;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/client/employees")
public class EmployeeClientController {

    private final EmployeeClient employeeClient;

    public EmployeeClientController(EmployeeClient employeeClient) {
        this.employeeClient = employeeClient;
    }

    @GetMapping
    public Flux<Employee> getAllEmployees() {
        return employeeClient.getAllEmployees();
    }

    @PostMapping
    public Mono<Employee> createEmployee(@RequestBody Employee employee) {
        return employeeClient.createEmployee(employee);
    }

}
