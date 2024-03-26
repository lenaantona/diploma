package ru.aep.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.aep.model.Contract;
import ru.aep.model.Employer;
import ru.aep.model.TypeWork;
import ru.aep.model.Worker;
import ru.aep.service.ContractService;
import ru.aep.service.ContractWorkerService;
import ru.aep.service.EmployerService;
import ru.aep.service.TypeWorkService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ui/contracts")
public class ContractHtml {


    private final ContractService service;
    private final EmployerService employerService;
    private final TypeWorkService typeWorkService;
    private final ContractWorkerService contractWorkerService;

    public ContractHtml(ContractService service, EmployerService employerService, TypeWorkService typeWorkService, ContractWorkerService contractWorkerService) {
        this.service = service;
        this.employerService = employerService;
        this.typeWorkService = typeWorkService;
        this.contractWorkerService = contractWorkerService;
    }

    @GetMapping()
    public String table(Model model) {
        List<Contract> contracts = service.getAll();
        model.addAttribute("contracts", contracts);
        List<Employer> employers = employerService.getAll();
        model.addAttribute("employers", employers);
        List<TypeWork> typeWorks = typeWorkService.getAll();
        model.addAttribute("typeWorks", typeWorks);
        return "contracts";
    }
    @GetMapping("/contracts_all") //все договоры
    public String all(Model model) {
        List<Contract> contracts = service.getAll();
        model.addAttribute("contracts", contracts);
        return "contracts_all";
    }

    @ResponseBody //добавление договора
    @GetMapping("/create")
    public ModelAndView create(String number, LocalDate date, Integer period, Integer count, LocalDate startDate, LocalDate stopDate, Long employer, Long typework, Model model) {
            Contract contract = new Contract(number, date, period, count, startDate, stopDate);
            service.add(contract, employer, typework);
            model.addAttribute("contract", contract);
            return new ModelAndView("contract_create");
    }


    @GetMapping("/number/{number}") //поиск по номеру договора
    public String findByNummber(@PathVariable String number, Model model) {
        Contract contract = service.getContractByNumber(number);
        model.addAttribute("contract", contract);
        return "contracts";
    }
    @DeleteMapping(value = "/{id}")  //удаление по договору
    public String deleteContract(@PathVariable Long id) {
        service.delete(id);
        return "contracts";
    }

    @GetMapping("/worker_by_contract/{id}") //все работники по конкретному договору
    public String allWorker(@PathVariable Long id, Model model) {
        List<Worker> workers = contractWorkerService.getByWorker(id);
        model.addAttribute("workers", workers);
        return "worker_by_contract";
    }

}
