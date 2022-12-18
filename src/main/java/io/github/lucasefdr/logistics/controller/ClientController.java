package io.github.lucasefdr.logistics.controller;

import io.github.lucasefdr.logistics.domain.Client;
import io.github.lucasefdr.logistics.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.postgresql.largeobject.BlobOutputStream;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Log4j2
public class ClientController {

    private final ClientService clientService;

    @GetMapping(path = "/client")
    public ResponseEntity<List<Client>> listAll() {
        return ResponseEntity.ok(clientService.listAll());
    }

    @GetMapping(path = "/client/find")
    public ResponseEntity<List<Client>> findByName(@RequestParam String name) {
        return ResponseEntity.ok(clientService.findByName(name));
    }

    @GetMapping(path = "/client/containing")
    public ResponseEntity<List<Client>> findByNameContaining(@RequestParam String name) {
        return ResponseEntity.ok(clientService.findByContaining(name));
    }

    @GetMapping(path = "/client/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails
    ) {
        log.info(userDetails);
        return ResponseEntity.ok(clientService.findById(id));
    }

    @PostMapping(path = "/client/admin")
    public ResponseEntity<Client> save(@RequestBody @Valid Client client) {
        return new ResponseEntity<>(clientService.save(client), HttpStatus.CREATED);
    }

    @PutMapping(path = "/client/admin")
    public ResponseEntity<Void> replace(@RequestBody Client client) {
        clientService.replace(client);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/client/admin/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
