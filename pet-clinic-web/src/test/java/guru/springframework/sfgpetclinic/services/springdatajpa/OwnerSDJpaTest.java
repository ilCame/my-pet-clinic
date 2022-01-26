package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaTest {

    public static final String LAST_NAME = "Smith";
    public static final long ID = 1L;

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSDJpa ownerService;

    Owner returnOwner;

    private Owner getOwner() {
        Owner ownerToSave = new Owner();
        ownerToSave.setId(ID);
        ownerToSave.setLastName(LAST_NAME);
        return ownerToSave;
    }

    @BeforeEach
    void setUp() {
        returnOwner = getOwner();
    }

    @Test
    void findAll() {
        Owner newOwner = getOwner();
        Owner newOwner2 = getOwner();
        Set<Owner> returnOwnerSet = new HashSet<>();
        returnOwnerSet.add(newOwner);
        returnOwnerSet.add(newOwner2);

        when(ownerRepository.findAll()).thenReturn(returnOwnerSet);

        Set<Owner> owners = ownerService.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
        }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = ownerService.findById(ID);

        assertNotNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = getOwner();

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = ownerService.save(ownerToSave);

        assertNotNull(savedOwner);

        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        ownerService.delete(returnOwner);

        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerService.deleteById(ID);

        verify(ownerRepository).deleteById(any());
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner smith = ownerService.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, smith.getLastName());

        verify(ownerRepository).findByLastName(any());
    }
}