package ohtu.kivipaperisakset;

public class KPSTekoaly extends KPSPeli {

    public KPSTekoaly(Tekoaly tekoaly) {
        this.tekoaly = tekoaly;
    }

    @Override
    public void pelaa() {

        lueEkanSiirto();
        lueTokanSiirto("tietokone");

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            lueEkanSiirto();
            lueTokanSiirto("tietokone");
            tekoaly.asetaSiirto(ekanSiirto);
        }

        tulostaTulos();
    }
}