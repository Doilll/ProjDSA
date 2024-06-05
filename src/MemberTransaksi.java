public class MemberTransaksi extends Transaksi {

    private int kodeMem;

    MemberTransaksi(double kodeTr, String nama, int jumlah, boolean isDone, int kodeMem, Makanan makanan) {
        super(kodeTr, nama, jumlah, isDone, makanan);
        this.kodeMem = kodeMem;
    }
}
