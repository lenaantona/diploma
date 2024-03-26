package ru.aep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aep.model.Employer;
import ru.aep.model.TypeWork;

import java.util.List;

public interface RepositoryTypeWork extends JpaRepository<TypeWork, Long> {

    TypeWork findByName(String name);
}

