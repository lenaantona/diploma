package ru.aep.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aep.model.Employer;
import ru.aep.repository.RepositoryEmployer;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class EmployerService {

    private final RepositoryEmployer repositoryEmployer;

    public List<Employer> getAll(){
        return repositoryEmployer.findAll();
    }


    public Employer getEmployerById(Long id){
        return repositoryEmployer.findById(id).orElse(null);
    }

    public Employer getEmployerByInn(Long inn){
        return repositoryEmployer.findByInn(inn);
    }

    public Employer getEmployerByName(String name){
        return repositoryEmployer.findByName(name);
    }

    public Employer addEmployer(Employer employer){
        repositoryEmployer.save(employer);
        return employer;
    }

    public void delete(Long id){
        if (!repositoryEmployer.existsById(id)) {
            throw new NoSuchElementException("Не найден работодатель с идентификатором \"" + id + "\"");
        }
        repositoryEmployer.delete(getEmployerById(id));
    }

}