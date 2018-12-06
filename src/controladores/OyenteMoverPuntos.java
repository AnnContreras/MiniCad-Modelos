package controladores;

import java.awt.event.*;
import javax.swing.JPanel;
import modelos.*;


public class OyenteMoverPuntos extends OyentePuntos
        implements MouseMotionListener {

  private boolean seleccionado;
  private Punto puntoSeleccionado;

  public OyenteMoverPuntos(Puntos puntos, JPanel panel) {
    super(puntos, panel);
  }

  @Override
  public void mousePressed(MouseEvent e) {
      for (Punto punto : puntos) {
          double d =  punto.distance( e.getX(), e.getY() );
          if (d <= punto.getRadio()) {
              seleccionado = true;
              puntoSeleccionado = punto;
              
          }
      }

  }

  @Override
  public void mouseReleased(MouseEvent e) {
      seleccionado = false;

  }

  @Override
  public void mouseDragged(MouseEvent e) {
      if (seleccionado) {
          
          puntoSeleccionado.move(e.getX(), e.getY());
          panel.repaint();
          
      }

  }
}
