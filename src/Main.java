
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

    static int piutang = 0;
    static int pendapatan = 0;

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
                    Scanner s1 = new Scanner(System.in);
                    System.out.print("Input nama: ");
                    String namaPembeli = s1.nextLine();
                    int inp2 = 0;
                    int jum = 0;
                    Makanan pesanan = null;
                    do {
                        System.out.println("");
                        System.out.println("Menu Pembeli");
                        System.out.println("1. Tambah\n2. Hapus");
                        System.out.println("3. Lihat\n4. Selesai");
                        System.out.print("Input Pilihan: ");
                        inp2 = s1.nextInt();
                        switch (inp2) {
                            case 1:
                                System.out.println("Menu pilihan");
                                displayAllFoodNames(menu);
                                System.out.print("Input pilihan: ");
                                int inpMenu = s1.nextInt();
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
                                    jum = s1.nextInt();
                                } else {
                                    System.out.println("Pilihan tidak valid");
                                }

                                break;
                            case 2:
                                System.out.print("Yakin ingin menghapus pesanan?");
                                System.out.print("1. Ya\n2. Tidak: ");
                                int makeSure = s1.nextInt();
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
                                try {
                                    System.out.println("Pesanan: " + pesanan.getNama());
                                    System.out.println("Harga: " + pesanan.getHarga());
                                    System.out.println("Jumlah: " + jum);
                                    System.out.println("Total: " + pesanan.getHarga() * jum);
                                } catch (Exception e) {
                                    System.out.println("Anda belum memesan makanan");
                                }
                                break;
                            case 4:
                                piutang += pesanan.getHarga() * jum;
                                System.out.println("Okayy");
                                break;
                        }
                    } while (inp2 == 4);
                    trList.insertAtTail(new Transaksi(kodeTr, namaPembeli, jum, false, pesanan));
                    Node<Transaksi> currentTr = trList.getTail();
                    Transaksi tail = currentTr.getData();
                    tail.setTotalHarga();
                    System.out.println("Transaksi berhasil disimpan");
                    kodeTr = +001;
                    break;
                case 2:
                    Scanner s2 = new Scanner(System.in);
                    System.out.println("silahkan buat member anda");
                    System.out.print("Input nama: ");
                    String namaMember = s2.nextLine();
                    int juml = 0;
                    Makanan pesananMem = null;
                    int inp3 = 0;
                    System.out.print("Input password baru: ");
                    String pass = s2.nextLine();
                    do {
                        System.out.println("");
                        System.out.println("Menu Member");
                        System.out.println("1. Tambah\n2. Hapus");
                        System.out.println("3. Lihat\n4. Ubah Password");
                        System.out.println("5. Selesai");
                        System.out.print("Input Pilihan: ");
                        inp3 = s2.nextInt();
                        switch (inp3) {
                            case 1:
                                System.out.println("Menu pilihan");
                                displayAllFoodNames(menu);
                                System.out.print("Input pilihan: ");
                                int inpMenu = s2.nextInt();
                                Node<Makanan> currentM = menu.getHead();
                                int n = 1;
                                boolean k = false;
                                while (currentM != null) {
                                    if (n == inpMenu) {
                                        pesanan = currentM.getData();
                                        k = true;
                                    }
                                    n += 1;
                                    currentM = currentM.getNext();
                                }
                                if (k) {
                                    System.out.println("Anda memesan " + pesananMem.getNama());
                                    System.out.print("Input jumlah: ");
                                    juml = s2.nextInt();
                                    System.out.println("");
                                } else {
                                    System.out.println("Pilihan tidak valid");
                                }
                                break;
                            case 2:
                                System.out.print("Yakin ingin menghapus pesanan?");
                                System.out.print("1. Ya\n2. Tidak: ");
                                int makeSure = s2.nextInt();
                                if (makeSure == 1) {
                                    pesanan = null;
                                    System.out.println("Berhasil dihapus");
                                } else {
                                    System.out.println("Batal menghapus");
                                }
                                break;
                            case 3:
                                System.out.println("nama: " + namaMember);
                                System.out.println("kode transaksi: " + kodeTr);
                                try {
                                    System.out.println("Pesanan: " + pesananMem.getNama());
                                    System.out.println("Harga: " + pesananMem.getHarga());
                                    System.out.println("Jumlah: " + juml);
                                    System.out.println("Total: " + pesananMem.getHarga() * juml);
                                } catch (Exception e) {
                                    System.out.println("Anda belum memesan makanan");
                                }
                                break;
                            case 4:
                                System.out.print("Silahkan ubah password anda: ");
                                pass = s2.nextLine();
                                System.out.println("Pw diubah");
                                break;
                            case 5:
                                piutang += pesananMem.getHarga() * juml;
                                System.out.println("selesai");
                                break;
                        }
                    } while (inp3 != 5);
                    trList.insertAtTail(new MemberTransaksi(kodeTr, namaMember, juml, false, pass, pesananMem));
                    Node<Transaksi> currentTrm = trList.getTail();
                    Transaksi tailM = currentTrm.getData();
                    tailM.setTotalHarga();
                    System.out.println("Transaksi berhasil disimpan");
                    kodeTr = +001;
                    break;
                case 3:
                    Scanner s3 = new Scanner(System.in);
                    while (true) {
                        System.out.println("input password");
                        String inp4 = s3.nextLine();
                        if (inp4.equals(pwAdmin)) {
                            System.out.println("Input berhasil");
                            break;
                        } else {
                            System.out.println("Password salah silahkan coba lagi");
                            System.out.println("");
                        }
                    }
                    System.out.println("Daftar pelanggan");
                    for (Node<Transaksi> current = trList.getHead(); current != null; current = current.getNext()) {
                        current.data.tampilkanData();
                    }
                    Node<Transaksi> proses = null;
                    for (Node<Transaksi> current = trList.getHead(); current != null; current = current.getNext()) {
                        if (current.data.isDone == false) {
                            proses = current;
                            break;
                        }
                    }
                    int p = 0;
                    do {
                        System.out.println("Proses transaksi");
                        System.out.println("1. konfirmasi transaksi/n 2. keluar");
                        p = s3.nextInt();
                        if (p == 1) {
                            if (proses == null) {
                                proses.data.setDone(true);
                                pendapatan += proses.getData().getTotalHarga();
                                piutang -= proses.getData().getTotalHarga();
                                System.out.println(
                                        "pesanan dengan nama " + proses.getData().getNama() + "berhasil di proses");
                                proses = proses.getNext();
                            } else {
                                System.out.println("Semua pesanan sudah dikonfirmasi");
                            }
                        } else if (p == 2) {
                            System.out.println("Pemrosesan terhenti");
                            System.out.println("Keluar dari menu admin");
                            break;
                        } else {
                            System.out.println("Input tidak valid");
                        }
                    } while (p != 2);
                    break;
                case 4:
                    Scanner s4 = new Scanner(System.in);
                    while (true) {
                        System.out.println("input password");
                        String inp4 = s4.nextLine();
                        if (inp4.equals(pwOwner)) {
                            System.out.println("Input berhasil");
                            break;
                        } else {
                            System.out.println("Password salah silahkan coba lagi");
                            System.out.println("");
                        }
                    }
                    int pilihOwner = 0;
                    do {
                        System.out.println("Menu owner");
                        System.out
                                .println("1. Ubah harga barang\n2. Lihat laporan penjualan\n3. Keluar dari menu admin");
                        pilihOwner = s4.nextInt();
                        if (pilihOwner == 1) {
                            System.out.println("Input nama barang yang ingin diubah: ");
                            String namaBarang = s4.next();
                            Makanan ubahHarga = null;
                            boolean ketemuMenu = false;
                            for (Node<Makanan> currentMakanan = menu.getHead(); currentMakanan != null; currentMakanan
                                    .getNext()) {
                                if (currentMakanan.getData().getNama().equals(namaBarang)) {
                                    ubahHarga = currentMakanan.getData();
                                    ketemuMenu = true;
                                    break;
                                }
                            }
                            if (ketemuMenu) {
                                System.out.println("Input harga baru: ");
                                int hargaBaru = s4.nextInt();
                                ubahHarga.setHarga(hargaBaru);
                                System.out.println("Harga berhasil diubah");
                                System.out.println("");
                            } else {
                                System.out.println("Barang yang anda cari tidak ada");
                            }
                        } else if (pilihOwner == 2) {
                            System.out.println("Laporan penjualan yang belum di proses: " + piutang);
                            System.out.println("Laporan penjualan yang sudah diproses: " + pendapatan);
                        } else {
                            System.out.println("Input tidak valid");
                        }
                    } while (pilihOwner != 3);
                    System.out.println("Keluar dari menu Owner");
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