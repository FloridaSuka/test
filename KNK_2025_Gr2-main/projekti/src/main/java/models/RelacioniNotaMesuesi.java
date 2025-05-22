package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class RelacioniNotaMesuesi {
    private int id;
    private int notaId;
    private int mesuesId;
    private LocalDateTime dataVendosjes;
    private String koment;

    public RelacioniNotaMesuesi(int id, int notaId, int mesuesId, LocalDateTime dataVendosjes, String koment) {
        this.id = id;
        this.notaId = notaId;
        this.mesuesId = mesuesId;
        this.dataVendosjes = dataVendosjes;
        this.koment = koment;
    }

    public RelacioniNotaMesuesi(int notaId, int mesuesId, String koment) {
        this.notaId = notaId;
        this.mesuesId = mesuesId;
        this.dataVendosjes = LocalDateTime.now();
        this.koment = koment;
    }

    public static RelacioniNotaMesuesi fromResultSet(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        int notaId = result.getInt("nota_id");
        int mesuesId = result.getInt("mesues_id");
        Timestamp timestamp = result.getTimestamp("data_vendosjes");
        LocalDateTime dataVendosjes = timestamp != null ? timestamp.toLocalDateTime() : null;
        String koment = result.getString("koment");

        return new RelacioniNotaMesuesi(id, notaId, mesuesId, dataVendosjes, koment);
    }

    public int getId() {
        return id;
    }

    public int getNotaId() {
        return notaId;
    }

    public int getMesuesId() {
        return mesuesId;
    }

    public LocalDateTime getDataVendosjes() {
        return dataVendosjes;
    }

    public String getKoment() {
        return koment;
    }

    public void setNotaId(int notaId) {
        this.notaId = notaId;
    }

    public void setMesuesId(int mesuesId) {
        this.mesuesId = mesuesId;
    }

    public void setDataVendosjes(LocalDateTime dataVendosjes) {
        this.dataVendosjes = dataVendosjes;
    }

    public void setKoment(String koment) {
        this.koment = koment;
    }

    @Override
    public String toString() {
        return "RelacioniNotaMesuesi {" +
                "ID = " + id +
                ", Nota ID = " + notaId +
                ", Mesues ID = " + mesuesId +
                ", Data Vendosjes = " + dataVendosjes +
                ", Koment = '" + koment + '\'' +
                '}';
    }
}
