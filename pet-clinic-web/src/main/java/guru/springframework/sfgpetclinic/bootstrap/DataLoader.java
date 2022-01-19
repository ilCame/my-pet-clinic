package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.mypetclinic.services.OwnerService;
import guru.springframework.mypetclinic.services.VetService;
import guru.springframework.mypetclinic.services.map.OwnerMapService;
import guru.springframework.mypetclinic.services.map.VetMapService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(){
        ownerService = new OwnerMapService();
        vetService = new VetMapService();
    }
    @Override
    public void run(String... args) throws Exception {

    }
}
