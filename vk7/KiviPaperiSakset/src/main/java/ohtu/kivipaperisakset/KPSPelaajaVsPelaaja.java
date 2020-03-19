package ohtu.kivipaperisakset;

public class KPSPelaajaVsPelaaja extends KPSPeli {

    @Override
    public void pelaa() {

        System.out.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = scanner.nextLine();
        System.out.print("Toisen pelaajan siirto: ");
        String tokanSiirto = scanner.nextLine();

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            System.out.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = scanner.nextLine();

            System.out.print("Toisen pelaajan siirto: ");
            tokanSiirto = scanner.nextLine();
        }

       tulostaTulos();
    }
}