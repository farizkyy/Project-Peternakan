public class LaporanProduksi extends Hewan {
    private String jenisProduk;
    private double jumlah;
    private String tanggal;

    public LaporanProduksi(String id, String jenis, int umur, double berat, String statusKesehatan, String jenisProduk, double jumlah, String tanggal) {
        super(id, jenis, umur, berat, statusKesehatan);
        this.jenisProduk = jenisProduk;
        this.jumlah = jumlah;
        this.tanggal = tanggal;
    }

    public String getJenisProduk() {
        return jenisProduk;
    }

    public void setJenisProduk(String jenisProduk) {
        this.jenisProduk = jenisProduk;
    }

    public double getJumlah() {
        return jumlah;
    }

    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    @Override
    public void displayInfo() {
        System.out.println("Jenis Produk: " + jenisProduk);
        System.out.println("Jumlah: " + jumlah);
        System.out.println("Tanggal Produksi: " + tanggal);
    }
}
