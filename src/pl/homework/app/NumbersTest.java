package pl.homework.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class NumbersTest {
    public static void main(String[] args) {
        File file = new File("numbers.txt");
        try {
            Scanner scanner = new Scanner(file);
            List<Integer> list = new LinkedList<>();

            Set<Integer> numbersSet = new TreeSet<>();
            while (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                list.add(num);
                numbersSet.add(num);
            }
            System.out.println(list);
            System.out.println(numbersSet);
            printStat(list, numbersSet);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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


