package vistas;

import java.awt.*;
import javax.swing.JPanel;
import modelos.*;
import static modelos.Transformaciones.*;

public class PanelTransformaciones extends JPanel {

  protected Transformaciones trans;

  public PanelTransformaciones(Transformaciones trans) {
    this.trans = trans;
    setBackground(Color.decode("0x02152b"));
  }
  
  private void dibujarLineas(Graphics2D g2) {
    g2.setColor(Color.WHITE);
    float[] trama = {2, 2};
    BasicStroke s = new BasicStroke(1,
    BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1, trama, 0);
    g2.setStroke(s);
    Puntos original = trans.getOriginal().getPuntos();
    Puntos homologo = trans.getHomologa().getPuntos();
    for (int i = 0; i < original.size(); i++) {
        Punto o = original.get(i);
        Punto h = homologo.get(i);
        g2.drawLine(o.x, o.y, h.x, h.y);
    }
}

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    trans.getOriginal().dibujar(g);
    if (trans.getHomologa() != null) {
      trans.getHomologa().dibujar(g);
      
      switch (trans.getTipoTransformacion()) {
        case ROTACION:
        break;
        case SIMETRIA_AXIAL:
        g2.setColor(Color.MAGENTA);
        g2.draw(trans.getEjeSimetria());
        default:
        dibujarLineas(g2);
}
    }
  }

}
