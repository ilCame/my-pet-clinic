package guru.springframework.mypetclinic.services;

import guru.springframework.mypetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudeService<Owner, Long>{

    Owner findByLastName(String lastName);
}
