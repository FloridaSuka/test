package models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Mungesa {
    private int id;
    private int studentId;
    private int lendaId;
    private int periodaId;
    private Date dataMungeses;
    private String arsyeja;

    public Mungesa(int id, int studentId, int lendaId, int periodaId, Date dataMungeses, String arsyeja) {
        this.id = id;
        this.studentId = studentId;
        this.lendaId = lendaId;
        this.periodaId = periodaId;
        this.dataMungeses = dataMungeses;
        this.arsyeja = arsyeja;
    }

    public Mungesa(int studentId, int lendaId, int periodaId, Date dataMungeses, String arsyeja) {
        this.studentId = studentId;
        this.lendaId = lendaId;
        this.periodaId = periodaId;
        this.dataMungeses = dataMungeses;
        this.arsyeja = arsyeja;
    }

    public static Mungesa fromResultSet(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        int studentId = result.getInt("student_id");
        int lendaId = result.getInt("lenda_id");
        int periodaId = result.getInt("perioda_id");
        Date dataMungeses = result.getDate("data_mungeses");
        String arsyeja = result.getString("arsyeja");

        return new Mungesa(id, studentId, lendaId, periodaId, dataMungeses, arsyeja);
    }

    public int getId() {
        return id;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getLendaId() {
        return lendaId;
    }

    public int getPeriodaId() {
        return periodaId;
    }

    public Date getDataMungeses() {
        return dataMungeses;
    }

    public String getArsyeja() {
        return arsyeja;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setLendaId(int lendaId) {
        this.lendaId = lendaId;
    }

    public void setPeriodaId(int periodaId) {
        this.periodaId = periodaId;
    }

    public void setDataMungeses(Date dataMungeses) {
        this.dataMungeses = dataMungeses;
    }

    public void setArsyeja(String arsyeja) {
        this.arsyeja = arsyeja;
    }

    @Override
    public String toString() {
        return "Mungesa {" +
                "ID = " + id +
                ", Student ID = " + studentId +
                ", Lenda ID = " + lendaId +
                ", Perioda ID = " + periodaId +
                ", Data e Mungesës = " + dataMungeses +
                ", Arsyeja = '" + arsyeja + '\'' +
                '}';
    }

    public void printERDFormat() {
        System.out.println("Tabela: Mungesa");
        System.out.println("PK → id: " + id);
        System.out.println("FK → studentId (Nxenesit): " + studentId);
        System.out.println("FK → lendaId (Lenda): " + lendaId);
        System.out.println("FK → periodaId (Perioda): " + periodaId);
        System.out.println("Data Mungesës: " + dataMungeses);
        System.out.println("Arsyeja: " + arsyeja);
    }

    public String toInsertSQL() {
        return "INSERT INTO Mungesa (student_id, lenda_id, perioda_id, data_mungeses, arsyeja) VALUES (" +
                studentId + ", " + lendaId + ", " + periodaId + ", '" + dataMungeses + "', '" + arsyeja + "');";
    }

    public String toNormalizedRecord() {
        return "[Mungesa: id=" + id + ", studentId=" + studentId + "] → " +
                "(Lenda#" + lendaId + ", Perioda#" + periodaId + ", data=" + dataMungeses + ", arsyeja=" + arsyeja + ")";
    }

}
