class Pakan {
    private String jenisPakan;
    private double stok;
    private String supplier;
    
    public Pakan(String jenisPakan, double stok, String supplier) {
        this.jenisPakan = jenisPakan;
        this.stok = stok;
        this.supplier = supplier;
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