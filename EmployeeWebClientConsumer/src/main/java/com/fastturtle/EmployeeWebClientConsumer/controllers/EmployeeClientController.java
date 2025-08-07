package com.fastturtle.EmployeeWebClientConsumer.controllers;

import com.fastturtle.EmployeeWebClientConsumer.dtos.Employee;
import com.fastturtle.EmployeeWebClientConsumer.services.EmployeeClient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/client/employees")
@Tag(name = "EmployeeClient", description = "REST API for Employee CRUD operations.")
public class EmployeeClientController {

    private final EmployeeClient employeeClient;

    public EmployeeClientController(EmployeeClient employeeClient) {
        this.employeeClient = employeeClient;
    }

    @Operation(
            summary =
                    "${api.employee-client.get-all-employees.description}",
            description =
                    "${api.employee-client.get-all-employees.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description =
                    "${api.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "400", description =
                    "${api.responseCodes.badRequest.description}"),
            @ApiResponse(responseCode = "404", description =
                    "${api.responseCodes.notFound.description}"),
            @ApiResponse(responseCode = "422", description =
                    "${api.responseCodes.unprocessableEntity.description}")
    })
    @GetMapping(value = "/", produces = "application/json")
    public Flux<Employee> getAllEmployees() {
        return employeeClient.getAllEmployees();
    }

    @Operation(
            summary =
                    "${api.employee-client.create-employee.description}",
            description =
                    "${api.employee-client.create-employee.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description =
                    "${api.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "400", description =
                    "${api.responseCodes.badRequest.description}"),
            @ApiResponse(responseCode = "404", description =
                    "${api.responseCodes.notFound.description}"),
            @ApiResponse(responseCode = "422", description =
                    "${api.responseCodes.unprocessableEntity.description}")
    })
    @PostMapping(value = "/", produces = "application/json")
    public Mono<Employee> createEmployee(@RequestBody Employee employee) {
        return employeeClient.createEmployee(employee);
    }

}
