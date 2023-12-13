import java.util.*;

public class Main {

    public static void main(String[] args) {
        pushPhoneBook();
    }

    public static void pushPhoneBook() {
        String name1 = "Ivanov";
        String name2 = "Petrov";
        int phone1 = 123456;
        int phone2 = 654321;

        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.add(name1, phone1);
        myPhoneBook.add(name1, phone2);
        myPhoneBook.add(name2, phone2);

        myPhoneBook.add("Alice", 123456);
        myPhoneBook.add("Alice", 789012);
        myPhoneBook.add("Bob", 789012);

        myPhoneBook.add("David", 111111);
        myPhoneBook.add("David", 222222);
        myPhoneBook.add("David", 333333);

        System.out.println(name1);
        System.out.println(myPhoneBook.find(name1));
        System.out.println("Alice");
        System.out.println(myPhoneBook.find("Alice"));
        //System.out.println(myPhoneBook.find("Me"));
        //System.out.println(PhoneBook.getPhoneBook());
        //TreeMap<String, ArrayList<Integer>> sorted = new TreeMap<>(PhoneBook.getPhoneBook());
        //System.out.println(sorted);
        List<Map.Entry<String, ArrayList<Integer>>> mappings = new ArrayList<>(PhoneBook.getPhoneBook().entrySet());
        Collections.sort(mappings, new Comparator<Map.Entry<String, ArrayList<Integer>>>() {
            @Override
            public int compare(Map.Entry<String, ArrayList<Integer>> t1, Map.Entry<String, ArrayList<Integer>> t2) {
                int sizet1 = t1.getValue().size();
                int sizet2 = t2.getValue().size();
                return Integer.compare(sizet1,sizet2);
            }
        });
        Collections.reverse(mappings);
        // Создаем пустой linkedHashMap с порядком вставки
        Map <String, ArrayList<Integer>> linkedHashMap = new LinkedHashMap<>();
        // для каждой записи в отсортированном списке вставляем пару ключ-значение
        for (Map.Entry<String, ArrayList<Integer>> entry: mappings) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        System.out.println(linkedHashMap);

    } // --- End pushPhoneBook()

} // --- End Class