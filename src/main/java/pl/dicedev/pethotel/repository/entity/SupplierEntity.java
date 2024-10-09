package pl.dicedev.pethotel.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "supplier")
@Builder
public class SupplierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "supplier_name", nullable = false)
    private String supplierName;
    @Column(name = "contact_person", nullable = false)
    private String contactPerson;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name = "email_address", nullable = false)
    private String emailAddress;
    @Column(name = "address", nullable = false)
    private String address;

}
