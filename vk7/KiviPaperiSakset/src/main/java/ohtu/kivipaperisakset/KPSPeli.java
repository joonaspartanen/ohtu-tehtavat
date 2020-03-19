package ohtu.kivipaperisakset;

import java.util.Scanner;

public abstract class KPSPeli {

  protected static final Scanner scanner = new Scanner(System.in);
  protected Tuomari tuomari = new Tuomari();

  protected static boolean onkoOkSiirto(String siirto) {
    return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
  }

  protected abstract void pelaa();

  protected void tulostaTulos() {
    System.out.println();
    System.out.println("Kiitos!");
    System.out.println(tuomari);
  }

}