package modelos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;


public class Poligono extends Polygon implements Dibujable {

  private Color color;
  private Puntos puntos;

  public Poligono(Puntos puntos, Color color) {
    this.puntos = puntos;
    for (Punto punto : puntos) {
      this.addPoint(punto.x, punto.y);
    }
    this.color = color;
  }
  
  /**
   * Para las transformaciones con movimiento
   */
  public void ajustarPuntos(){
    for(int i=0;i<puntos.size();i++){
      this.xpoints[i] = puntos.get(i).x;
      this.ypoints[i] = puntos.get(i).y;
    }
  }

  @Override
  public void dibujar(Graphics g) {
    g.setColor(color);
    g.fillPolygon(this);
    g.setColor(Color.WHITE);
    g.drawPolygon(this);
    for (Punto punto : puntos) {
      punto.dibujar(g);
    }

  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public Puntos getPuntos() {
    return puntos;
  }

  public void setPuntos(Puntos puntos) {
    this.puntos = puntos;
  }
}
