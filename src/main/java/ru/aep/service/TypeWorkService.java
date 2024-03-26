package ru.aep.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aep.model.Employer;
import ru.aep.model.TypeWork;
import ru.aep.repository.RepositoryTypeWork;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class TypeWorkService {
    private final RepositoryTypeWork repositoryTypeWork;

    public List<TypeWork> getAll(){
        return repositoryTypeWork.findAll();
    }


    public TypeWork getTypeWorkerById(long id){
        return repositoryTypeWork.findById(id).orElse(null);
    }

    public TypeWork getTypeWorkerByName(String name){
        return repositoryTypeWork.findByName(name);
    }

    public TypeWork add(TypeWork typeWork){
        repositoryTypeWork.save(typeWork);
        return typeWork;
    }

    public List<TypeWork> delete(Long id){
        if (!repositoryTypeWork.existsById(id)) {
            throw new NoSuchElementException("Не найден тип работ с идентификатором \"" + id + "\"");
        }
        repositoryTypeWork.delete(getTypeWorkerById(id));
        return repositoryTypeWork.findAll();
    }
}