package emreusta.com.detaylirecyclerview;

import java.io.Serializable;

public class Filmler implements Serializable {

    private String film_baslik;
    private double film_fiyat;
    private String film_resim;

    public Filmler() {
    }

    public Filmler(String film_baslik, double film_fiyat, String film_resim) {
        this.film_baslik = film_baslik;
        this.film_fiyat = film_fiyat;
        this.film_resim = film_resim;
    }

    public String getFilm_baslik() {
        return film_baslik;
    }

    public void setFilm_baslik(String film_baslik) {
        this.film_baslik = film_baslik;
    }

    public double getFilm_fiyat() {

        return film_fiyat;
    }

    public void setFilm_fiyat(double film_fiyat) {
        this.film_fiyat = film_fiyat;
    }

    public String getFilm_resim() {

        return film_resim;
    }

    public void setFilm_resim(String film_resim) {
        this.film_resim = film_resim;
    }
}
