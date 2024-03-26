package ru.aep.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.*;

/***
 * Сущность договор имеет ссылки на роботодателей и виды работ
 */
@Entity
@Table(name = "contract")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number") //номер договора
    private String number;


    @Column(name = "date") //дата договора
    private LocalDate date;

    @Column(name = "period") //кол-во месяцев
    private Integer period;

    @Column(name = "count") //кол-во работников
    private Integer count;

    @Column(name = "cost") //сумма мат.поддержки
    private Double cost;

    @Column(name = "start") //начало периода работ
    private LocalDate startDate;

    @Column(name = "stop") //окончание периода работ
    private LocalDate stopDate;

    @ManyToOne
    @JoinColumn(name = "type_workid") //ссылка на виды работ
    private TypeWork type_workid;

    @ManyToOne
    @JoinColumn(name = "employer_id")  //ссылка на работодателей
    private Employer employer;

    public Contract(String number, LocalDate date, Integer period, Integer count, LocalDate startDate, LocalDate stopDate) {
        this.number = number;
        this.date = date;
        this.period = period;
        this.count = count;
        this.cost = null;
        this.startDate = startDate;
        this.stopDate = stopDate;
        this.type_workid = null;
        this.employer = null;
    }
}
