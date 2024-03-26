package ru.aep.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.aep.model.Employer;
import ru.aep.repository.RepositoryEmployer;
import ru.aep.service.EmployerService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/employer")
@Tag(name = "Employer")
public class EmployerController {

    private final EmployerService employerService;

    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping()
    @Operation(summary = "get all", description = "Загружает всех работодателей")
    public List<Employer> getAll() {
        return List.copyOf(employerService.getAll());
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "get employer by id", description = "Загружает работодателя по заданному id")
    public Employer getEmployerById(@PathVariable Long id) {
        return employerService.getEmployerById(id);
    }

    @GetMapping(value = "/inn/{inn}")
    @Operation(summary = "get employer by inn", description = "Загружает работодателя по заданному inn")
    public Employer getEmployerByInn(@PathVariable Long inn) {
        return employerService.getEmployerByInn(inn);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "delete employer by id", description = "Удаляет работодателя по заданному id")
    public void delete(@PathVariable Long id) {
         employerService.delete(id);
    }

    @PostMapping
    @Operation(summary = "add employer", description = "Добавляет нового работодателя")
    public ResponseEntity<Employer> addEmployer(@RequestBody Employer employer) {
        try {
            employerService.addEmployer(employer);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(employer);
    }
}
