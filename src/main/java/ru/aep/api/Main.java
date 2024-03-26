package ru.aep.api;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aep.model.Contract;

import java.util.List;

/***
 * заглавная страница
 */
@Controller
@RequestMapping("/index")
public class Main {

    @GetMapping()
    public String start() {
        return "index";
    }
}
