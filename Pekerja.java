class Pekerja {
    private String id;
    private String nama;
    private String tugasHarian;
    private String kontak;

    public Pekerja(String id, String nama, String tugasHarian, String kontak) {
        this.id = id;
        this.nama = nama;
        this.tugasHarian = tugasHarian;
        this.kontak = kontak;
    }

    public String getId() { return id; }
    public String getNama() { return nama; }
    public String getTugasHarian() { return tugasHarian; }
    public String getKontak() { return kontak; }
}
