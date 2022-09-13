package dam2.inicial.ejercicio3;

import java.util.ArrayList;

public class Agenda {

  public static void main(String[] args) {
    ArrayList<Contacto> agenda = initAgenda();
    pintarMenu();
    listarContactos(agenda);
  }

  private static void pintarMenu() {
    System.out.println("Elija una opción :");
    System.out.println("1. Ver un contacto.");
    System.out.println("2. Añadir un nuevo contacto.");
    System.out.println("3. Borrar un contacto.");
    System.out.println("s. Salir del programa.");
  }

  private static void listarContactos(ArrayList<Contacto> lista) {
    System.out.println("LISTA DE CONTACTOS");
    System.out.println("------------------");
    lista.forEach(contacto -> System.out.println(contacto.nombre()));
    System.out.println("------------------");
  }

  private static ArrayList<Contacto> initAgenda() {
    ArrayList<Contacto> lista = new ArrayList<>();
    lista.add(new Contacto("Adam", "Archer", "Calle Falsa 1", "111111111"));
    lista.add(new Contacto("Betty", "Bell", "Calle Rara 32", "222222222"));
    lista.add(new Contacto("Charlie", "Cox", "Avenida Imposible 4", "333333333"));
    lista.add(new Contacto("Diane", "Davies", "Calle Insensata 3 F", "444444444"));
    lista.add(new Contacto("Erwin", "Ennis", "Plaza de la Constitución 5", "555555555"));
    return lista;
  }

}
