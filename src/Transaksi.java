public class Transaksi {

    private String nama;
    private double kodeTr;
    private int jumlah;
    private boolean isDone;
    private Makanan makanan;

    Transaksi(double kodeTr, String nama, int jumlah, boolean isDone, Makanan makanan) {
        this.kodeTr = kodeTr;
        this.nama = nama;
        this.jumlah = jumlah;
        this.isDone = isDone;
        this.makanan = makanan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setKodeTr(double kodeTr) {
        this.kodeTr = kodeTr;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public String getNama() {
        return nama;
    }

    public double getKodeTr() {
        return kodeTr;
    }

    public int getJumlah() {
        return jumlah;
    }

    public Makanan getMakanan() {
        return makanan;
    }

}
