<<<<<<< HEAD
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
=======
class Hewan {
    private String nama;
    private String jenis;
    private String statKes;
    private double umur;
    private double berat;

    public Hewan(String nama, String jenis, String statKes, double umur, double berat) {
        super(id);
        this.nama = nama;
        this.jenis = jenis;
        this.statKes = statKes;
        this.umur = umur;
        this.berat = berat;
    }

    @Override
    public displayInfo() {
        System.out.println("Hewan [Id : " + getId() + ", Nama : " + nama + ", Jenis : " + jenis + ", Status Kesehatan : " + statusKesehatan + ", Umur : " + umur + ", Berat : " + berat + "]");

    }

    @Override
    public void track() {
        System.out.println("Status Kesehatan dan Berat badan : " + nama);
    }

    

}
>>>>>>> 005634166884412b2764de6bd1bf7ae29555a2dc
