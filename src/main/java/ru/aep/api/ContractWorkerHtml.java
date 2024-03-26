package ru.aep.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.aep.model.Contract;
import ru.aep.model.ContractWorker;
import ru.aep.model.Employer;
import ru.aep.service.ContractWorkerService;
import ru.aep.service.EmployerService;

import java.time.LocalDate;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/ui/contractworker")
public class ContractWorkerHtml {
    private final ContractWorkerService contractWorkerService;

    public ContractWorkerHtml(ContractWorkerService contractWorkerService) {
        this.contractWorkerService = contractWorkerService;
    }

    @ResponseBody
    @GetMapping("/{contract_id}/{worker_id}") //добавление работника в договор
    public String create(@PathVariable Long contract_id, @PathVariable Long worker_id) {
        ContractWorker contractWorker = new ContractWorker();
        contractWorkerService.add(contractWorker, contract_id, worker_id);
        return "{\"Success\":\"true\"}";
    }
}
