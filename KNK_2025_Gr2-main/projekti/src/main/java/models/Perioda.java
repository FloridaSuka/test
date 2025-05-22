package models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Perioda {
    private int id;
    private String emri;
    private Date dataFillimit;
    private Date dataMbarimit;

    public Perioda(int id, String emri, Date dataFillimit, Date dataMbarimit) {
        this.id = id;
        this.emri = emri;
        this.dataFillimit = dataFillimit;
        this.dataMbarimit = dataMbarimit;
    }

    public Perioda(String emri, Date dataFillimit, Date dataMbarimit) {
        this.emri = emri;
        this.dataFillimit = dataFillimit;
        this.dataMbarimit = dataMbarimit;
    }

    public Perioda(int periodaId, String periodaEmri) {
    }

    public static Perioda fromResultSet(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String emri = result.getString("emri");
        Date dataFillimit = result.getDate("data_fillimit");
        Date dataMbarimit = result.getDate("data_mbarimit");

        return new Perioda(id, emri, dataFillimit, dataMbarimit);
    }

    public int getId() {
        return id;
    }

    public String getEmri() {
        return emri;
    }

    public Date getDataFillimit() {
        return dataFillimit;
    }

    public Date getDataMbarimit() {
        return dataMbarimit;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public void setDataFillimit(Date dataFillimit) {
        this.dataFillimit = dataFillimit;
    }

    public void setDataMbarimit(Date dataMbarimit) {
        this.dataMbarimit = dataMbarimit;
    }

    @Override
    public String toString() {
        return "Perioda {" +
                "ID = " + id +
                ", Emri = '" + emri + '\'' +
                ", Data Fillimit = " + dataFillimit +
                ", Data Mbarimit = " + dataMbarimit +
                '}';
    }

}
