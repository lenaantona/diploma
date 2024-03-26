package ru.aep.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.time.LocalDate;
import java.util.*;

/***
 * сущность работник
 */
@Entity
@Table(name = "worker")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "surname") //фамилия
    private String surname;

    @Column(name = "firstname") //имя
    private String firstname;

    @Column(name = "lastname") //отчестов при наличии
    private String lastname;

    @Column(name = "birthdate") //день рождения
    private LocalDate birthdate;
}