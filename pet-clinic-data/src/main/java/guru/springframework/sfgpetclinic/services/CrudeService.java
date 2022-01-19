package guru.springframework.sfgpetclinic.services;

import java.util.Set;

public interface CrudeService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}
