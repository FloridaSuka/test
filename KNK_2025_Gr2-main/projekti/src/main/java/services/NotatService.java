package services;

import models.Notat;
import models.dto.create.CreateNotat;
import repositories.NotatRepository;

import java.util.List;

public class NotatService {
    private final NotatRepository notatRepository = new NotatRepository();

    public boolean regjistroNota(CreateNotat nota) {
        return notatRepository.regjistroNota(nota);
    }
    public List<Notat> merrTeGjithaNotat() {
        return notatRepository.gjejTeGjithaNotat();
    }

}
