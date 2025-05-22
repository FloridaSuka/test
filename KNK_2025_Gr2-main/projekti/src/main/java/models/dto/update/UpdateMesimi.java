package models.dto.update;

public class UpdateMesimi {
    private int lendaId;
    private int profesoriId;
    private int klasaId;
    private int drejtimiId;

    public UpdateMesimi(int lendaId, int profesoriId, int klasaId, int drejtimiId) {
        this.lendaId = lendaId;
        this.profesoriId = profesoriId;
        this.klasaId = klasaId;
        this.drejtimiId = drejtimiId;
    }

    public int getLendaId() {
        return lendaId;
    }

    public int getProfesoriId() {
        return profesoriId;
    }

    public int getKlasaId() {
        return klasaId;
    }

    public int getDrejtimiId() {
        return drejtimiId;
    }
}

