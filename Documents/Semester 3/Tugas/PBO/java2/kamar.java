public class kamar {
    private int noRuang;
    private double harga;

    public kamar(int noRuang, double harga) {
        this.noRuang = noRuang;
        this.harga = harga;
    }

    public kamar(int noRuang) {
        this.noRuang = noRuang;
    }

    public int getNoRuang() {
        return noRuang;
    }

    public void setNoRuang(int noRuang) {
        this.noRuang = noRuang;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public void cetakData() {
        System.out.println("Kamar No : " + noRuang + ", dengan Harga : " + harga);
    }

}
