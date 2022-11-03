package com.lucasferreira.logistics.service;

import com.lucasferreira.logistics.domain.model.Client;
import com.lucasferreira.logistics.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <b>Service class</b>: responsável pelas regras de negócio <br>
 * <b>@Service</b>: componente para indicar que a classe é uma classe de serviço <br>
 * <b>@RequiredArgsConstructor</b>: responsável por gerar construtor para classes abstratas (final)
 */
@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public List<Client> listAll() {
        return clientRepository.findAll();
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }
}
