package modelos;

import java.awt.Graphics;
import java.util.ArrayList;

public class Puntos extends ArrayList<Punto> implements Dibujable {

  @Override
  public void dibujar( Graphics g ) 
  {
      for (Punto punto : this) {
          punto.dibujar(g);
      }
  }
  
}
