package ohtu.kivipaperisakset;

public class Pelitehdas {

  public static KPSPeli luoKPSPelaajaVsPelaaja() {
    return new KPSPelaajaVsPelaaja();
  }

  public static KPSPeli luoKPSTekoaly() {
    return new KPSTekoaly(new TekoalyTavallinen());
  }

  public static KPSPeli luoKpsParempiTekoaly() {
    return new KPSTekoaly(new TekoalyParannettu(20));
  }

}