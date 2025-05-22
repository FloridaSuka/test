package services;

import models.dto.create.CreateKlasa;
import repositories.KlasaRepository;

public class KlasaService {
    private final KlasaRepository klasaRepository = new KlasaRepository();

    public boolean shtoKlasa(CreateKlasa klasa) {
        return klasaRepository.shtoKlasa(klasa);
    }


    public int lookupId(String table, String column, String value) {
        return klasaRepository.lookupId(table, column, value);
    }
}
