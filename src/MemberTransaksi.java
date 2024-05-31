public class MemberTransaksi extends Transaksi {

    private int kodeMem;

    MemberTransaksi(double kodeTr,String nama,int jumlah,boolean isDone,int kodeMem) {
        super(kodeTr,nama,jumlah,isDone);
        this.kodeMem = kodeMem;
    }
}
