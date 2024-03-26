package ru.aep;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.aep.model.Contract;
import ru.aep.model.Employer;
import ru.aep.model.TypeWork;
import ru.aep.model.Worker;
import ru.aep.repository.*;
import ru.aep.service.ContractWorkerService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class ActiveEmploymentPolicyApplication {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(ActiveEmploymentPolicyApplication.class, args);
	}
}
