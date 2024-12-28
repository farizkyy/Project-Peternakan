class Pakan {
    private String jenisPakan;
    private double stok;
    private String tanggal;
    private String idSupplier;
    
    public Pakan(String jenisPakan, double stok, String Tanggal, String idSupplier) {
        this.jenisPakan = jenisPakan;
        this.tanggal = Tanggal;
        this.stok = stok;
        this.idSupplier = idSupplier;
    }
    
    public void tambahStok(double jumlah) {
        this.stok += jumlah;
    }
    
    public void kurangiStok(double jumlah) {
        if(this.stok >= jumlah) {
            this.stok -= jumlah;
        }
    }
}