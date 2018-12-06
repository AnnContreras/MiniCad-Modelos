package modelos;

import java.awt.*;
import java.awt.geom.*;

public class Forma2D implements Dibujable {

  private Shape forma;
  private Color color;
  

  public static Forma2D crearRectangulo() {
    Forma2D forma2D = new Forma2D();
    forma2D.setForma(new Rectangle2D.Double(-50, -50, 100, 100));
    forma2D.setColor(Color.BLUE);
    return forma2D;
  }

  @Override
  public void dibujar(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    g2.setColor(color);
    g2.fill(forma);
    g2.setColor(Color.BLACK);
    g2.draw(forma);
  }

  public Shape getForma() {
    return forma;
  }

  public void setForma(Shape forma) {
    this.forma = forma;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

}
