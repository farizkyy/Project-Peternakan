class Supplier {
    private String idSupplier;
    private String jenisPakan;
    private String noHp;

    public Supplier(String idSupplier, String jenisPakan, String noHp) {
        this.idSupplier = idSupplier;
        this.jenisPakan = jenisPakan;
        this.noHp = noHp;
    }

    public String getIdSupplier() {
        return idSupplier;
    }

    public String getJenisPakan() {
        return jenisPakan;
    }

    public String getNoHp() {
        return noHp;
    }
}