package prog;

import ui.FrameApp;

import java.util.Scanner;

//import javax.swing.*;

public class Reto3 {
    /**
     *
     * Este debe ser el único objeto de tipo Scanner en el código
     *
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Este método es usado para solicitar datos al usuario
     * @return  Lectura de la siguiente linea del teclado
     */
    public String read(){
        return this.scanner.nextLine();
    }

    public void run(){

        DatabaseProduct baseDatos = new DatabaseProduct();
        String operacion = read();
        String valores = read();
        String[] valoresSeparados = valores.split(" ");

        int codigoProducto = Integer.parseInt(valoresSeparados[0]);
        String nombreProducto = valoresSeparados[1];
        double precioProducto = Double.parseDouble(valoresSeparados[2]);
        int inventarioProducto = Integer.parseInt(valoresSeparados[3]);

        boolean existencia = baseDatos.verificarExistencia(codigoProducto);

        if (operacion.equals("AGREGAR")){
            if (!existencia) {
                baseDatos.agregarProducto(codigoProducto, nombreProducto, precioProducto, inventarioProducto);
                baseDatos.generarInforme();
            }else{
                System.out.println("ERROR");
            }
        }

        if (operacion.equals("BORRAR")){
            if (existencia){
                baseDatos.eliminarProducto(codigoProducto);
                baseDatos.generarInforme();
            }else {
                System.out.println("ERROR");
            }
        }

        if (operacion.equals("ACTUALIZAR")){
            if (existencia){
                baseDatos.actualizarProducto(codigoProducto, nombreProducto, precioProducto, inventarioProducto);
                baseDatos.generarInforme();
            }else{
                System.out.println("ERROR");
            }
        }

    }

    public static void main(String[] args) {

        new FrameApp();

        Reto3 productApp = new Reto3();
        productApp.run();

    }
}
