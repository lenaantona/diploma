package ru.aep.api;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.aep.model.Employer;
import ru.aep.model.Worker;
import ru.aep.service.EmployerService;
import ru.aep.service.WorkerService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/worker")
@Tag(name = "Worker")
public class WorkerController {

    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping()
    @Operation(summary = "get all", description = "Загружает всех работодателей")
    public List<Worker> getAll() {
        return List.copyOf(workerService.getAll());
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "get employer by id", description = "Загружает работодателя по заданному id")
    public Worker getEmployerById(@PathVariable long id) {
        return workerService.getWorkerById(id);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "delete employer by id", description = "Удаляет работодателя по заданному id")
    public void delete(@PathVariable long id) {
        workerService.delete(id);
    }

    @PostMapping
    @Operation(summary = "add employer", description = "Добавляет нового работодателя")
    public ResponseEntity<Worker> addEmployer(@RequestBody Worker worker) {
        try {
            workerService.add(worker);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(worker);
    }

}
