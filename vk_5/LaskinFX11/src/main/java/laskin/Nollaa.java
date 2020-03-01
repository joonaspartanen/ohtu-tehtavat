package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Komento {

  private int edellinen;

  public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
    super(tuloskentta, syotekentta, nollaa, undo, sovellus);
  }

  @Override
  public void suorita() {
    edellinen = sovellus.tulos();
    sovellus.nollaa();
    asetaKentat();
  }

  public void peru() {
    sovellus.palauta(edellinen);
    asetaKentat();
  }

  private void asetaKentat() {
    int laskunTulos = sovellus.tulos();

    syotekentta.setText("");
    tuloskentta.setText("" + laskunTulos);

    if (laskunTulos == 0) {
      nollaa.disableProperty().set(true);
    } else {
      nollaa.disableProperty().set(false);
    }
    undo.disableProperty().set(false);
  }
};