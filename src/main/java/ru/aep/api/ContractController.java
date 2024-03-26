package ru.aep.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aep.model.Contract;
import ru.aep.model.Employer;
import ru.aep.model.Worker;
import ru.aep.service.ContractService;
import ru.aep.service.EmployerService;

import java.util.List;

@RestController
@RequestMapping("/contract")
@Tag(name = "Contract")
public class ContractController {


    private final ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping()
    @Operation(summary = "get all", description = "Загружает все договора")
    public List<Contract> getAll() {
        return List.copyOf(contractService.getAll());
    }


}
