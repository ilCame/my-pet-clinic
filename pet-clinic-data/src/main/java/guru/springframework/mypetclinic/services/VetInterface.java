package guru.springframework.mypetclinic.services;

import guru.springframework.mypetclinic.model.Vet;

import java.util.Set;

public interface VetInterface {
    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
