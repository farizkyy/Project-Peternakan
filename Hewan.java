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