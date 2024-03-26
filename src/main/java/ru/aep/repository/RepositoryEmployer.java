package ru.aep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aep.model.ContractWorker;
import ru.aep.model.Employer;

import java.util.List;

public interface RepositoryEmployer extends JpaRepository<Employer, Long> {

    Employer findByInn(Long inn);

    Employer findByName(String name);
}

