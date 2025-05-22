package models.dto.create;

import java.sql.Date;

public class CreateMungesa {
    public String emriNxenesi;
    public String emriLendes;
    public String emriPerioda;
    public Date data;
    public String arsyeja;

    public CreateMungesa(String emriNxenesi, String emriLendes, String emriPerioda, Date data, String arsyeja) {
        this.emriNxenesi = emriNxenesi;
        this.emriLendes = emriLendes;
        this.emriPerioda = emriPerioda;
        this.data = data;
        this.arsyeja = arsyeja;
    }
}