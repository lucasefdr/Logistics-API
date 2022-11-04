package com.lucasferreira.logistics.controller;

import com.lucasferreira.logistics.domain.Client;
import com.lucasferreira.logistics.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> listAll() {
        return ResponseEntity.ok(clientService.listAll());
    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<Client>> findByName(@RequestParam String name) {
        return ResponseEntity.ok(clientService.findByName(name));
    }

    @GetMapping(path = "/containing")
    public ResponseEntity<List<Client>> findByNameContaining(@RequestParam String name) {
        return ResponseEntity.ok(clientService.findByContaining(name));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Client> save(@RequestBody @Valid Client client) {
        return new ResponseEntity<>(clientService.save(client), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody Client client) {
        clientService.replace(client);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
