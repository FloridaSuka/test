package services;

import models.Lenda;
import java.util.ArrayList;
import java.util.List;

public class LendaService {
    private final List<Lenda> lendet = new ArrayList<>();

    public void shtoLende(Lenda lenda) {
        lendet.add(lenda);
    }

    public List<Lenda> merrTeGjitha() {
        return lendet;
    }

    public Lenda gjejSipasId(int id) {
        for (Lenda l : lendet) {
            if (l.getIdLenda() == id) {
                return l;
            }
        }
        return null;
    }

    public boolean fshijLende(int id) {
        return lendet.removeIf(l -> l.getIdLenda() == id);
    }
}
