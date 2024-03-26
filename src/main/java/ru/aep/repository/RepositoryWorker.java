package ru.aep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aep.model.ContractWorker;
import ru.aep.model.Worker;

import java.util.List;

public interface RepositoryWorker extends JpaRepository<Worker, Long> {

    //List<Worker> findBySurnameAndFirstname(String surname, String firstname);
    Worker findBySurnameAndFirstname(String surname, String firstname);
}
