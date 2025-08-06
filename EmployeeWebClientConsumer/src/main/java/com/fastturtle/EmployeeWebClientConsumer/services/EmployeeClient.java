package com.fastturtle.EmployeeWebClientConsumer.services;

import com.fastturtle.EmployeeWebClientConsumer.dtos.Employee;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeClient {

    private final WebClient webClient;

    public EmployeeClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<Employee> getAllEmployees() {
        return webClient.get()
                .uri("/employees")
                .retrieve()
                .bodyToFlux(Employee.class)
                .doOnNext(emp -> System.out.println("Received employee: " + emp.name()));
    }

    public Mono<Employee> createEmployee(Employee employee) {
        return webClient.post()
                .uri("/employees")
                .bodyValue(employee)
                .retrieve()
                .bodyToMono(Employee.class);
    }
}
