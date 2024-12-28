class JadwalKerja {
    private String idJadwal;
    private String idPekerja;
    private String waktuKerja;

    public JadwalKerja(String idJadwal, String idPekerja, String waktuKerja) {
        this.idJadwal = idJadwal;
        this.idPekerja = idPekerja;
        this.waktuKerja = waktuKerja;
    }

    public String getIdJadwal() {
        return idJadwal;
    }

    public String getIdPekerja() {
        return idPekerja;
    }

    public String getWaktuKerja() {
        return waktuKerja;
    }
}