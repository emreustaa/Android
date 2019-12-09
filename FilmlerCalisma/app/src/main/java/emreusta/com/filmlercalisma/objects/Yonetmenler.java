package emreusta.com.filmlercalisma.objects;

public class Yonetmenler {

    private  int yonetmen_id;
    private  String yonetmen_adi;

    public Yonetmenler() {
    }

    public Yonetmenler(int yonetmen_id, String yonetmen_adi) {
        this.yonetmen_id = yonetmen_id;
        this.yonetmen_adi = yonetmen_adi;
    }

    public int getYonetmen_id() {
        return yonetmen_id;
    }

    public void setYonetmen_id(int yonetmen_id) {
        this.yonetmen_id = yonetmen_id;
    }

    public String getYonetmen_adi() {
        return yonetmen_adi;
    }

    public void setYonetmen_adi(String yonetmen_adi) {
        this.yonetmen_adi = yonetmen_adi;
    }
}
