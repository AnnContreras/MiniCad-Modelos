package modelos;

import java.awt.Color;
import java.awt.geom.Line2D;

public class Transformaciones {

  public static final int SIMETRIA_CENTRAL = 1;
  public static final int SIMETRIA_AXIAL = 2;
  public static final int TRASLACION = 3;
  public static final int ROTACION = 4;
  public static final int HOMOTECIA = 5;
  protected Poligono original;
  protected Poligono homologa;
  protected Line2D ejeSimetria;
  protected int tipoTransformacion;

  public Transformaciones() {
    crearShapeOriginal();
  }

  public void crearShapeOriginal() {
    int x = 200;
    int y = 70;
    int[] pX = {x, x + 50, x + 50, x + 100, x + 100, x};
    int[] pY = {y, y, y + 100, y + 100, y + 150, y + 150};
    Puntos puntos = new Puntos();
    for (int i = 0; i < pX.length; i++) {
      puntos.add(new Punto(pX[i], pY[i], 5, Color.RED));
    }
    original = new Poligono(puntos, Color.BLUE);
  }

  public Poligono getOriginal() {
    return original;
  }

  public Poligono getHomologa() {
    return homologa;
  }

  public Line2D getEjeSimetria() {
    return ejeSimetria;
  }

  public int getTipoTransformacion() {
    return tipoTransformacion;
  }

  public void aplicarSimetriaCentral(int xC, int yC) {
      Puntos puntos = new Puntos();
    for (Punto punto : original.getPuntos()) {
        int xH = 2 * xC - punto.x;
        int yH = 2 * yC - punto.y;
        puntos.add(new Punto(xH, yH, 5, Color.RED));
    }
    homologa = new Poligono(puntos, Color.GREEN);
    tipoTransformacion = SIMETRIA_CENTRAL;
  }

  public void aplicarSimetriaAxial(int x1, int y1, int x2, int y2) {
    double m1 = (double) (y2 - y1) / (x2 - x1);
    Puntos puntos = new Puntos();
    
    for (Punto punto : original.getPuntos()) {
        int xO = punto.x;
        int yO = punto.y;
        int xC = (int) ((xO + m1 * (yO + m1 * x1 - y1)) / (m1 * m1 + 1));
        int yC = (int) (m1 * (xC - x1) + y1);
        int xH = 2 * xC - punto.x;
        int yH = 2 * yC - punto.y;
        puntos.add(new Punto(xH, yH, 5, Color.RED));
    }
    homologa = new Poligono(puntos, Color.GREEN);
    double xS = x1 - y1 / m1;
    double yI = y1 - m1 * x1;
    ejeSimetria = new Line2D.Double(xS, 0, 0, yI);

    tipoTransformacion = SIMETRIA_AXIAL;
  }

  public void aplicarTranslacion(double dX, double dY) {
      
      Puntos puntos = new Puntos();
        for (Punto punto : original.getPuntos()) {
            int xO = punto.x;
            int yO = punto.y;
            int xH = (int) (xO + dX);
            int yH = (int) (yO + dY);
            puntos.add(new Punto(xH, yH, 5, Color.RED));
        }
        homologa = new Poligono(puntos, Color.GREEN);
    tipoTransformacion = TRASLACION;
  }

  public void aplicarRotacion(double angulo) {
      
      double rad = Math.toRadians(angulo);
      Puntos puntos = new Puntos();
      for(Punto punto : original.getPuntos()){
          
          int x0 = punto.x;
          int y0 = punto.y;
          int xH = (int)(x0 * Math.cos(rad) - y0 * Math.sin(rad));
          int yH = (int)(x0 * Math.sin(rad) + y0 * Math.cos(rad));
          puntos.add(new Punto(xH, yH, 5, Color.RED) );
          
      }
      homologa = new Poligono(puntos, Color.GREEN);

    tipoTransformacion = ROTACION;
  }

  public void aplicarEscalado(float factor) {
      
      Puntos puntos = new Puntos();
      for(Punto punto : original.getPuntos()){
          
          int x0 = punto.x;
          int y0 = punto.y;
          int xH = (int)(x0 * factor);
          int yH = (int)(y0 * factor);
          puntos.add(new Punto(xH, yH, 5, Color.RED) );
          
      }
      homologa = new Poligono(puntos, Color.GREEN);
    tipoTransformacion = HOMOTECIA;
  }
}
