
package ohtu.intjoukkosovellus;

public class IntJoukko {

    private int oletuskapasiteetti = 5;
    private int kasvatuskoko = 5; // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] joukko; // Joukon luvut säilytetään taulukon alkupäässä.
    private int alkioidenLkm = 0; // Tyhjässä joukossa alkioiden_määrä on nolla.

    public IntJoukko() {
        alusta(oletuskapasiteetti); 
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti > 0) {
            alusta(kapasiteetti);
        }
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti > 0 && kasvatuskoko > 0) {
            alusta(kapasiteetti);
            this.kasvatuskoko = kasvatuskoko;
        }
    }

    public void alusta(int kapasiteetti) {
        joukko = new int[kapasiteetti];
        for (int i = 0; i < joukko.length; i++) {
            joukko[i] = 0;
        }
    }

    public void lisaa(int luku) {
        if (kuuluu(luku)) {
            return;
        }

        joukko[alkioidenLkm] = luku;
        alkioidenLkm++;

        if (alkioidenLkm == joukko.length) {
            kasvata();
        }
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == joukko[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        if (!kuuluu(luku)) {
            return false;
        }

        int kohta = etsi(luku);
        nollaaAlkaen(kohta);
        alkioidenLkm--;
        return true;
    }

    public int etsi(int luku) {
        int kohta = -1;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == joukko[i]) {
                kohta = i;
                break;
            }
        }
        return kohta;
    }

    public void nollaaAlkaen(int mista) {
        int apu;

        for (int i = mista; i < alkioidenLkm - 1; i++) {
            apu = joukko[i];
            joukko[i] = joukko[i + 1];
            joukko[i + 1] = apu;
        }
    }

    private void kasvata() {
        int[] uusiJoukko = new int[alkioidenLkm + kasvatuskoko];
        for (int i = 0; i < joukko.length; i++) {
            uusiJoukko[i] = joukko[i];
        }
        joukko = uusiJoukko;
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else {
            String tulos = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                tulos += joukko[i];
                tulos += ", ";
            }
            tulos += joukko[alkioidenLkm - 1];
            tulos += "}";
            return tulos;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = joukko[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdiste = new IntJoukko();
        int[] taulukkoA = a.toIntArray();
        int[] taulukkoB = b.toIntArray();
        for (int i = 0; i < taulukkoA.length; i++) {
            yhdiste.lisaa(taulukkoA[i]);
        }
        for (int i = 0; i < taulukkoB.length; i++) {
            yhdiste.lisaa(taulukkoB[i]);
        }
        return yhdiste;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkaus = new IntJoukko();
        int[] taulukkoA = a.toIntArray();
        int[] taulukkoB = b.toIntArray();
        for (int i = 0; i < taulukkoA.length; i++) {
            for (int j = 0; j < taulukkoB.length; j++) {
                if (taulukkoA[i] == taulukkoB[j]) {
                    leikkaus.lisaa(taulukkoB[j]);
                }
            }
        }
        return leikkaus;
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko erotus = new IntJoukko();
        int[] taulukkoA = a.toIntArray();
        int[] taulukkoB = b.toIntArray();
        for (int i = 0; i < taulukkoA.length; i++) {
            erotus.lisaa(taulukkoA[i]);
        }
        for (int i = 0; i < taulukkoB.length; i++) {
            erotus.poista(taulukkoB[i]);
        }
        return erotus;
    }
}
