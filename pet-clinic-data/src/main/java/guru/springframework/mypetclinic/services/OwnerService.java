package guru.springframework.mypetclinic.services;

import guru.springframework.mypetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudeService<Owner, Long>{

    Owner findByLastName(String lastName);

    /* possiamo direttamente cancellare questi metodi perche` vengono dierttamente implementati dall'interfaccia principale
    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
     */
}
