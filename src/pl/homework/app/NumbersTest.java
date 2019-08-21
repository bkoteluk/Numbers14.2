package pl.homework.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class NumbersTest {
    private static List<Integer> list = new LinkedList<>();
    private static Set<Integer> numbersSet = new TreeSet<>();

    public static void main(String[] args) {
        try {
           readNumbers();
           System.out.println(list);
           System.out.println(numbersSet);
           printStat(list, numbersSet);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());;
        }
    }

    public static void readNumbers() throws FileNotFoundException {
        File file = new File("numbers.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            list.add(num);
            numbersSet.add(num);
        }
        scanner.close();
    }

    public static void printStat(List<Integer> list, Set<Integer> set) {
        int counter = 0;
        for (Integer element: set) {
            for (int i = 0; i < list.size() ; i++) {
                if (element.equals(list.get(i))) {
                    counter ++;
                }
            }
            System.out.println(element + " - liczba występień: " + counter);
            counter = 0;
        }
    }
}


