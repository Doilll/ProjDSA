public class MemberTransaksi extends Transaksi {

    private String kodeMem;

    public MemberTransaksi(double kodeTr, String nama, int jumlah, boolean isDone, String kodeMem, Makanan makanan) {
        super(kodeTr, nama, jumlah, isDone, makanan);
        this.kodeMem = kodeMem;
    }

    @Override
    public void tampilkanData() {
        System.out.println("password Transaksi: " + this.kodeMem);
        System.out.println("Kode transaksi: " + super.getKodeTr());
        System.out.println("Pesanan: " + super.getMakanan().getNama());
        System.out.println("Jumlah: " + super.getJumlah());
        System.out.println("Harga yang harus dibayar: " + super.getTotalHarga());
        if (super.isDone) {
            System.out.println("pembayaran: sudah dibayar");
        } else {
            System.out.println("Belum dibayar");
        }
    }
}
