package models.dto.create;

public class CreateNotat {
    public int nxenesiId;
    public int lendaId;
    public int mesuesiId;
    public int drejtimiId;
    public int klasaId;
    public int paraleljaId;
    public int periudhaId;
    public int notaPare;
    public int notaDyte;

    public CreateNotat(int nxenesiId, int lendaId, int mesuesiId, int drejtimiId, int klasaId, int paraleljaId,int periudhaId, int notaPare, int notaDyte) {
        this.nxenesiId = nxenesiId;
        this.lendaId = lendaId;
        this.mesuesiId = mesuesiId;
        this.drejtimiId = drejtimiId;
        this.klasaId = klasaId;
        this.paraleljaId = paraleljaId;
        this.periudhaId = periudhaId;
        this.notaPare = notaPare;
        this.notaDyte = notaDyte;
    }
}
