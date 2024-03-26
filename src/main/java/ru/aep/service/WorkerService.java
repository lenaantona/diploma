package ru.aep.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aep.model.Employer;
import ru.aep.model.Worker;
import ru.aep.repository.RepositoryWorker;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class WorkerService {

    private final RepositoryWorker repositoryWorker;

    public List<Worker> getAll(){
        return repositoryWorker.findAll();
    }

    public Worker getWorkerById(long id){
        return repositoryWorker.findById(id).orElse(null);
    }

    public Worker getWorkerBySurnameAndFirstName(String surname, String firstname){
        return repositoryWorker.findBySurnameAndFirstname(surname, firstname);
    }

    public Worker add(Worker worker){
        repositoryWorker.save(worker);
        return worker;
    }

    public void delete(Long id){
        if (!repositoryWorker.existsById(id)) {
            throw new NoSuchElementException("Не найден работник с идентификатором \"" + id + "\"");
        }
        repositoryWorker.delete(getWorkerById(id));
    }
}
