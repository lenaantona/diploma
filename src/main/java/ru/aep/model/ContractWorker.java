package ru.aep.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * сущность объединяющая две сущности договор и работнико по этому договору
 */
@Entity
@Table(name = "contract_worker")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractWorker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "contract_id") //ссылка на договор
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "worker_id") //ссылка на работник
    private Worker worker;

    public ContractWorker(Contract contract, Worker worker) {
        this.contract = contract;
        this.worker = worker;
    }
}
