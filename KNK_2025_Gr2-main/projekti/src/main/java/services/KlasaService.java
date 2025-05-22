package services;

import models.Klasa;
import models.dto.create.CreateKlasa;
import repositories.KlasaRepository;

import java.util.List;

public class KlasaService {
    private final KlasaRepository klasaRepository = new KlasaRepository();

    public boolean shtoKlasa(CreateKlasa klasa) {
        return klasaRepository.shtoKlasa(klasa);
    }


    public int lookupId(String table, String column, String value) {
        return klasaRepository.lookupId(table, column, value);
    }
    public List<Klasa> gjejTeGjitha() {
        return klasaRepository.gjejTeGjitha();
    }

}
