package ru.aep.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aep.model.Contract;
import ru.aep.model.ContractWorker;
import ru.aep.model.Employer;
import ru.aep.model.Worker;
import ru.aep.repository.RepositoryContract;
import ru.aep.repository.RepositoryContractWorker;
import ru.aep.repository.RepositoryWorker;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContractWorkerService {

    private final RepositoryContractWorker repositoryContractWorker;
    private final RepositoryWorker repositoryWorker;
    private final RepositoryContract repositoryContract;


    public List<ContractWorker> getAll(){
        return repositoryContractWorker.findAll();
    }

    public List<Worker> getByWorker(Long id){ //находим всех работников по договору
         List<ContractWorker> contractWorkers = List.copyOf(repositoryContractWorker.findByContractId(id));
        return List.copyOf(contractWorkers.stream().map(ContractWorker::getWorker).collect(Collectors.toList()));
    }

    public ContractWorker add(ContractWorker contractWorker, Long contract_id, Long worker_id){ //добавляем в договор работников
        contractWorker.setContract(repositoryContract.findById(contract_id).orElse(null));
        contractWorker.setWorker(repositoryWorker.findById(worker_id).orElse(null));
        repositoryContractWorker.save(contractWorker);
        return contractWorker;
    }


}
