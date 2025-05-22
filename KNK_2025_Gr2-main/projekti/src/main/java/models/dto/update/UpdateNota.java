package models.dto.update;

public class UpdateNota {

    private int id;
    private Integer nxenesiId;
    private Integer lendaId;
    private Integer punonjesiId;
    private Integer drejtimiId;
    private Integer klasaId;
    private Integer paraleljaId;
    private Integer notaPare;
    private Integer notaDyte;

    public int getId()                           { return id; }
    public void setId(int id)                    { this.id = id; }

    public Integer getNxenesiId()                { return nxenesiId; }
    public void setNxenesiId(Integer v)          { this.nxenesiId = v; }

    public Integer getLendaId()                  { return lendaId; }
    public void setLendaId(Integer v)            { this.lendaId = v; }

    public Integer getPunonjesiId()              { return punonjesiId; }
    public void setPunonjesiId(Integer v)        { this.punonjesiId = v; }

    public Integer getDrejtimiId()               { return drejtimiId; }
    public void setDrejtimiId(Integer v)         { this.drejtimiId = v; }

    public Integer getKlasaId()                  { return klasaId; }
    public void setKlasaId(Integer v)            { this.klasaId = v; }

    public Integer getParaleljaId()              { return paraleljaId; }
    public void setParaleljaId(Integer v)        { this.paraleljaId = v; }

    public Integer getNotaPare()                 { return notaPare; }
    public void setNotaPare(Integer v)           { this.notaPare = v; }

    public Integer getNotaDyte()                 { return notaDyte; }
    public void setNotaDyte(Integer v)           { this.notaDyte = v; }

    @Override
    public String toString() {
        return "UpdateNota{id=" + id +
                ", notaPare=" + notaPare +
                ", notaDyte=" + notaDyte + '}';
    }
}

