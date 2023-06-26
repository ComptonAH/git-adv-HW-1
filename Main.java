
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner enter = new Scanner(System.in);
        HashMap<String, String> p_b = new HashMap<>();

        System.out.print("Enter the size of the phone_book: ");
        int p_b_size = enter.nextInt();

        for (int i = 0; i < p_b_size; i++) {
            System.out.print("Enter the name of the phone number's owner: ");
            String name = enter.next();
            name = name.substring(0, 1).toUpperCase() + name.substring(1);

            System.out.print("Enter the phone number you want to add: ");
            String phone_num = enter.next();

//            String sub_p_n = phone_num;
//
//            if (phone_num.startsWith("+")) {
//                sub_p_n = phone_num.substring(1);
//            } else {
//                Integer sub_p_n1 = Integer.parseInt(sub_p_n);
//            }
//            if (sub_p_n1 instanceof int) {
//                System.out.println("You have entered the non-numeric symbol. Please try again!");
//                break;
//            }
            if (p_b.containsKey(name)) {
                p_b.compute(name, (key, value) -> value + ", " + phone_num);
            } else {
                p_b.put(name, " " + phone_num);
            }
        }
        // First solution
//        p_b.entrySet().stream()
//                .sorted(Map.Entry.<String, String>comparingByValue())
//                .forEach(System.out::println);

        // Second solution
        ArrayList<String> p_b_keys = new ArrayList<>(p_b.keySet());
        p_b_keys.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] splitted_o1 = p_b.get(o1).split(",");
                String[] splitted_o2 = p_b.get(o2).split(",");
                int o1_counter = splitted_o1.length;
                int o2_counter = splitted_o2.length;
                if (o1_counter > o2_counter) {
                    return o2_counter - o1_counter;
                } else {
                    return 0;
                }
            }
        });

        for (int i = 0; i < p_b_size; i++) {
            if (i == p_b_size - 1) {
                for (String key :
                        p_b_keys) {
                    System.out.println(key + ": " + p_b.get(key));
                }
            }
        }
    }
}