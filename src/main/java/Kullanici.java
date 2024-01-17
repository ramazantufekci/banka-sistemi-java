import java.util.ArrayList;
import java.util.List;

class Kullanici {
    private String ad;
    private String soyad;
    private long tcKimlik;
    private String sifre;
    private double bakiye;

    public Kullanici(String ad, String soyad, long tcKimlik, String sifre) {
        this.ad = ad;
        this.soyad = soyad;
        this.tcKimlik = tcKimlik;
        this.sifre = sifre;
        this.bakiye = 0.0; // Yeni kullanıcı oluşturulduğunda bakiye sıfır olarak başlar.
    }

    // Getter ve Setter metotları

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public long getTcKimlik() {
        return tcKimlik;
    }

    public void setTcKimlik(long tcKimlik) {
        this.tcKimlik = tcKimlik;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public double getBakiye() {
        return bakiye;
    }

    public void setBakiye(double bakiye) {
        this.bakiye = bakiye;
    }

    // Diğer metodlar

    public void paraTransferiYap(Kullanici hedefKullanici, double miktar) {
        if (this.bakiye >= miktar) {
            this.bakiye -= miktar;
            hedefKullanici.setBakiye(hedefKullanici.getBakiye() + miktar);
            System.out.println("Para transferi başarılı. Kalan bakiye: " + this.bakiye);
        } else {
            System.out.println("Yetersiz bakiye. Para transferi başarısız.");
        }
    }

    public void krediOde(double miktar) {
        this.bakiye -= miktar;
        System.out.println("Kredi ödemesi başarılı. Kalan bakiye: " + this.bakiye);
    }

    public void ekstreOde(double miktar) {
        this.bakiye -= miktar;
        System.out.println("Kredi kartı ekstresi ödemesi başarılı. Kalan bakiye: " + this.bakiye);
    }
}
