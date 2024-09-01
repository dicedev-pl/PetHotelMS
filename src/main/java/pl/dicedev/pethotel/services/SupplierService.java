package pl.dicedev.pethotel.services;

import com.example.petshotel.repository.SupplierRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dicedev.pethotel.controllers.dot.SupplierDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public List<SupplierDto> getAllSupplier() {
        return supplierRepository.findAll().stream()
                .map(it -> SupplierDto.builder()
                        .supplierName(it.getSupplierName())
                        .id(it.getId())
                        .contactPerson(it.getContactPerson())
                        .emailAddress(it.getEmailAddress())
                        .phoneNumber(it.getPhoneNumber())
                        .address(it.getAddress())
                        .build())
                .collect(Collectors.toList());
    }
}
