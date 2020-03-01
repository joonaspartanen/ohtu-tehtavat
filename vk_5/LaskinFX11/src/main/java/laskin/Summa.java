package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends Komento {

  private int edellinen;

  public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
    super(tuloskentta, syotekentta, nollaa, undo, sovellus);
  }

  @Override
  public void suorita() {
    int arvo = 0;

    try {
      arvo = Integer.parseInt(syotekentta.getText());
    } catch (Exception e) {
    }

    edellinen = arvo;

    sovellus.plus(arvo);
    asetaKentat();
  }

  public void peru() {
    sovellus.miinus(edellinen);
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