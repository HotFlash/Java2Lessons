package ru.geekbrains.lesson2;
public class HomeWorkApp {
    public static void main(String[] args) {
        String[][] stringArray1 = {{"1", "2", "d", "4", "5"}, {"1", "2", "d", "4", "5"}, {"1", "2", "3", "4", "5"}, {"1", "2", "3", "4", "5"}, {"1", "2", "3", "4", "5"}};
        String[][] stringArray2 = {{"1", "2", "3", "4"}, {"1", "2", "3", "с"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        String[][] stringArray = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};

        try {
            System.out.println(sumArray(stringArray2));
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("завершено");

    }

    public static int sumArray(String[][] array) throws MyArrayDataException {
        int value = 0;
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException();
        } else {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    try {
                        value += Integer.parseInt(array[i][j]);
                    } catch (NumberFormatException e) {
                        String a = "В ячейче [" + i + "]" + "[" + j + "] не цифра \nВы ввели: " + array[i][j];
                        throw new MyArrayDataException(a);

                    }

                }

            }

        }
        return value;
    }
}
