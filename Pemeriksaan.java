public interface Pemeriksaan {
    void lakukanPemeriksaan(String status, String diagnosa, String tanggal);
    String getDiagnosa();
    String getStatus();
    String getTanggal();
}
