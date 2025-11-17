import java.util.Scanner;

public class Conversor {

    public static void mostrarMenu() {
        String menu = """
                +++++++++++++++++++++++++++++++++++++++++++++++++++++++
                Sea bienvenido al conversor de monedas

                1) Dolar -> peso argentino
                2) Peso argentino -> dolar
                3) Dolar -> real brasileño
                4) Real brasileño -> dolar
                5) Dolar -> peso colombiano
                6) Peso colombiano -> dolar
                7) Salir

                Elija opcion valida
                *******************************************************
                """;

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(menu);
            int opcion = sc.nextInt();

            if (opcion == 7) {
                System.out.println("Saliendo del programa...");
                break;
            }

            System.out.print("Ingrese el valor que deseas convertir: ");
            double valor = sc.nextDouble();

            String base = "";
            String destino = "";

            switch (opcion) {
                case 1 -> { base = "USD"; destino = "ARS"; }
                case 2 -> { base = "ARS"; destino = "USD"; }
                case 3 -> { base = "USD"; destino = "BRL"; }
                case 4 -> { base = "BRL"; destino = "USD"; }
                case 5 -> { base = "USD"; destino = "COP"; }
                case 6 -> { base = "COP"; destino = "USD"; }
                default -> {
                    System.out.println("Opción inválida.");
                    continue;
                }
            }

            double tasa = ClienteAPI.obtenerTasa(base, destino);
            double resultado = valor * tasa;

            System.out.println("\nEl valor " + valor + " [" + base + "] corresponde al valor final de ==> "
                    + resultado + " [" + destino + "]\n");
        }
    }
}