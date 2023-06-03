package k.m;

public class Func {
    public static String coding_simple_table(String input, int rows, int columns) {
        StringBuilder code = new StringBuilder(replace(input, rows, columns));
        StringBuilder output = new StringBuilder();
        int a = 0;
        int b = 0;
        char[][] table = new char[rows][columns];
        for (char c : code.toString().toCharArray()) {
            table[a++][b] = c;
            if (a == rows) {
                a = 0;
                b++;
                if (b == columns) {
                    int count = 0;
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < columns; j++) {
                            count++;
                            output.append(table[i][j]);
                            if (count == 5) {
                                output.append(" ");
                                count = 0;
                            }
                        }
                    }
                    output.append("\n");
                    b = 0;
                }
            }
        }
        return output.toString();
    }

    public static String decoding_simple_table(String input, int rows, int columns) {
        StringBuilder code = new StringBuilder(re_replace(input));
        StringBuilder output = new StringBuilder();
        int a = 0;
        int b = 0;
        char[][] table = new char[rows][columns];
        for (char c : code.toString().toCharArray()) {
            table[a][b++] = c;
            if (b == columns) {
                b = 0;
                a++;
                if (a == rows) {
                    for (int j = 0; j < columns; j++) {
                        for (int i = 0; i < rows; i++) {
                            output.append(table[i][j]);
                        }
                    }
                    a = 0;
                }
            }
        }
        return output.toString();
    }

    public static String coding_single_reshuffle(String input, int rows, int columns, int key_columns) {
        StringBuilder code = new StringBuilder(replace(input, rows, columns));
        StringBuilder output = new StringBuilder();
        int a = 0;
        int b = 0;
        char[][] table = new char[rows][columns];
        for (char c : code.toString().toCharArray()) {
            table[a++][b] = c;
            if (a == rows) {
                a = 0;
                b++;
                if (b == columns) {
                    sort_columns(table, rows, columns, key_columns);
                    int count = 0;
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < columns; j++) {
                            count++;
                            output.append(table[i][j]);
                            if (count == 5) {
                                output.append(" ");
                                count = 0;
                            }
                        }
                    }
                    output.append("\n");
                    b = 0;
                }
            }
        }
        return output.toString();
    }

    public static String decoding_single_reshuffle(String input, int rows, int columns, int key_columns) {
        StringBuilder code = new StringBuilder(re_replace(input));
        StringBuilder output = new StringBuilder();
        int a = 0;
        int b = 0;
        char[][] table = new char[rows][columns];
        for (char c : code.toString().toCharArray()) {
            table[a][b++] = c;
            if (b == columns) {
                b = 0;
                a++;
                if (a == rows) {
                    de_sort_columns(table, rows, columns, key_columns);
                    for (int j = 0; j < columns; j++) {
                        for (int i = 0; i < rows; i++) {
                            output.append(table[i][j]);
                        }
                    }
                    a = 0;
                }
            }
        }
        return output.toString();
    }

    public static String coding_double_reshuffle(String input, int rows, int columns, int key_columns, int key_rows) {
        StringBuilder code = new StringBuilder(replace(input, rows, columns));
        StringBuilder output = new StringBuilder();
        int a = 0;
        int b = 0;
        char[][] table = new char[rows][columns];
        for (char c : code.toString().toCharArray()) {
            table[a++][b] = c;
            if (a == rows) {
                a = 0;
                b++;
                if (b == columns) {
                    sort_columns(table, rows, columns, key_columns);
                    sort_rows(table, rows, columns, key_rows);
                    int count = 0;
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < columns; j++) {
                            count++;
                            output.append(table[i][j]);
                            if (count == 5) {
                                output.append(" ");
                                count = 0;
                            }
                        }
                    }
                    output.append("\n");
                    b = 0;
                }
            }
        }
        return output.toString();
    }

    public static String decoding_double_reshuffle(String input, int rows, int columns, int key_columns, int key_rows) {
        StringBuilder code = new StringBuilder(re_replace(input));
        StringBuilder output = new StringBuilder();
        int a = 0;
        int b = 0;
        char[][] table = new char[rows][columns];
        for (char c : code.toString().toCharArray()) {
            table[a][b++] = c;
            if (b == columns) {
                b = 0;
                a++;
                if (a == rows) {
                    de_sort_rows(table, rows, columns, key_rows);
                    de_sort_columns(table, rows, columns, key_columns);
                    for (int j = 0; j < columns; j++) {
                        for (int i = 0; i < rows; i++) {
                            output.append(table[i][j]);
                        }
                    }
                    a = 0;
                }
            }
        }
        return output.toString();
    }

    private static int how_many_tables(String input, int rows, int columns) {
        return (int) Math.ceil((double) input.length() / (rows * columns));
    }

    private static StringBuilder replace(String input, int rows, int columns) {
        int cells = how_many_tables(input, rows, columns);
        StringBuilder code = new StringBuilder(input.replace(" ", "_"));
        while (code.length() < rows * columns * cells) {
            code.append('_');
        }
        return code;
    }

    private static String re_replace(String input) {
        return input.replace("\n", "").replace(" ", "").replace("_", " ");
    }

    private static int[] keys(int input) {
        int[] c = new int[String.valueOf(input).length()];
        int cc = String.valueOf(input).length() - 1;
        while (input > 0) {
            c[cc--] = input % 10 - 1;
            input = input / 10;
        }
        return c;
    }

    private static char[][] sort_columns(char[][] table, int rows, int columns, int key_columns) {
        int[] keys = keys(key_columns);
        char[] x = new char[rows];
        boolean isSorted = false;
        int buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < columns - 1; i++) {
                if (keys[i] > keys[i + 1]) {
                    isSorted = false;
                    for (int k = 0; k < rows; k++) {
                        x[k] = table[k][i];
                        table[k][i] = table[k][i + 1];
                        table[k][i + 1] = x[k];
                    }
                    buf = keys[i];
                    keys[i] = keys[i + 1];
                    keys[i + 1] = buf;
                }
            }
        }
        return table;
    }

    private static char[][] de_sort_columns(char[][] table, int rows, int columns, int key_columns) {
        int flag;
        int[] keys = keys(key_columns);
        int[] act = new int[columns];
        for (int i = 0; i < columns; i++) {
            act[i] = i;
        }
        char[] x = new char[rows];
        boolean isSorted = false;
        int buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < columns; i++) {
                if (keys[i] != act[i]) {
                    flag = keys[i];
                    isSorted = false;
                    for (int k = 0; k < rows; k++) {
                        x[k] = table[k][i];
                        table[k][i] = table[k][flag];
                        table[k][flag] = x[k];
                    }
                    buf = act[i];
                    act[i] = act[flag];
                    act[flag] = buf;
                }
            }
        }
        return table;
    }

    private static char[][] sort_rows(char[][] table, int rows, int columns, int key_rows) {
        int[] keys = keys(key_rows);
        char[] x = new char[columns];
        boolean isSorted = false;
        int buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < rows - 1; i++) {
                if (keys[i] > keys[i + 1]) {
                    isSorted = false;
                    for (int k = 0; k < columns; k++) {
                        x[k] = table[i][k];
                        table[i][k] = table[i + 1][k];
                        table[i + 1][k] = x[k];
                    }
                    buf = keys[i];
                    keys[i] = keys[i + 1];
                    keys[i + 1] = buf;
                }
            }
        }
        return table;
    }

    private static char[][] de_sort_rows(char[][] table, int rows, int columns, int key_rows) {
        int flag;
        int[] keys = keys(key_rows);
        int[] act = new int[rows];
        for (int i = 0; i < rows; i++) {
            act[i] = i;
        }
        char[] x = new char[columns];
        boolean isSorted = false;
        int buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < rows - 1; i++) {
                if (keys[i] != act[i]) {
                    flag = keys[i];
                    isSorted = false;
                    for (int k = 0; k < columns; k++) {
                        x[k] = table[i][k];
                        table[i][k] = table[flag][k];
                        table[flag][k] = x[k];
                    }
                    buf = act[i];
                    act[i] = act[flag];
                    act[flag] = buf;
                }
            }
        }
        return table;
    }
}