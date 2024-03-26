package ru.aep.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/***
 * сущность Виды работ
 */
@Entity
@Table(name = "typework")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeWork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "price") //сумма мат.поддержки
    private Double price;

    @Column(name = "name") //Нименование вида работ
    private String name;

    @Column(name = "limited") //Сумма по лимитам
    private Double limited;

    @Column(name = "summa") //накопительная сумму по определеному виду договоров
    private Double summa;

}