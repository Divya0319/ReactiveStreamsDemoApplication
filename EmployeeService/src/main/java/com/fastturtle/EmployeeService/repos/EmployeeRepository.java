package com.fastturtle.EmployeeService.repos;

import com.fastturtle.EmployeeService.models.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {

    Mono<Employee> findByName(String name);

    Flux<Employee> findAll();
}
