package ru.aep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aep.model.Contract;
import ru.aep.model.ContractWorker;
import ru.aep.model.Worker;

import java.util.List;

public interface RepositoryContractWorker extends JpaRepository<ContractWorker, Long> {
    List<ContractWorker> findByContractId(Long id);

    List<ContractWorker> findByWorkerId(Long id);

}
