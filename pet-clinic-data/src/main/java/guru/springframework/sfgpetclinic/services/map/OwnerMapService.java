package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {

        Owner savedOwner = null;

        if(object != null){
            // l'owner puo' avere uno o piu' pet
            if(object.getPets() != null){
                object.getPets().forEach(pet -> { // per ogni pet che andremo a salvare dobbiamo fare in modo che abbiano un tipo prima di salvarli
                    if (pet.getPetType() != null) {
                        // identificare i pet che hanno veramente bisogno di essere salvati - quelli con null
                        if (pet.getPetType().getId() == null) {
                            //Salviamo il tipo usando il servizio petType
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }else{
                        throw new RuntimeException("Pet Type is required"); // eccezione quando manca il tipo del pet
                    }

                    //tutti i pet che devono essere salvati - il pet id deve essere nullo
                    if (pet.getId() == null){
                        // salviamo il pet id
                        Pet savedPet = petService.save(pet);
                        // mettiamo il pet id che abbiamo salvato nel loop corrente - completiamo quindi l'associazione con l'owner
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
