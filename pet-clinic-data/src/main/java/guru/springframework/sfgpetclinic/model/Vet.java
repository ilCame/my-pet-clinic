package guru.springframework.sfgpetclinic.model;

import java.util.Set;

public class Vet extends Person {

    private Set<Speciality> speciality;

    public Set<Speciality> getSpecialty() {
        return speciality;
    }

    public void setSpecialty(Set<Speciality> speciality) {
        this.speciality = speciality;
    }
}
