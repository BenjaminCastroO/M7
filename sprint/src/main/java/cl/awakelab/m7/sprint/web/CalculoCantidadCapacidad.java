package cl.awakelab.m7.sprint.web;

public class CalculoCantidadCapacidad implements CalculoDescuento{
  @Override
  public double descuento(int[] detalle) {
    if(detalle[0] > 5 && detalle[1] <4) {
      return 0.15;
    }
    if(detalle[0] >= 5 && detalle[0] <= 15 && detalle[1] >=4 && detalle[1] <=6) {
      return 0.2;
    }
    if(detalle[0] > 15 && detalle[1] >6) {
      return 0.3;
    }
    if(detalle[0] > 5 && detalle[1] == 2) {
      return 0.15;
    }
    if(detalle[0] < 5 && detalle[1] <= 4) {
      return 0;
    }
    return 0;
  }
}
