package upc.edu.pe.parkifybackend.payments.domain.model.entity;

import lombok.*;
import upc.edu.pe.parkifybackend.shared.domain.model.AuditModel;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payments")
public class Payment extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private Number cost;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private Long customerId;
}
