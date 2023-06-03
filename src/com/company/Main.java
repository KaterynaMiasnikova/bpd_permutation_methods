package com.company;

public class Main {
    public static void main(String[] args) {
        System.out.print("\nВхідна фраза:\n");
        String input = "Гей, хлопці, не вспію - на ґанку ваша файна їжа знищується бурундучками? Поспішайте: 15.5 миль!";
        System.out.print(input);
        System.out.print("\n");
        System.out.print("\nКодування способом простої перестановки:\n");
        String output_1 = Func.coding_simple_table(input, 6, 8);
        System.out.print(output_1);
        System.out.print("\nДекодування способом простої перестановки:\n");
        String output_1_1 = Func.decoding_simple_table(output_1, 6, 8);
        System.out.print(output_1_1);
        System.out.print("\n");
        int key_columns = 31264587;
        System.out.print("\nКодування способом одинарної перестановки за ключем:\n");
        String output_2 = Func.coding_single_reshuffle(input, 6, 8, key_columns);
        System.out.print(output_2);
        System.out.print("\nДекодування способом одинарної перестановки за ключем:\n");
        String output_2_1 = Func.decoding_single_reshuffle(output_2, 6, 8, key_columns);
        System.out.print(output_2_1);
        System.out.print("\n");
        int key_rows = 321654;
        System.out.print("\nКодування способом подвійної перестановки за ключем:\n");
        String output_3 = Func.coding_double_reshuffle(input, 6, 8, key_columns, key_rows);
        System.out.print(output_3);
        System.out.print("\nДекодування способом подвійної перестановки за ключем:\n");
        String output_3_1 = Func.decoding_double_reshuffle(output_3, 6, 8, key_columns, key_rows);
        System.out.print(output_3_1);
        System.out.print("\n");
    }
}
