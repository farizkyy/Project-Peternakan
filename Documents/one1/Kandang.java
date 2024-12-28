class Kandang {
    private String idHewan;
    private int jumlah;
    private String lokasi;

    public Kandang(String idHewan, int jumlah, String lokasi) {
        this.idHewan = idHewan;
        this.jumlah = jumlah;
        this.lokasi = lokasi;
    }

    public String getIdHewan() {
        return idHewan;
    }

    public int getKapasitas() {
        return jumlah;
    }

    public String getLokasi() {
        return lokasi;
    }
}