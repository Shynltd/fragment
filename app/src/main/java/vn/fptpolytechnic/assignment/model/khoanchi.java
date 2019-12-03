package vn.fptpolytechnic.assignment.model;

public class khoanchi {

    String khoanchi;
    int idchi;

    public khoanchi() {
    }

    public khoanchi(String khoanchi, int idchi) {
        this.khoanchi = khoanchi;
        this.idchi = idchi;
    }

    public String getKhoanchi() {
        return khoanchi;
    }

    public void setKhoanchi(String khoanchi) {
        this.khoanchi = khoanchi;
    }

    public int getIdchi() {
        return idchi;
    }

    public void setIdchi(int idchi) {
        this.idchi = idchi;
    }
    
}
