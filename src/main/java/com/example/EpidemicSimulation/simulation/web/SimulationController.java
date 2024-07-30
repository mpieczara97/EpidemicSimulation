package com.example.EpidemicSimulation.simulation.web;

import com.example.EpidemicSimulation.simulation.service.SimulationService;
import com.example.EpidemicSimulation.simulation.converters.SimulationConverter;
import com.example.EpidemicSimulation.simulation.domain.Simulation;
import com.example.EpidemicSimulation.simulation.dto.SimulationDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/simulation")
@RestController
class SimulationController {

    private final SimulationService simulationService;

    SimulationController(SimulationService simulationService) {
        this.simulationService = simulationService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SimulationDto> getAll() {

        List<Simulation> simulations = simulationService.findAll();

        return simulations.stream()
                .map(SimulationConverter::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> addSimulation(@RequestBody SimulationDto simulationDto) {
        Simulation simulation = simulationService.addSimulation(simulationDto);
        return ResponseEntity.created(createdSimulationUri(simulation)).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Simulation> getById(@PathVariable Long id) {
        return simulationService
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        simulationService.removeSimulationById(id);
    }

    private URI createdSimulationUri(Simulation simulation) {
        return ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/" + simulation.getId().toString()).build().toUri();
    }
}