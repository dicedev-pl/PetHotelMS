package pl.dicedev.pethotel.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "toys")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ToysEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(insertable=false, updatable=false)
    private UUID id;

    @Column(name = "toy_name", nullable = false)
    private String toyName;

    @Column(name = "toy_type", nullable = false)
    private String toyType;

    @Column(name = "cleaning", nullable = false)
    private String cleaning;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "quantity_in_stock", nullable = false)
    private int quantityInStock;

    @Column(name = "caretaker_id", nullable = false)
    private UUID caretakerID;

    @Column(name = "wear_out", nullable = false)
    private UUID wearOut;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private SupplierEntity supplier;

}
