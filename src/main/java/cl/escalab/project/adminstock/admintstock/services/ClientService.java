package cl.escalab.project.adminstock.admintstock.services;

import cl.escalab.project.adminstock.admintstock.entities.Client;
import cl.escalab.project.adminstock.admintstock.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public Client saveOrUpdate(Client client) {

        return clientRepository.save(client);
    }

    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(Long id) {
        return clientRepository.getById(id);
    }

    public void delete(Long id) {
        Client client = findById(id);
        clientRepository.delete(client);
    }
}
