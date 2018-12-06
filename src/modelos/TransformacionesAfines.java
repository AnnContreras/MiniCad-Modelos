package modelos;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import static modelos.Transformaciones.*;

public class TransformacionesAfines extends Transformaciones {

  protected AffineTransform af;

  public TransformacionesAfines() {
    af = new AffineTransform();
  }

  public void crearHomologa(Shape copia, int operacion, Color color) {
    Puntos puntos = new Puntos();
    PathIterator pi = copia.getPathIterator(null);
    for (int i = 0; i < original.npoints; i++) {
      double[] coords = new double[6];
      pi.currentSegment(coords);
      int x = (int) coords[0];
      int y = (int) coords[1];
      puntos.add(new Punto(x, y, 2, Color.RED));
      pi.next();
    }
    homologa = new Poligono(puntos, color);
    tipoTransformacion = operacion;
  }
  
  @Override
  public void aplicarTranslacion(double dX, double dY) {
      af.setToTranslation(dX, dY);
      Shape shape = af.createTransformedShape(original);
      crearHomologa(shape, TRASLACION, Color.WHITE);
  }
  
    @Override
    public void aplicarEscalado(float factor) {
        af.setToScale(factor, factor);
        Shape s = af.createTransformedShape(original);
        crearHomologa(s, HOMOTECIA, Color.WHITE);
    }
    
    @Override
    public void aplicarRotacion(double angulo) {
        double rad = Math.toRadians(angulo);
        af.setToRotation(rad);
        Shape s = af.createTransformedShape(original);
        crearHomologa(s, ROTACION, Color.WHITE);
    }
    
    @Override
    public void aplicarSimetriaCentral(int xC, int yC) {
        af.setToTranslation(-xC, -yC);
        Shape s = af.createTransformedShape(original);
        af.setToScale(-1, -1);
        Shape s1 = af.createTransformedShape(s);
        af.setToTranslation(xC, yC);
        Shape s2 = af.createTransformedShape(s1);
        crearHomologa(s2, SIMETRIA_CENTRAL, Color.WHITE);
    }
    
    @Override
    public void aplicarSimetriaAxial(int x1, int y1, int x2, int y2) {
        double m = (float) (y2 - y1) / (x2 - x1); // Se calcula la pendiente del ele
        double angulo = Math.atan(m); //para conocer el angulo se saca el arcotengente
        double xS = x1 - y1 / m; //xS es la coordenada x del eje de simetria
        double yI = y1 - m * x1; //yI es la coordenada y del eje de simetria
        
        ejeSimetria = new Line2D.Double(xS, 0, 0, yI);
        
        //Una Opcion pero las operaciones son invertidas, viendolo en el orden logiico
        af.setToTranslation(0, yI);  
        af.rotate(angulo);           
        af.scale(1, -1);
        af.rotate(-angulo);
        af.translate(0, -yI);
        Shape s = af.createTransformedShape(original);
        crearHomologa(s, SIMETRIA_AXIAL, Color.WHITE);
        
        //De manera secuencial pero con otro metodo y creando un shape para cada transformacion
//        af.setToTranslation(0, -yI);
//        Shape s = af.createTransformedShape(original);
//        af.setToRotation(-angulo); // el eje esta en el eje de las x
//        Shape s1 = af.createTransformedShape(s);
//        af.setToScale(1, -1); // Se aplica escalado para aplicar la simetria, la fig quedara debajo del eje x
//        Shape s2 = af.createTransformedShape(s1);
//        af.setToRotation(angulo);// el eje vuelvea su lugar (angulo)
//        Shape s3 = af.createTransformedShape(s2);
//        af.setToTranslation(0, yI); //el eje se mueve hacia abajo para que vuelva a su lugar
//        Shape s4 = af.createTransformedShape(s3);
//        crearHomologa(s4, SIMETRIA_AXIAL, Color.WHITE);
    }

}
