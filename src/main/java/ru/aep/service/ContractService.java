package ru.aep.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aep.model.Contract;
import ru.aep.model.Employer;
import ru.aep.repository.RepositoryContract;
import ru.aep.repository.RepositoryEmployer;
import ru.aep.repository.RepositoryTypeWork;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ContractService {

    private final RepositoryContract repositoryContract;
    private final RepositoryEmployer repositoryEmployer;
    private final RepositoryTypeWork repositoryTypeWork;

    public List<Contract> getAll() {
        return repositoryContract.findAll();
    }

    public Contract getContractById(long id){
        return repositoryContract.findById(id).orElse(null);
    }

    public Contract getContractByNumber(String number){
        return repositoryContract.findByNumber(number);
    }

    public Contract add(Contract contract, Long employer, Long typework){
        if((contract == null)){
            throw new NoSuchElementException("Не все данные внесены");
        }
        contract.setType_workid(repositoryTypeWork.findById(typework).orElse(null));
        contract.setEmployer(repositoryEmployer.findById(employer).orElse(null));
        Double sum = contract.getPeriod() * contract.getCount() * contract.getType_workid().getPrice(); //расчет стоимости мат.поддеожки договора
        contract.getType_workid().setSumma(sum+contract.getType_workid().getSumma()); //обновление суммы всего потраченных по виду договора
        contract.setCost(sum);
        repositoryContract.save(contract);
        return contract;
    }

    public List<Contract> delete(Long id){
        if (!repositoryContract.existsById(id)) {
            throw new NoSuchElementException("Не найден договор с идентификатором \"" + id + "\"");
        }
        repositoryContract.delete(getContractById(id));
        return repositoryContract.findAll();
    }
}
