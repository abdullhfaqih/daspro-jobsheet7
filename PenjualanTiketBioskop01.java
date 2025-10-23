import java.util.Scanner;

public class PenjualanTiketBioskop01 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int totalTiketTerjual = 0;
    double totalPendapatan = 0;
    final int hargaTiket = 50000;

    String lanjut;

    do {
      int jumlahTiket;

      // Validasi input jumlah tiket
      do {
        System.out.print("Masukkan jumlah tiket yang dibeli: ");
        jumlahTiket = input.nextInt();

        if (jumlahTiket < 0) {
          System.out.println("Jumlah tiket tidak valid. Silakan masukkan ulang.");
        }
      } while (jumlahTiket < 0);

      // Hitung total harga dan diskon
      double totalHarga = jumlahTiket * hargaTiket;
      double diskon = 0;

      if (jumlahTiket > 10) {
        diskon = 0.15 * totalHarga;
      } else if (jumlahTiket > 4) {
        diskon = 0.10 * totalHarga;
      }

      double hargaSetelahDiskon = totalHarga - diskon;

      System.out.println("Total harga sebelum diskon: Rp " + totalHarga);
      System.out.println("Diskon: Rp " + diskon);
      System.out.println("Total yang harus dibayar: Rp " + hargaSetelahDiskon);
      System.out.println();

      // Update total harian
      totalTiketTerjual += jumlahTiket;
      totalPendapatan += hargaSetelahDiskon;

      // Tanya apakah ingin input lagi
      System.out.print("Apakah ada pelanggan lain? (ya/tidak): ");
      input.nextLine(); // konsumsi newline
      lanjut = input.nextLine();

    } while (lanjut.equalsIgnoreCase("ya"));

    // Tampilkan hasil akhir
    System.out.println("\n--- Rekap Penjualan Hari Ini ---");
    System.out.println("Total tiket terjual: " + totalTiketTerjual);
    System.out.println("Total pendapatan: Rp " + totalPendapatan);

    input.close();
  }
}