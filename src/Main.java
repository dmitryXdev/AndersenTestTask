import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        boolean flag = true;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (flag) {
                System.out.print("What algorithm do you want to perform:\n" +
                        "1. If the entered number is greater than 7.\n" +
                        "2. If the entered name matches 'John'.\n" +
                        "3. Array elements that are multiples of 3.\n" +
                        "4. Exit program.\n" +
                        "Your choice: ");

                try {
                    int choice = Integer.parseInt(reader.readLine());

                    switch (choice) {
                        case 1:
                            System.out.println("Result: " + firstAlgorithm(reader));
                            System.out.println("------------------------------------");
                            break;
                        case 2:
                            System.out.println("Result: " + secondAlgorithm(reader));
                            System.out.println("------------------------------------");
                            break;
                        case 3:
                            System.out.println("Result: " + thirdAlgorithm(reader));
                            System.out.println("------------------------------------");
                            break;
                        case 4:
                            flag = false;
                            break;
                        default:
                            throw new RuntimeException("Not valid input");
                    }
                } catch (Exception e) {
                    System.out.println("Exception: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public static String firstAlgorithm(BufferedReader reader) {
        try {
            System.out.println();
            System.out.println("------------------------------------");
            System.out.print("Enter an integer: ");
            System.out.println();
            int inputNumber = Integer.parseInt(reader.readLine());

            if(inputNumber > 7) {
                return "Hello";
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public static String secondAlgorithm(BufferedReader reader) throws IOException {
        try {
            System.out.println();
            System.out.println("------------------------------------");
            System.out.print("Enter a name: ");
            String inputLine = reader.readLine();
            System.out.println();
            if(inputLine.toLowerCase(Locale.ROOT).equals("john")) {
                return "Hello, John";
            }
            return "There is no such name";
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Integer> thirdAlgorithm(BufferedReader reader)  throws Exception {
        try {
            System.out.println();
            System.out.println("------------------------------------");
            System.out.println("Enter a sequence of integers separated by spaces (e.g. 1 2 3 4 5): ");

            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

            System.out.println();

            List<Integer> resultArray = new ArrayList<>();

            while (tokenizer.hasMoreTokens()) {
                String stringToken = tokenizer.nextToken();
                try {
                    int token = Integer.parseInt(stringToken);

                    if(token % 3 == 0) {
                        resultArray.add(token);
                    }
                } catch (Exception e) {
                    System.out.println("ERROR: " + e);

                }
            }
            return resultArray;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}