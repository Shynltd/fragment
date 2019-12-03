package vn.fptpolytechnic.assignment.model;

public class khoanthu {

    String khoanthu;
    int idthu;

    public khoanthu() {
    }

    public khoanthu(String khoanthu, int idthu) {
        this.khoanthu = khoanthu;
        this.idthu = idthu;
    }

    public String getKhoanthu() {
        return khoanthu;
    }

    public void setKhoanthu(String khoanthu) {
        this.khoanthu = khoanthu;
    }

    public int getIdthu() {
        return idthu;
    }

    public void setIdthu(int idthu) {
        this.idthu = idthu;
    }
}
