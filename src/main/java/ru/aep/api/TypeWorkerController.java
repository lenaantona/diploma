package ru.aep.api;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.aep.model.Employer;
import ru.aep.model.TypeWork;
import ru.aep.service.EmployerService;
import ru.aep.service.TypeWorkService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/typeworker")
@Tag(name = "TypeWorker")
public class TypeWorkerController {


    private final TypeWorkService typeWorkService;

    public TypeWorkerController(TypeWorkService typeWorkService) {
        this.typeWorkService = typeWorkService;
    }

    @GetMapping()
    @Operation(summary = "get all", description = "Загружает все виды работ")
    public List<TypeWork> getAll() {
        return List.copyOf(typeWorkService.getAll());
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "get typework by id", description = "Загружает вид работ по заданному id")
    public TypeWork getTypeWorkById(@PathVariable long id) {
        return typeWorkService.getTypeWorkerById(id);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "delete typework by id", description = "Удаляет вид работ по заданному id")
    public List<TypeWork> delete(@PathVariable long id) {
        return typeWorkService.delete(id);
    }

    @PostMapping(value = "/create")
    @Operation(summary = "add typeworker", description = "Добавляет новый вид работ")
    public ResponseEntity<TypeWork> add(@RequestBody TypeWork typeWork) {
        try {
            typeWorkService.add(typeWork);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(typeWork);
    }
}
