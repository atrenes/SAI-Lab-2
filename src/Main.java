import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final int CITY_NUM = 27;
        Graph g = new Graph(CITY_NUM);

        g.addEdge("Вильнюс","Брест");
        g.addEdge("Витебск","Брест");
        g.addEdge("Витебск","Вильнюс");
        g.addEdge("Воронеж","Витебск");
        g.addEdge("Воронеж","Волгоград");
        g.addEdge("Волгоград","Витебск");
        g.addEdge("Витебск","Ниж.Новгород");
        g.addEdge("Вильнюс","Даугавпилс");
        g.addEdge("Калининград","Брест");
        g.addEdge("Калининград","Вильнюс");
        g.addEdge("Каунас","Вильнюс");
        g.addEdge("Киев","Вильнюс");
        g.addEdge("Киев","Житомир");
        g.addEdge("Житомир","Донецк");
        g.addEdge("Житомир","Волгоград");
        g.addEdge("Кишинев","Киев");
        g.addEdge("Кишинев","Донецк");
        g.addEdge("С.Петербург","Витебск");
        g.addEdge("С.Петербург","Калининград");
        g.addEdge("С.Петербург","Рига");
        g.addEdge("Москва","Казань");
        g.addEdge("Москва","Ниж.Новгород");
        g.addEdge("Москва","Минск");
        g.addEdge("Москва","Донецк");
        g.addEdge("Москва","С.Петербург");
        g.addEdge("Мурманск","С.Петербург");
        g.addEdge("Мурманск","Минск");
        g.addEdge("Орел","Витебск");
        g.addEdge("Орел","Донецк");
        g.addEdge("Орел","Москва");
        g.addEdge("Одесса","Киев");
        g.addEdge("Рига","Каунас");
        g.addEdge("Таллинн","Рига");
        g.addEdge("Харьков","Киев");
        g.addEdge("Харьков","Симферополь");
        g.addEdge("Ярославль","Воронеж");
        g.addEdge("Ярославль","Минск");
        g.addEdge("Уфа","Казань");
        g.addEdge("Уфа","Самара");

        System.out.println("DFS: ");
        g.DFS("Харьков", "Ниж.Новгород");
        System.out.println();

        System.out.println("BFS: ");
        g.BFS("Харьков", "Ниж.Новгород");
    }
}
