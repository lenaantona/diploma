package ru.aep.api;
import org.json.simple.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.aep.model.Employer;
import ru.aep.model.Worker;
import ru.aep.service.EmployerService;
import ru.aep.service.WorkerService;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/ui/workers")
public class WorkerHtml {


    private final WorkerService service;

    public WorkerHtml(WorkerService service) {
        this.service = service;
    }

    @GetMapping()
    public String table(Model model) {
        List<Worker> workers = service.getAll();
        model.addAttribute("workers", workers);
        return "workers";
    }

    @GetMapping("/workers_all")
    public String all(Model model) {
        List<Worker> workers = service.getAll();
        model.addAttribute("workers", workers);
        return "workers_all";
    }

    @PostMapping()
    public void addEmployer(@RequestBody Worker worker) {
        try {
            service.add(worker);
        } catch (NoSuchElementException ignored) {
        }
    }

    @GetMapping("/find/{surname}/{lastname}")
    public String findByWorker(@PathVariable("surname") String surname, @PathVariable("lastname") String lastname, Model model) {
        Worker worker = service.getWorkerBySurnameAndFirstName(surname, lastname);
        model.addAttribute("worker", worker);
        return "workers";
    }

    @DeleteMapping(value = "/{id}")
    public String deleteWorker(@PathVariable Long id) {
        service.delete(id);
        return "workers";
    }

    @ResponseBody
    @GetMapping("/find_contract/{surname}/{lastname}")
    public String findByWorkerContract(@PathVariable("surname") String surname, @PathVariable("lastname") String lastname, Model model) {
        Worker worker = service.getWorkerBySurnameAndFirstName(surname, lastname);
        model.addAttribute("worker", worker);
        JSONObject jworker = new JSONObject();
        jworker.put("id", worker.getId());
        jworker.put("surname", worker.getSurname());
        jworker.put("firstname" , worker.getFirstname());
        jworker.put("lastname", worker.getLastname());
        jworker.put("birthdate", worker.getBirthdate().toString());
        return jworker.toJSONString();
    }
}
