package controladores;

import java.awt.event.*;
import javax.swing.JComponent;
import modelos.Transformaciones;
import vistas.PanelTransformaciones;

public class OyenteTransformaciones implements ActionListener {

  protected Transformaciones trans;
  protected PanelTransformaciones panel;

  public OyenteTransformaciones(
          Transformaciones trans, PanelTransformaciones panel) {
    this.trans = trans;
    this.panel = panel;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    JComponent origen = (JComponent) e.getSource();
    switch (origen.getName()) {
      case "sCentral":
        int xC = 400;
        int yC = 300;
        trans.aplicarSimetriaCentral(xC, yC);
        break;
      case "sAxial":
        trans.aplicarSimetriaAxial(50, 500, 650, 50);
        break;
      case "translacion":
        trans.aplicarTranslacion(300, 100);
        break;
      case "rotacion":
        trans.aplicarRotacion(30);
        break;
      case "escalado":
        trans.aplicarEscalado(2);
        break;
      case "salir":
        System.exit(0);
    }
    panel.repaint();
  }
}
