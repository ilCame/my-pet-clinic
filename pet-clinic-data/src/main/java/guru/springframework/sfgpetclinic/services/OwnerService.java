package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudeService<Owner, Long>{

    Owner findByLastName(String lastName);
}
