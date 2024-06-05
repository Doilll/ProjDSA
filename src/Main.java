
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {

    static String pwAdmin = "martabakemak123";
    static String pwOwner = "martabakasik123";

    public static void displayAllFoodNames(DoubleLinkedList<Makanan> menu) {
        Node<Makanan> current = menu.getHead();
        int n = 1;
        while (current != null) {
            Makanan makanan = current.getData();
            System.out.println(n + ". " + makanan.getNama()); // Assuming getNama() returns the name of the food
            n += 1; // item
            current = current.getNext();
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList<Transaksi> trList = new DoubleLinkedList<>();
        double kodeTr = 001;
        Makanan martabak1 = new Makanan("martabak coklat", 10000);
        Makanan martabak2 = new Makanan("martabak keju", 12000);
        Makanan martabak3 = new Makanan("martabak keju & coklat", 15000);
        Makanan martabak4 = new Makanan("martabak telor", 11000);
        Makanan minum = new Makanan("esteh", 5000);
        DoubleLinkedList<Makanan> menu = new DoubleLinkedList<>();
        menu.insertAtHead(martabak1);
        menu.insertAtTail(martabak2);
        menu.insertAtTail(martabak3);
        menu.insertAtTail(martabak4);
        menu.insertAtTail(minum);
        Scanner s = new Scanner(System.in);
        int inp = 0;
        do {
            System.out.println("Menu Aplikasi");
            System.out.println("1. Pembeli\n2. Member");
            System.out.println("3. Admin\n4. Pemilik");
            System.out.print("Input pilihan: ");
            inp = s.nextInt();
            switch (inp) {
                case 1:
                    System.out.print("Input nama: ");
                    String namaPembeli = s.nextLine();
                    int inp2 = 0;
                    int jum = 0;
                    Makanan pesanan = null;
                    do {
                        System.out.println("");
                        System.out.println("Menu Pembeli");
                        System.out.println("1. Tambah\n2. Hapus");
                        System.out.println("3. Lihat\n4. Selesai");
                        System.out.print("Input Pilihan: ");
                        inp2 = s.nextInt();
                        switch (inp2) {
                            case 1:
                                System.out.println("Menu pilihan");
                                displayAllFoodNames(menu);
                                System.out.print("Input pilihan: ");
                                int inpMenu = s.nextInt();
                                Node<Makanan> current = menu.getHead();
                                int n = 1;
                                boolean k = false;
                                while (current != null) {
                                    if (n == inpMenu) {
                                        pesanan = current.getData();
                                        k = true;
                                    }
                                    n += 1;
                                    current = current.getNext();
                                }
                                if (k) {
                                    System.out.println("Anda memesan " + pesanan.getNama());
                                    System.out.print("Input jumlah: ");
                                    jum = s.nextInt();
                                } else {
                                    System.out.println("Pilihan tidak valid");
                                }
                                break;
                            case 2:
                                System.out.print("Yakin ingin menghapus pesanan?");
                                System.out.print("1. Ya\n2. Tidak: ");
                                int makeSure = s.nextInt();
                                if (makeSure == 1) {
                                    pesanan = null;
                                    System.out.println("Berhasil dihapus");
                                } else {
                                    System.out.println("Batal menghapus");
                                }
                                break;
                            case 3:
                                System.out.println("nama: " + namaPembeli);
                                System.out.println("kode transaksi: " + kodeTr);
                                System.out.println("Pesanan: " + pesanan.getNama());
                                System.out.println("Jumlah: " + jum);
                                break;
                            case 4:
                                System.out.println("Okayy");
                                break;
                        }
                    } while (inp2 == 4);
                    trList.insertAtTail(new Transaksi(kodeTr, namaPembeli, jum, false, pesanan));
                    System.out.println("Transaksi berhasil disimpan");
                    kodeTr = +001;
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("Menu Member");
                    System.out.println("1. Tambah\n2. Hapus");
                    System.out.println("3. Lihat\n4. Ubah Password");
                    System.out.println("5. Selesai");
                    System.out.print("Input Pilihan: ");
                    int inp3 = s.nextInt();
                    switch (inp3) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            System.out.println("Kembali ke menu utama");
                            break;
                    }
                    break;
                case 3:
                    while (true) {
                        System.out.println("input password");
                        String inp4 = s.nextLine();
                        if (inp4.equals(pwAdmin)) {
                            System.out.println("Input berhasil");
                            break;
                        } else {
                            System.out.println("Password salah silahkan coba lagi");
                            System.out.println("");
                        }
                    }
                    break;
                case 4:
                    while (true) {
                        System.out.println("input password");
                        String inp4 = s.nextLine();
                        if (inp4.equals(pwOwner)) {
                            System.out.println("Input berhasil");
                            break;
                        } else {
                            System.out.println("Password salah silahkan coba lagi");
                            System.out.println("");
                        }
                    }
                    System.out.println("");
                    break;
                case 5:
                    System.out.println("Aplikasi berhenti");
                    break;
                default:
                    System.out.println("Input tidak valid");

            }
        } while (inp != 5);
    }
}