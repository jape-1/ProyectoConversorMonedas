import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Bienvenido a la aplicacion: Conversor de monedas");
        boolean seguir = true;
        String menu = """
                -----// Monedas Disponibles //-----
                1. Dolares (USD)
                2. Soles (PEN)
                3. Pesos Mexicanos (MXN)
                4. Pesos Argentinos (ARS)
                5. Pesos Colombianos (COP)
                6. Real Brasileño (BRL)
                7. Euros (EUR)
                8. Salir""";
        Scanner scan = new Scanner(System.in);
        while (seguir){
            System.out.println(menu);
            System.out.println("\n////////////Ingrese el tipo de moneda que ingresará:///////////");
            int opcion = scan.nextInt();
            if (opcion == 8){
                break;
            }
            String monedabase = eleccion(opcion);

            System.out.println("------Ingrese su opción a convertir------");
            System.out.println(menu);
            opcion = scan.nextInt();
            if (opcion == 8){
                break;
            }
            String monedaelegida = eleccion(opcion);

            ConsultarMoneda y = new ConsultarMoneda();
            Moneda moneda = y.buscarconversion(monedabase, monedaelegida);
            System.out.println("La tasa de conversion será de :"+moneda.conversion_rate());
            System.out.println("--------------------------------------");
            System.out.println("Ingrese cantidad de dinero a convertir:");
            double a = scan.nextDouble();
            Conversion conv  = new Conversion();
            double finalconv =conv.convertir(moneda, a);
            System.out.println("Su dinero convertido de monedas "+monedabase+" es:" + finalconv+ monedaelegida);
            System.out.println("¿Desea continuar?  SI / NO");
            String continuar = scan.next();
            if (continuar.equalsIgnoreCase("no")){
                seguir=false;
                System.out.println("Aplicacion cerrada");
            }
        }
    }


    public static String eleccion(int opcion){
        String divisa = "";
        switch (opcion){
            case 1: divisa = "USD"; break;
            case 2: divisa = "PEN"; break;
            case 3: divisa = "MXN"; break;
            case 4: divisa = "ARS"; break;
            case 5: divisa = "COP"; break;
            case 6: divisa = "BRL"; break;
            case 7: divisa = "EUR"; break;
            default: System.out.println("error al ingresar "); break;
        }
        return divisa;
    }
}
