import java.util.*;

public class ListPerformanceComparison {

    private static final int OPERATION_COUNT = 2000; // количество операций

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        System.out.printf("%-15s %-15s %-15s %-15s\n", "Method", "List Type", "Operations", "Time (ms)");
        System.out.println("-------------------------------------------------------------");

        // Тестируем метод add
        testListPerformance("add", arrayList, OPERATION_COUNT);
        testListPerformance("add", linkedList, OPERATION_COUNT);

        // Заполняем списки для дальнейшего тестирования delete и get
        for (int i = 0; i < OPERATION_COUNT; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        // Тестируем метод delete
        testListPerformance("delete", arrayList, OPERATION_COUNT);
        testListPerformance("delete", linkedList, OPERATION_COUNT);

        // Заполняем списки снова для теста метода get
        for (int i = 0; i < OPERATION_COUNT; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        // Тестируем метод get
        testListPerformance("get", arrayList, OPERATION_COUNT);
        testListPerformance("get", linkedList, OPERATION_COUNT);
    }

    private static void testListPerformance(String method, List<Integer> list, int operationCount) {
        long startTime = System.currentTimeMillis();

        switch (method) {
            case "add":
                for (int i = 0; i < operationCount; i++) {
                    list.add(i);
                }
                break;

            case "delete":
                for (int i = 0; i < operationCount; i++) {
                    list.remove(0); // Удаляем первый элемент
                }
                break;

            case "get":
                for (int i = 0; i < operationCount; i++) {
                    list.get(i);
                }
                break;

            default:
                throw new IllegalArgumentException("Unknown method: " + method);
        }

        long endTime = System.currentTimeMillis();
        System.out.printf("%-15s %-15s %-15d %-15d\n", method, list.getClass().getSimpleName(), operationCount, (endTime - startTime));
    }
}