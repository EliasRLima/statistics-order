package main.menu;

import main.exception.MessageProperties;
import main.exception.SystemException;
import main.model.Order;
import main.service.OrderService;

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
                menuFiltragem();
        }
    }

    private void menuFiltragem(){
        System.out.println("Ola!\nEscreva a primeira data: (yyyy-mm-dd)");
        String textoDigitado = ler.next();
        LocalDateTime primeiraData = LocalDateTime.now();
        try {
            primeiraData = LocalDateTime.parse(textoDigitado + " 00:00:00", this.formatter);
        }catch (Exception e){
            throw new SystemException(
                    MessageProperties.getMensagemPadrao("erro.formato.data"));
        }

        System.out.println("Escreva a segunda data: (yyyy-mm-dd)");
        textoDigitado = ler.next();
        LocalDateTime segundaData = LocalDateTime.now();
        try {
           segundaData = LocalDateTime.parse(textoDigitado+ " 00:00:00", this.formatter);
        }catch (Exception e){
            throw new SystemException(
                    MessageProperties.getMensagemPadrao("erro.formato.data"));
        }

        System.out.println("Qual o nome do produto?");
        String produtoNome = ler.next();



        List<Order> lista = orderService.getOrdersByDataAndProduct(primeiraData, segundaData, produtoNome);

        detalharOrders(lista, primeiraData, segundaData);
    }

    private void detalharOrders(List<Order> lista, LocalDateTime primeiraData, LocalDateTime segundaData){

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
        for(int ano = primeiraData.getYear();  ano <= segundaData.getYear(); ano++){
            if (!contadores.containsKey(ano)) {
                contadores.put(ano, 0);
            }
        }

        contadores.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByKey())
                .forEach(System.out::println);

        System.out.println("-----------------------------------------------\n\n");

    }

}
