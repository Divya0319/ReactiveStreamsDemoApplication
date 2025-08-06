package com.fastturtle.EmployeeService.controllers;

import com.fastturtle.EmployeeService.models.Employee;
import com.fastturtle.EmployeeService.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employees")
public class EmployeeRESTController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRESTController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public Flux<Employee> getAllEmployees() {
        return employeeService.findAll()
                .doOnNext(employee -> System.out.println("Emitting Employee : " + employee.getName() + " on thread " + Thread.currentThread().getName()));
    }

    @PostMapping
    public Mono<Employee> createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }
}
