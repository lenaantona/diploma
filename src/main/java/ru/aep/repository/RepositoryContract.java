package ru.aep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aep.model.Contract;
import ru.aep.model.Employer;

public interface RepositoryContract extends JpaRepository<Contract, Long> {

    Contract findByNumber(String number);
}
