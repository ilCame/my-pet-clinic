package guru.springframework.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {

    private Set<Speciality> speciality = new HashSet<>();

    public Set<Speciality> getSpecialty() {
        return speciality;
    }

    public void setSpecialty(Set<Speciality> speciality) {
        this.speciality = speciality;
    }
}
