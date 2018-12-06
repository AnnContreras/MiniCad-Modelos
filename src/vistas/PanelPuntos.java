package vistas;

import controladores.OyentePuntos;
import java.awt.*;
import javax.swing.*;
import modelos.*;

public class PanelPuntos extends JPanel {

    /**
     * @return the puntos
     */
    private Puntos getPuntos() {
        return puntos;
    }

    /**
     * @param puntos the puntos to set
     */
    public void setPuntos(Puntos puntos) {
        this.puntos = puntos;
    }

  private Puntos puntos;

  public PanelPuntos(Puntos puntos) {
    this.puntos = puntos;
    setBackground(Color.decode("0x032142"));
  }

  public PanelPuntos() {
    this(new Puntos());
  }
  
  public void addEventos(OyentePuntos oyente){
      this.addMouseListener(oyente);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    puntos.dibujar(g);
  }
}
