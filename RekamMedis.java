import java.util.ArrayList;

class RekamMedis {
    private ArrayList<String> riwayatPenyakit;
    private ArrayList<String> riwayatPengobatan;
    
    public RekamMedis() {
        this.riwayatPenyakit = new ArrayList<>();
        this.riwayatPengobatan = new ArrayList<>();
    }
    
    public void tambahRiwayatPenyakit(String penyakit) {
        riwayatPenyakit.add(penyakit);
    }
    
    public void tambahRiwayatPengobatan(String pengobatan) {
        riwayatPengobatan.add(pengobatan);
    }
}