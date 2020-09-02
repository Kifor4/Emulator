package ru.pflb.emulator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.pflb.emulator.model.dto.ClientDto;
import ru.pflb.emulator.service.ClientService;
import ru.pflb.emulator.service.impl.ClientServiceImpl;

@RestController
public class ClientController {
    private ClientService clientService;

    public ClientController(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<ClientDto> getClient(@PathVariable long id) {
        ClientDto client = clientService.getUserById(id);
        return ResponseEntity.ok(client);
    }

    @PostMapping("/client")
    public ResponseEntity<ClientDto> addClient(@Validated @RequestBody ClientDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/client/{id}")
    public ResponseEntity<ClientDto> deleteClient(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/client/{id}")
    public ResponseEntity<ClientDto> updateClient(@RequestBody ClientDto dto, @PathVariable long id) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
