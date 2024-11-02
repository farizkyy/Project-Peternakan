import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<reservasi> daftarReservasi = new ArrayList<>();
        hotel hotel = new hotel("Hotel Hello World","Jl.Array Dinamis");
        System.out.println("=== Hello World ===");
        hotel.cetakData();

        while (true) {
            System.out.println("\nPendaftaran Hotel Hello World");
            System.out.println("1. Reservasi");
            System.out.println("2. Info Daftar Tamu");
            System.out.println("Pilih(1/2/3) : ");
            int pilih = scanner.nextInt();
            scanner.nextLine();

            switch (pilih) {
                case 1 :
                System.out.println("Masukan nama : ");
                String nama = scanner.nextLine();
                System.out.println("Masukan id : ");
                String id = scanner.nextLine();
                tamu tamu = new tamu(nama, id, id);
                
                System.out.println("Jenis Kamar :");
                System.out.println("1. Kamar Standar");
                System.out.println("2. Kamar Suite");
                System.out.println("pilih");
                int jenisKamar = scanner.nextInt();
                kamar kamar = null;
                System.out.print("Masukkan nomor kamar: ");
                    int noKamar = scanner.nextInt();

                    if (jenisKamar == 1) {
                        kamar = new kamarStandar(noKamar);
                    } else if (jenisKamar == 2) {
                        kamar = new kamarSuite(noKamar);
                    } else {
                        System.out.println("Pilihan tidak valid.");
                        continue;
                    }
                
            System.out.println("Tanggal reservasi : ");
            String date = scanner.next();

            System.out.println("Berapa hari : ");
            int hari = scanner.nextInt();

            reservasi reservasi = new reservasi(tamu, kamar, date);
            daftarReservasi.add(reservasi);

            double totalBiaya = reservasi.totalBiaya(hari);
            System.out.println("Total " + hari + "hari : " + totalBiaya);
            System.out.println("Success");
            break;

            case 2 :
            System.out.println("Daftar Tamu");
            for (reservasi Reservasi : daftarReservasi) {
                Reservasi.cetakData();
                System.out.println();
            }
            break;

            case 3 :
            System.out.println("error");
            scanner.close();
            return;

            }
            

        }


    }
}
