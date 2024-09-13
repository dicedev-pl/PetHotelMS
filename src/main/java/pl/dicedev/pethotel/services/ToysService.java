package pl.dicedev.pethotel.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dicedev.pethotel.controllers.dot.ToysDto;
import pl.dicedev.pethotel.repository.ToysRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ToysService {

    private final ToysRepository toysRepository;

    public List<ToysDto> getAllToys() {
        return toysRepository.findAll().stream()
                .map(toy -> ToysDto.builder()
                        .id(toy.getId())
                        .toyName(toy.getToyName())
                        .toyType(toy.getToyType())
                        .supplierID(toy.getSupplier().getId())
                        .quantityInStock(toy.getQuantityInStock())
                        .brand(toy.getBrand())
                        .cleaning(toy.getCleaning())
                        .wearOut(toy.getWearOut())
                        .caretakerID(toy.getCaretakerID())
                        .build())
                .collect(Collectors.toList());
    }
}
