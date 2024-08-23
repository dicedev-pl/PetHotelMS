package pl.dicedev.pethotel.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.dicedev.pethotel.config.RoomsTypeProperty;

import java.util.Set;

@RestController
@RequestMapping("/vi/rooms")
@AllArgsConstructor
public class RoomsTypeController {

    private RoomsTypeProperty roomsTypeProperty;

    @GetMapping
    public Set<String> getAllRooms(){
        return roomsTypeProperty.getRooms();
    }

}
