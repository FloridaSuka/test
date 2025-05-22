package services;

import models.dto.create.CreateNxenesit;
import models.dto.update.UpdateNxenesit;
import repositories.NxenesitRepository;

public class NxenesitService {
    private final NxenesitRepository repo = new NxenesitRepository();

    public boolean shto(CreateNxenesit nx) {
        return repo.shtoNxenes(nx);
    }

    public boolean fshij(int id) {
        return repo.fshijNxenes(id);
    }

    public boolean perditeso(UpdateNxenesit nx) {
        return repo.perditesoNxenes(nx);
    }

    public int getAdresaId(String rruga) {
        return repo.lookupAdresaId(rruga);
    }
}