package ohtu.kivipaperisakset;

import java.util.Scanner;

public abstract class KPSPeli {

  protected static final Scanner scanner = new Scanner(System.in);
  protected Tuomari tuomari = new Tuomari();
  protected String ekanSiirto;
  protected String tokanSiirto;
  protected Tekoaly tekoaly;

  protected static boolean onkoOkSiirto(String siirto) {
    return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
  }

  protected abstract void pelaa();

  protected void tulostaTulos() {
    System.out.println();
    System.out.println("Kiitos!");
    System.out.println(tuomari);
  }

  protected void lueEkanSiirto() {
    System.out.print("Ensimmäisen pelaajan siirto: ");
    ekanSiirto = scanner.nextLine();
  }

  protected void lueTokanSiirto(String pelaaja) {
    if (pelaaja.equals("tietokone")) {
      tokanSiirto = tekoaly.annaSiirto();
      System.out.println("Tietokone valitsi: " + tokanSiirto);
    } else {
      System.out.print("Toisen pelaajan siirto: ");
      tokanSiirto = scanner.nextLine();
    }
  }
}