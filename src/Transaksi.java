public class Transaksi {

    private String nama;
    private double kodeTr;
    private int jumlah;
    protected boolean isDone;
    private Makanan makanan;
    private int totalHarga;

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

    public void setTotalHarga() {
        int total = this.jumlah * this.makanan.getHarga();
        this.totalHarga = total;
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

    public int getTotalHarga() {
        return totalHarga;
    }

    public void tampilkanData() {
        System.out.println("Nama: " + nama);
        System.out.println("Kode transaksi: " + kodeTr);
        System.out.println("Pesanan: " + makanan.getNama());
        System.out.println("Jumlah: " + jumlah);
        System.out.println("Harga yang harus dibayar: " + totalHarga);
        if (isDone) {
            System.out.println("pembayaran: sudah dibayar");
        } else {
            System.out.println("Belum dibayar");
        }
    }

}
