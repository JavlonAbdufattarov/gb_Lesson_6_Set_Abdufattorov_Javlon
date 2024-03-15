import java.util.*;

class PhoneBook {
    private static final HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public void add(String name, Integer phoneNum) {
        if (phoneBook.containsKey(name)) {
            ArrayList<Integer> phoneList = phoneBook.get(name);
            phoneList.add(phoneNum);
        } else {
            ArrayList<Integer> phoneList = new ArrayList<>();
            phoneList.add(phoneNum);
            phoneBook.put(name, phoneList);
        }
    }

    public ArrayList<Integer> find(String name) {
        if (phoneBook.containsKey(name)) {
            return phoneBook.get(name);
        } else {
            return new ArrayList<>();
        }
    }

    public static HashMap<String, ArrayList<Integer>> getPhoneBook() {
        return phoneBook;
    }

    public static List<Map.Entry<String, ArrayList<Integer>>> sortByNumOfPhonesDescending() {
        List<Map.Entry<String, ArrayList<Integer>>> entries = new ArrayList<>(phoneBook.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, ArrayList<Integer>>>() {
            @Override
            public int compare(Map.Entry<String, ArrayList<Integer>> entry1, Map.Entry<String, ArrayList<Integer>> entry2) {
                return Integer.compare(entry2.getValue().size(), entry1.getValue().size());
            }
        });
        return entries;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("If you choose 1 program exit");
            System.out.println("If you choose 2 program сontinue ");
            System.out.println("*******************************************************");
            System.out.println("Operation:");
            int operation = scanner.nextInt();
            if(operation==1){
                break;
            }
            if (operation==2){
                System.out.println("Name:");
                String name1=scanner.next();
                System.out.println("PhoneNumber:");
                int phone1=scanner.nextInt();
                PhoneBook myPhoneBook = new PhoneBook();
                myPhoneBook.add(name1, phone1);
                List<Map.Entry<String, ArrayList<Integer>>> sortedPhoneBook = PhoneBook.sortByNumOfPhonesDescending();
                System.out.println("Phone book sorted by the number of phones (descending):");
                for (Map.Entry<String, ArrayList<Integer>> entry : sortedPhoneBook) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }
            else {System.out.println("Pleas choose correct number");}
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }
}
