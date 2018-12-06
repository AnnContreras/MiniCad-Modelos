package modelos;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Line2D;
import static modelos.Transformaciones.*;

public class TransformacionesConMatrices extends TransformacionesAfines {

  public void aplicarMatriz(double[] v, int operacion) {//De manera general esta la matrix
    af.setTransform(v[0], v[1], v[2], v[3], v[4], v[5]);
    Shape s = af.createTransformedShape(original);
    this.crearHomologa(s, operacion, Color.YELLOW);
  }

  @Override
  public void aplicarTranslacion(double dX, double dY) {
    double[] t = {1, 0, 0, 1, dX, dY};
    aplicarMatriz(t, TRASLACION);
  }

  @Override
  public void aplicarRotacion(double angulo) {
    double rad = Math.toRadians(angulo);
    double coseno = Math.cos(rad);
    double seno = Math.sin(rad);
    double[] r = {coseno, seno, -seno, coseno, 0, 0};
    aplicarMatriz(r, ROTACION);
  }

  @Override
  public void aplicarEscalado(float factor) {
    double[] s = {factor, 0, 0, factor, 0, 0};
    aplicarMatriz(s, HOMOTECIA);
  }

  @Override
  public void aplicarSimetriaCentral(int xC, int yC) {
    double[] cs = {-1, 0, 0, -1, 2 * xC, 2 * yC};
    aplicarMatriz(cs, SIMETRIA_CENTRAL);
  }

  @Override
  public void aplicarSimetriaAxial(int x1, int y1, int x2, int y2) {
    double m = (float) (y2 - y1) / (x2 - x1);
    double angulo = Math.atan(m);
    double xS = x1 - y1 / m;
    double yI = y1 - m * x1;
    ejeSimetria = new Line2D.Double(xS, 0, 0, yI);
    
    af.setToTranslation(0, yI);  // T(yI) asigna a la matriz sin importar que tenga
    af.rotate(angulo);           // R(angulo)
    af.scale(1, -1);
    af.rotate(-angulo);
    af.translate(0, -yI);
    Shape s = af.createTransformedShape(original);
    crearHomologa(s, SIMETRIA_AXIAL, Color.YELLOW);
    
    //Para hacerlo por matrix se necesito invocar el metodo aplicarMatriz y pasarle el arreglo de la matriz resultante
  }
}
