public class Hewan extends Mahlukhidup implements Pemeriksaan {
    public Hewan(String id, String jenis, int umur, double berat, String statusKesehatan) {
        super(id, jenis, umur, berat, statusKesehatan);
    }

    @Override
    public void displayInfo() {
        System.out.println("ID Hewan: " + getId());
        System.out.println("Jenis Hewan: " + getJenis());
        System.out.println("Umur Hewan: " + getUmur() + " tahun");
        System.out.println("Berat Hewan: " + getBerat() + " kg");
        System.out.println("Status Kesehatan: " + getStatusKesehatan());
    }

    @Override
    public void lakukanPemeriksaan(String status, String diagnosa, String tanggal) {
        setStatusKesehatan(status);
        setDiagnosa(diagnosa);
        setTanggalPemeriksaan(tanggal);
    }

    @Override
    public String getDiagnosa() {
        return super.getDiagnosa();
    }

    @Override
    public String getStatus() {
        return super.getStatusKesehatan();
    }

    @Override
    public String getTanggal() {
        return super.getTanggalPemeriksaan();
    }
}
