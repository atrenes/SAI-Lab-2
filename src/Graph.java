import java.util.*;

public class Graph {
    private LinkedList<Integer> adjLists[];
    private boolean visited[];
    private final int V = 27;
    private LinkedList<String> result = new LinkedList<>();

    Graph() {
        adjLists = new LinkedList[V];
        visited = new boolean[V];

        for (int i = 0; i < V; i++)
            adjLists[i] = new LinkedList<Integer>();

        this.addEdge("Вильнюс","Брест");
        this.addEdge("Витебск","Брест");
        this.addEdge("Витебск","Вильнюс");
        this.addEdge("Воронеж","Витебск");
        this.addEdge("Воронеж","Волгоград");
        this.addEdge("Волгоград","Витебск");
        this.addEdge("Витебск","Ниж.Новгород");
        this.addEdge("Вильнюс","Даугавпилс");
        this.addEdge("Калининград","Брест");
        this.addEdge("Калининград","Вильнюс");
        this.addEdge("Каунас","Вильнюс");
        this.addEdge("Киев","Вильнюс");
        this.addEdge("Киев","Житомир");
        this.addEdge("Житомир","Донецк");
        this.addEdge("Житомир","Волгоград");
        this.addEdge("Кишинев","Киев");
        this.addEdge("Кишинев","Донецк");
        this.addEdge("С.Петербург","Витебск");
        this.addEdge("С.Петербург","Калининград");
        this.addEdge("С.Петербург","Рига");
        this.addEdge("Москва","Казань");
        this.addEdge("Москва","Ниж.Новгород");
        this.addEdge("Москва","Минск");
        this.addEdge("Москва","Донецк");
        this.addEdge("Москва","С.Петербург");
        this.addEdge("Мурманск","С.Петербург");
        this.addEdge("Мурманск","Минск");
        this.addEdge("Орел","Витебск");
        this.addEdge("Орел","Донецк");
        this.addEdge("Орел","Москва");
        this.addEdge("Одесса","Киев");
        this.addEdge("Рига","Каунас");
        this.addEdge("Таллинн","Рига");
        this.addEdge("Харьков","Киев");
        this.addEdge("Харьков","Симферополь");
        this.addEdge("Ярославль","Воронеж");
        this.addEdge("Ярославль","Минск");
        this.addEdge("Уфа","Казань");
        this.addEdge("Уфа","Самара");
    }

    private void addEdge(String src, String dest) {
        adjLists[stringToInt(src)].add(stringToInt(dest));
        adjLists[stringToInt(dest)].add(stringToInt(src));
    }

    public void DFS(String start, String finish) {
        int vertex = stringToInt(start);
        int dest = stringToInt(finish);
        visited[vertex] = true;

        //System.out.print(" -> " + intToString(vertex));
        this.result.add(intToString(vertex));

        Iterator<Integer> ite = adjLists[vertex].listIterator();
        while (ite.hasNext()) {
            int adj = ite.next();
            if (!visited[adj] && !visited[dest]) {
                DFS(intToString(adj), intToString(dest));
            }
        }
    }

    public void BFS(String start, String finish) {
        int s = stringToInt(start);
        boolean visited[] = new boolean[V];

        LinkedList<Integer> queue = new LinkedList();

        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            //System.out.print(" -> " + intToString(s));
            this.result.add(intToString(s));
            if (intToString(s).equals(finish)) return; //STOP SEARCHING WHEN WE REACH DEST

            Iterator<Integer> i = adjLists[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public void DLS(String start, String finish, int depth, int limit) {
        int vertex = stringToInt(start);
        int dest = stringToInt(finish);
        visited[vertex] = true;
        //System.out.print(" -> " + intToString(vertex));
        this.result.add(intToString(vertex));

        Iterator<Integer> ite = adjLists[vertex].listIterator();

        if (depth < limit) {
            while (ite.hasNext()) {
                int adj = ite.next();
                if (!visited[adj]) {
                    DLS(intToString(adj), intToString(dest), ++depth, limit);
                }
            }
        }
    }

    private int stringToInt(String s) {
        return switch (s) {
            case "Вильнюс" -> 0;
            case "Брест" -> 1;
            case "Витебск" -> 2;
            case "Воронеж" -> 3;
            case "Волгоград" -> 4;
            case "Ниж.Новгород" -> 5;
            case "Даугавпилс" -> 6;
            case "Калининград" -> 7;
            case "Каунас" -> 8;
            case "Киев" -> 9;
            case "Житомир" -> 10;
            case "Донецк" -> 11;
            case "Кишинев" -> 12;
            case "С.Петербург" -> 13;
            case "Рига" -> 14;
            case "Москва" -> 15;
            case "Казань" -> 16;
            case "Минск" -> 17;
            case "Мурманск" -> 18;
            case "Орел" -> 19;
            case "Одесса" -> 20;
            case "Таллинн" -> 21;
            case "Харьков" -> 22;
            case "Симферополь" -> 23;
            case "Ярославль" -> 24;
            case "Уфа" -> 25;
            case "Самара" -> 26;

            default -> -1;
        };
    }

    private String intToString(int index) {
        return switch (index) {
            case 0 -> "Вильнюс";
            case 1 -> "Брест";
            case 2 -> "Витебск";
            case 3 -> "Воронеж";
            case 4 -> "Волгоград";
            case 5 -> "Ниж.Новгород";
            case 6 -> "Даугавпилс";
            case 7 -> "Калининград";
            case 8 -> "Каунас";
            case 9 -> "Киев";
            case 10 -> "Житомир";
            case 11 -> "Донецк";
            case 12 -> "Кишинев";
            case 13 -> "С.Петербург";
            case 14 -> "Рига";
            case 15 -> "Москва";
            case 16 -> "Казань";
            case 17 -> "Минск";
            case 18 -> "Мурманск";
            case 19 -> "Орел";
            case 20 -> "Одесса";
            case 21 -> "Таллинн";
            case 22 -> "Харьков";
            case 23 -> "Симферополь";
            case 24 -> "Ярославль";
            case 25 -> "Уфа";
            case 26 -> "Самара";

            default -> null;
        };
    }

    public void printResult(String dest) {
        for (String s : this.result) {
            if (!s.equals(dest)) {
                System.out.print(s + " -> ");
            } else {
                System.out.println(s);
                return;
            }

            if (result.indexOf(s) == result.size() - 1) {
                System.out.println("X");
                return;
            }
        }
    }
}
