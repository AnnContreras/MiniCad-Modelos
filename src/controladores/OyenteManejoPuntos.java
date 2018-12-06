package controladores;


import java.awt.event.*;
import javax.swing.*;
import modelos.Puntos;

public class OyenteManejoPuntos extends OyentePuntos implements ActionListener {

  public OyenteManejoPuntos(Puntos puntos, JPanel panel) {
    super(puntos, panel);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
      puntos = new Puntos();
      puntos.clear();
      panel.repaint();
  }
}
