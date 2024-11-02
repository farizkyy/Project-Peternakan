public class tamu {
    private String nama;
    private String id;
    private String status;

    public tamu(String nama, String id, String status) {
        this.nama = nama;
        this.id = id;
        this.status = status;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void cetakData() {
        System.out.println("Tamu a.n : " + nama + ", id : " + id);
    }
    
}
