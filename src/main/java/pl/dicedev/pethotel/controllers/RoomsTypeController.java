package pl.dicedev.pethotel.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.dicedev.pethotel.config.CustomDiceDevProperty;

import java.util.Set;

@RestController
@RequestMapping("/vi")
@AllArgsConstructor
public class RoomsTypeController {

    private CustomDiceDevProperty customDiceDevProperty;

    @GetMapping("rooms")
    public Set<String> getAllRooms(){
        return customDiceDevProperty.getRoomsType();
    }

    @GetMapping("guest-type")
    public Set<String> getAllGuestType(){
        return customDiceDevProperty.getGuestType();
    }

}
