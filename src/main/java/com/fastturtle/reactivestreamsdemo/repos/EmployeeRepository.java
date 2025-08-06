package com.fastturtle.reactivestreamsdemo.repos;

import com.fastturtle.reactivestreamsdemo.models.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {

    Mono<Employee> findByName(String name);

    Flux<Employee> findAll();
}
