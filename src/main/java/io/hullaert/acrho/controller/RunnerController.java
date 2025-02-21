package io.hullaert.acrho.controller;

import io.hullaert.acrho.exception.RunnerNotFoundException;
import io.hullaert.acrho.model.Runner;
import io.hullaert.acrho.repository.RunnerRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RunnerController {

    private final RunnerRepository runnerRepository;

    @Autowired
    public RunnerController(RunnerRepository someDependency) {
        this.runnerRepository = someDependency;
    }

    @Operation(summary = "Get a runner by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the runner",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Runner.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Runner not found",
                    content = @Content) })
    @GetMapping("/runner/{runnerId}")
    public Runner getRunner(@PathVariable long runnerId ) {
        return runnerRepository.findById(runnerId).orElseThrow(() -> new RunnerNotFoundException(runnerId));
    }

    @DeleteMapping("/runner/{runnerId}")
    public void deleteRunner(@PathVariable long runnerId) {
        runnerRepository.deleteById(runnerId);
    }
}
