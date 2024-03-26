package ru.aep.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * Сущность работодатель
 */
@Entity
@Table(name = "employer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "inn") //ИНН
    private Long inn;

    @Column(name = "name") //наименование
    private String name;


}