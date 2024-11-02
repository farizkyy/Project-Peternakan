class hotel {
    private String nama;
    private String lokasi;

    public hotel(String nama, String lokasi) {
        this.nama = nama;
        this.lokasi = lokasi;
    }

    public hotel(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void cetakData() {
        System.out.println("Hotel : " + nama + ", Lokasi : " + lokasi);
    }
}