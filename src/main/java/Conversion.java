public class Conversion {
    public double convertir(Moneda moneda, double cantidad){
        double tasadeconv = moneda.conversion_rate();
        return cantidad * tasadeconv;
    }
}
