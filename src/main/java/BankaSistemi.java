import java.util.Scanner;

public class BankaSistemi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Banka banka = new Banka();

        while (true) {
            System.out.println("1. Giriş Yap");
            System.out.println("2. Kullanıcı Ekle");
            System.out.println("0. Çıkış");
            System.out.print("Seçenek: ");
            int secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    System.out.print("T.C. Kimlik Numaranızı Giriniz: ");
                    long tcKimlik = scanner.nextLong();
                    System.out.print("Şifrenizi Giriniz: ");
                    String sifre = scanner.next();

                    Kullanici girisYapanKullanici = banka.girisYap(tcKimlik, sifre);

                    if (girisYapanKullanici != null) {
                        kullaniciMenu(girisYapanKullanici, banka, scanner);
                    } else {
                        System.out.println("Giriş Başarısız. Lütfen T.C. Kimlik Numaranız ve Şifrenizi Kontrol Ediniz.");
                    }
                    break;
                case 2:
                    System.out.print("Adınızı Giriniz: ");
                    String ad = scanner.next();
                    System.out.print("Soyadınızı Giriniz: ");
                    String soyad = scanner.next();
                    System.out.print("T.C. Kimlik Numaranızı Giriniz: ");
                    long yeniTcKimlik = scanner.nextLong();
                    System.out.print("Şifrenizi Giriniz: ");
                    String yeniSifre = scanner.next();

                    Kullanici yeniKullanici = new Kullanici(ad, soyad, yeniTcKimlik, yeniSifre);
                    banka.kullaniciEkle(yeniKullanici);
                    System.out.println("Kullanıcı Başarıyla Oluşturuldu.");
                    break;
                case 0:
                    System.out.println("Çıkış yapılıyor...");
                    System.exit(0);
                default:
                    System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
            }
        }
    }

    private static void kullaniciMenu(Kullanici kullanici, Banka banka, Scanner scanner) {
        while (true) {
            System.out.println("1. Para Transferi Yap");
            System.out.println("2. Kredi Ödemesi Yap");
            System.out.println("3. Kredi Kartı Ekstresi Öde");
            System.out.println("0. Çıkış");

            System.out.print("Seçenek: ");
            int secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    System.out.print("Hedef T.C. Kimlik Numarasını Giriniz: ");
                    long hedefTcKimlik = scanner.nextLong();
                    System.out.print("Transfer Edilecek Miktarı Giriniz: ");
                    double miktar = scanner.nextDouble();

                    boolean transferSonuc = banka.paraTransferiYap(kullanici.getTcKimlik(), hedefTcKimlik, miktar);
                    if (transferSonuc) {
                        System.out.println("Para Transferi Başarılı!");
                    } else {
                        System.out.println("Para Transferi Başarısız. Lütfen Bilgilerinizi Kontrol Ediniz.");
                    }
                    break;
                case 2:
                    System.out.print("Ödenecek Kredi Miktarını Giriniz: ");
                    double krediMiktari = scanner.nextDouble();

                    boolean krediOdemeSonuc = banka.krediOde(kullanici, krediMiktari);
                    if (krediOdemeSonuc) {
                        System.out.println("Kredi Ödemesi Başarılı!");
                    } else {
                        System.out.println("Kredi Ödemesi Başarısız. Lütfen Bilgilerinizi Kontrol Ediniz.");
                    }
                    break;
                case 3:
                    System.out.print("Ödenecek Kredi Kartı Ekstresi Miktarını Giriniz: ");
                    double ekstreMiktari = scanner.nextDouble();

                    boolean ekstreOdemeSonuc = banka.ekstreOde(kullanici, ekstreMiktari);
                    if (ekstreOdemeSonuc) {
                        System.out.println("Kredi Kartı Ekstresi Ödeme Başarılı!");
                    } else {
                        System.out.println("Kredi Kartı Ekstresi Ödeme Başarısız. Lütfen Bilgilerinizi Kontrol Ediniz.");
                    }
                    break;
                case 0:
                    System.out.println("Çıkış yapılıyor...");
                    System.exit(0);
                default:
                    System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
            }
        }
    }
}

