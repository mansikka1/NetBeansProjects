package matopeli.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import matopeli.peli.Matopeli;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Matopeli matopeli;
    private int sivunPituus;
    private Piirtoalusta piirtoAlusta;

    public Kayttoliittyma(Matopeli matopeli, int sivunPituus) {
        this.matopeli = matopeli;
        this.sivunPituus = sivunPituus;
    }

    @Override
    public void run() {
        frame = new JFrame("Matopeli");
        int leveys = (matopeli.getLeveys() + 1) * sivunPituus + 10;
        int korkeus = (matopeli.getKorkeus() + 2) * sivunPituus + 10;

        frame.setPreferredSize(new Dimension(leveys, korkeus));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public void luoKomponentit(Container container) {
        piirtoAlusta = new Piirtoalusta(this.matopeli, this.sivunPituus);
        container.add(piirtoAlusta);

        Nappaimistonkuuntelija nappaimistonKuuntelija = new Nappaimistonkuuntelija(
                this.matopeli.getMato());
        frame.addKeyListener(nappaimistonKuuntelija);
// Huom! Luo ensin piirtoalusta jonka lisäät container-olioon
        // Luo vasta tämän jälkeen näppäimistönkuuntelija, jonka lisäät frame-oliolle
    }

    public JFrame getFrame() {
        return frame;
    }

    public Paivitettava getPaivitettava() {
        return this.piirtoAlusta;
    }

}
