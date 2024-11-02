public class reservasi {
    private tamu tamu;
    private kamar kamar;
    private String date;
    private boolean status;

    public reservasi(tamu tamu, kamar kamar, String date) {
        this.tamu = tamu;
        this.kamar = kamar;
        this.date = date;
    }

    public tamu getTamu() {
        return tamu;
    }

    public void setTamu(tamu tamu) {
        this.tamu = tamu;
    }

    public kamar getKamar() {
        return kamar;
    }

    public void setKamar(kamar kamar) {
        this.kamar = kamar;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double totalBiaya(int hari) {
        return kamar.getHarga() * hari;
    }

    public void cetakStatus() {
        System.out.println("Status Reservasi : " + (status ? "valid" : "batal"));
    }

    public void cetakData() {
        System.out.println("Reservasi a.n : " + tamu.getNama());
        System.out.println("Kamar " + kamar.getNoRuang() + " Date : " + date);
    }
}
