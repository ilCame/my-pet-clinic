package guru.springframework.mypetclinic.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {
    private Long id; //preferiamo l'utilizzo di Long anziche` della primitiva perche` in questo caso puo` essere nullo

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
