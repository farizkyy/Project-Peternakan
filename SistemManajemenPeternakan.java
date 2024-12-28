import java.util.ArrayList;
import java.util.List;

public class SistemManajemenPeternakan {
    private List<Hewan> hewanList = new ArrayList<>();
    private List<Pakan> pakanList = new ArrayList<>();
    private List<Pekerja> pekerjaList = new ArrayList<>();
    private List<LaporanProduksi> produksiList = new ArrayList<>();
    private List<Pemeriksaan> pemeriksaanList = new ArrayList<>();
    private List<Supplier> supplierList = new ArrayList<>();
    private List<JadwalKerja> jadwalList = new ArrayList<>();
    private List<Kandang> kandangList = new ArrayList<>();

    public void tambahHewan(Hewan hewan) {
        hewanList.add(hewan);
    }

    public void tambahPakan(Pakan pakan) {
        pakanList.add(pakan);
    }

    public void tambahPekerja(Pekerja pekerja) {
        pekerjaList.add(pekerja);
    }

    public void catatProduksi(LaporanProduksi produksi) {
        produksiList.add(produksi);
    }

    public void tambahPemeriksaan(Pemeriksaan pemeriksaan) {
        pemeriksaanList.add(pemeriksaan);
    }

    public void tambahSupplier(Supplier supplier) {
        supplierList.add(supplier);
    }

    public void tambahJadwal(JadwalKerja jadwal) {
        jadwalList.add(jadwal);
    }

    public void tambahKandang(Kandang kandang) {
        kandangList.add(kandang);
    }

    public List<Hewan> getHewanList() {
        return hewanList;
    }

    public List<Pakan> getPakanList() {
        return pakanList;
    }

    public List<Pekerja> getPekerjaList() {
        return pekerjaList;
    }

    public List<LaporanProduksi> getProduksiList() {
        return produksiList;
    }

    public List<Pemeriksaan> getPemeriksaanList() {
        return pemeriksaanList;
    }

    public List<Supplier> getSupplierList() {
        return supplierList;
    }

    public List<JadwalKerja> getJadwalList() {
        return jadwalList;
    }

    public List<Kandang> getKandangList() {
        return kandangList;
    }

    public Hewan cariHewan(String id) {
        for (Hewan hewan : hewanList) {
            if (hewan.getId().equals(id)) {
                return hewan;
            }
        }
        return null;
    }

    public void catatPemeriksaan(String idHewan, String status, String diagnosa, String tanggal) {
        Hewan hewan = cariHewan(idHewan);
        if (hewan != null) {
            hewan.lakukanPemeriksaan(status, diagnosa, tanggal);
            System.out.println("Pemeriksaan berhasil dicatat untuk Hewan dengan ID " + idHewan);
        } else {
            System.out.println("Hewan dengan ID " + idHewan + " tidak ditemukan!");
        }
    }


    public LaporanProduksi cariProduksi(String id) {
        for (LaporanProduksi produksi : produksiList) {
            if (produksi.getId().equals(id)) {
                return produksi;
            }
        }
        return null;
    }

    public void catatProduksi(String idHewan, String jenisProduk, double jumlah, String tanggal) {
        for (Hewan hewan : hewanList) {
            if (hewan.getId().equals(idHewan)) {
                LaporanProduksi laporan = new LaporanProduksi(
                    hewan.getId(),
                    hewan.getJenis(),
                    hewan.getUmur(),
                    hewan.getBerat(),
                    hewan.getStatusKesehatan(),
                    jenisProduk,
                    jumlah,
                    tanggal
                );
                produksiList.add(laporan);
                return;
            }
        }
        System.out.println("Hewan dengan ID " + idHewan + " tidak ditemukan!");
    }
    

    public Pekerja cariPekerja(String id) {
        for (Pekerja pekerja : pekerjaList) {
            if (pekerja.getId().equals(id)) {
                return pekerja;
            }
        }
        return null;
    }
}
