package cl.awakelab.m7.sprint.web;

public class CalculoCantidad implements CalculoDescuento{
  @Override
  public double descuento(int[] detalle) {
    if(detalle[0] > 15){
      return 0.3;
    }
    else if(detalle[0] >= 10) {
      return 0.05;
    }
    else if(detalle[0] > 5) {
      return 0.03;
    } else
    return 0;
  }
}
