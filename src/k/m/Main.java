package k.m;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("\nPassphrase for encryption:\n");
        String input = in.nextLine();//"You become responsible, forever, for what you have tamed.";
        System.out.print(input);
        System.out.print("\n");
        System.out.print("\nCoding using simple permutation:\n");
        String output_1 = Func.coding_simple_table(input, 6, 8);
        System.out.print(output_1);
        System.out.print("\nDecoding using simple permutation:\n");
        String output_1_1 = Func.decoding_simple_table(output_1, 6, 8);
        System.out.print(output_1_1);
        System.out.print("\n");
        int key_columns = 31264587;
        System.out.print("\nEncoding by the method of single permutation by key:\n");
        String output_2 = Func.coding_single_reshuffle(input, 6, 8, key_columns);
        System.out.print(output_2);
        System.out.print("\nDecoding using a single permutation by key:\n");
        String output_2_1 = Func.decoding_single_reshuffle(output_2, 6, 8, key_columns);
        System.out.print(output_2_1);
        System.out.print("\n");
        int key_rows = 321654;
        System.out.print("\nCoding by the method of double permutation by key:\n");
        String output_3 = Func.coding_double_reshuffle(input, 6, 8, key_columns, key_rows);
        System.out.print(output_3);
        System.out.print("\nDecoding by the method of double permutation by key:\n");
        String output_3_1 = Func.decoding_double_reshuffle(output_3, 6, 8, key_columns, key_rows);
        System.out.print(output_3_1);
        System.out.print("\n");
    }
}