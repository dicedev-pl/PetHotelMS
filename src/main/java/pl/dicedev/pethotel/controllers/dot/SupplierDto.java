package pl.dicedev.pethotel.controllers.dot;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class SupplierDto {

    private UUID id;
    private String supplierName;
    private String contactPerson;
    private String phoneNumber;
    private String emailAddress;
    private String address;

}
