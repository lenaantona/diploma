package ru.aep.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.aep.model.Employer;
import ru.aep.model.TypeWork;
import ru.aep.service.TypeWorkService;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/ui/typeworks")
public class TypeWorkHtml {

    private final TypeWorkService service;

    public TypeWorkHtml(TypeWorkService service) {
        this.service = service;
    }

    @GetMapping()
    public String table(Model model) {
        List<TypeWork> typeWork = service.getAll();
        model.addAttribute("typeworks", typeWork);
        return "typeworks";
    }

    @PostMapping()
    public String addTypeWork(@RequestBody TypeWork typeWork) {
        try {
            service.add(typeWork);
        } catch (NoSuchElementException ignored) {
            return "typeworks";
        }
        return "typeworks";
    }
}
