public abstract class Mahlukhidup {
    protected String id;
    protected String jenis;
    protected int umur;
    protected double berat;
    protected String statusKesehatan;
    protected String diagnosa;
    protected String tanggalPemeriksaan;

    public Mahlukhidup(String id, String jenis, int umur, double berat, String statusKesehatan) {
        this.id = id;
        this.jenis = jenis;
        this.umur = umur;
        this.berat = berat;
        this.statusKesehatan = statusKesehatan;
        this.diagnosa = "Sehat";
        this.tanggalPemeriksaan = "Belum Diperiksa";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public double getBerat() {
        return berat;
    }

    public void setBerat(double berat) {
        this.berat = berat;
    }

    public String getStatusKesehatan() {
        return statusKesehatan;
    }

    public void setStatusKesehatan(String statusKesehatan) {
        this.statusKesehatan = statusKesehatan;
    }

    public String getDiagnosa() {
        return diagnosa;
    }

    public void setDiagnosa(String diagnosa) {
        this.diagnosa = diagnosa;
    }

    public String getTanggalPemeriksaan() {
        return tanggalPemeriksaan;
    }

    public void setTanggalPemeriksaan(String tanggalPemeriksaan) {
        this.tanggalPemeriksaan = tanggalPemeriksaan;
    }

    public abstract void displayInfo();
}
