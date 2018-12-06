package modelos;

import java.awt.*;

public class Punto extends Point implements Dibujable 
{

  private int radio;
  private Color color;

  public Punto( int x, int y, int radio, Color color ) 
  {
    super( x, y );
    this.radio = radio;
    this.color = color;
  }

  public Punto() 
  {
    this( 0, 0, 0, Color.BLACK );
  }
  
  /**
     * @return the radio
     */
    public int getRadio() {
        return radio;
    }

    /**
     * @param radio the radio to set
     */
    private void setRadio(int radio) {
        this.radio = radio;
    }

    /**
     * @return the color
     */
    private Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    private void setColor(Color color) {
        this.color = color;
    }

  @Override
  public void dibujar( Graphics g ) {
    g.setColor(color);
    g.fillOval(x - radio, y - radio, 2 * radio, 2 * radio);
    g.setColor(Color.BLACK);
    g.drawOval(x - radio, y - radio, 2 * radio, 2 * radio);
  }
}
