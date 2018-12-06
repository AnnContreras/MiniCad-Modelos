package controladores;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import modelos.*;

public class OyentePuntos extends MouseAdapter {

  protected Puntos puntos;
  protected JPanel panel;

  public OyentePuntos(Puntos puntos, JPanel panel) {
    this.puntos = puntos;
    this.panel = panel;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
      int x = e.getX();
      int y = e.getY();
      
      Punto punto = new Punto(x, y, 30, Color.RED);
      puntos.add(punto);
      panel.repaint();

  }
}
