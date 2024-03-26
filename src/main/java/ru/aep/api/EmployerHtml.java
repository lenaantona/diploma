package ru.aep.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.aep.model.Employer;
import ru.aep.service.EmployerService;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/ui/employers")
public class EmployerHtml {

    private final EmployerService service;

    public EmployerHtml(EmployerService service) {
        this.service = service;
    }
    @GetMapping()
    public String table(Model model) {
        List<Employer> employers = service.getAll();
        model.addAttribute("employers", employers);
        return "employers";
    }
    @GetMapping("/employers_all")   //все работодатели
    public String all(Model model) {
        List<Employer> employers = service.getAll();
        model.addAttribute("employers", employers);
        return "employers_all";
    }

    @PostMapping() //добавление работодателя
    public String addEmployer(@RequestBody Employer employer, Model model) {
            service.addEmployer(employer);
            System.out.println(employer);
            model.addAttribute("employer", employer);
            return "employers";
    }

    @GetMapping("/inn/{inn}")  //поиск по ИНН
    public String findByInn(@PathVariable Long inn, Model model) {
        Employer employer = service.getEmployerByInn(inn);
        model.addAttribute("employer", employer);
        return "employers";
    }

    @DeleteMapping("/{id}") //удаление по id
    public String deleteEmployer(@PathVariable Long id) {
        service.delete(id);
        return "employers";
    }
}
