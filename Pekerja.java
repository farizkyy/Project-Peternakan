class Pekerja {
    private String id;
    private String nama;
    private String jabatan;
    private JadwalKerja jadwal;
    
    public Pekerja(String id, String nama, String jabatan) {
        this.id = id;
        this.nama = nama;
        this.jabatan = jabatan;
    }
    
    public void setJadwal(JadwalKerja jadwal) {
        this.jadwal = jadwal;
    }
}