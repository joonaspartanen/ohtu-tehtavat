package ohtu.kivipaperisakset;

public class KPSPelaajaVsPelaaja extends KPSPeli {

    @Override
    public void pelaa() {

        lueEkanSiirto();
        lueTokanSiirto("ihminen");

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            lueEkanSiirto();
            lueTokanSiirto("ihminen");
        }

       tulostaTulos();
    }
}