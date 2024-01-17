import java.util.ArrayList;
import java.util.List;
class Banka {
    private List<Kullanici> kullaniciListesi;

    public Banka() {
        this.kullaniciListesi = new ArrayList<>();
    }

    // Getter ve Setter metotları

    public List<Kullanici> getKullaniciListesi() {
        return kullaniciListesi;
    }

    public void setKullaniciListesi(List<Kullanici> kullaniciListesi) {
        this.kullaniciListesi = kullaniciListesi;
    }

    // Diğer metodlar

    public Kullanici girisYap(long tcKimlik, String sifre) {
        for (Kullanici kullanici : kullaniciListesi) {
            if (kullanici.getTcKimlik() == tcKimlik && kullanici.getSifre().equals(sifre)) {
                return kullanici;
            }
        }
        return null; // Giriş başarısız
    }

    public void kullaniciEkle(Kullanici kullanici) {
        kullaniciListesi.add(kullanici);
    }

    public boolean paraTransferiYap(long gonderenTcKimlik, long hedefTcKimlik, double miktar) {
        Kullanici gonderen = null;
        Kullanici hedef = null;

        for (Kullanici kullanici : kullaniciListesi) {
            if (kullanici.getTcKimlik() == gonderenTcKimlik) {
                gonderen = kullanici;
            } else if (kullanici.getTcKimlik() == hedefTcKimlik) {
                hedef = kullanici;
            }

            if (gonderen != null && hedef != null) {
                gonderen.paraTransferiYap(hedef, miktar);
                return true;
            }
        }

        return false; // Gerekli kullanıcılar bulunamadı
    }

    public boolean krediOde(Kullanici kullanici, double miktar) {
        if (kullanici != null) {
            kullanici.krediOde(miktar);
            return true;
        }

        return false; // Kullanıcı bulunamadı
    }

    public boolean ekstreOde(Kullanici kullanici, double miktar) {
        if (kullanici != null) {
            kullanici.ekstreOde(miktar);
            return true;
        }

        return false; // Kullanıcı bulunamadı
    }
}