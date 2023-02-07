package menu;

import model.Order;
import service.OrderService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ConsoleMenu {

    private OrderService orderService;
    private DateTimeFormatter formatter;
    private Scanner ler;

    public ConsoleMenu() {
        orderService = new OrderService();
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ler = new Scanner(System.in);
    }

    public void start(){
        int aux = 0;
        while (aux < 2){
            System.out.println("Ola, escolha o que deseja fazer!\n1 - Fazer filtragem\n2 - Sair\nDigite: ");
            aux = ler.nextInt();
            if (aux == 1)
                menu();
        }
    }

    private void menu(){
        System.out.println("Ola!\nEscreva a primeira data: (yyyy-mm-dd)");
        String textoDigitado = ler.next();
        LocalDateTime primeiraData = LocalDateTime.parse(textoDigitado + " 00:00:00", this.formatter);
        System.out.println("Escreva a segunda data: (yyyy-mm-dd)");
        textoDigitado = ler.next();
        LocalDateTime segundaData = LocalDateTime.parse(textoDigitado+ " 00:00:00", this.formatter);
        System.out.println("Qual o nome do produto?");
        String produtoNome = ler.next();

        List<Order> lista = orderService.getOrdersByDataAndProduct(primeiraData, segundaData, produtoNome);

        detalharOrders(lista);
    }

    private void detalharOrders(List<Order> lista){

        System.out.println("---------------------LISTA---------------------");
        HashMap<Integer, Integer> contadores = new HashMap<>();

        for(Order order : lista){
            if (!contadores.containsKey(order.getCreateDate().getYear())) {
                contadores.put(order.getCreateDate().getYear(), 1);
            } else {
                int currentCount = contadores.get(order.getCreateDate().getYear());
                currentCount++;
                contadores.put(order.getCreateDate().getYear(), currentCount);
            }

        }

        contadores.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByKey())
                .forEach(System.out::println);

    }

}
