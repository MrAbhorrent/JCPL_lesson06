import java.util.Arrays;

public class MainClass {

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 4, 2, 3, 4, 1, 7 };
        System.out.println("Исходный массив: " + Arrays.toString(array));
        System.out.println("Массив после выхода: " + Arrays.toString(concat4array(array)));

    }

    public static int[] concat4array(int[] source_array) throws RuntimeException{
        int j = -1;
        int org_length = source_array.length;
        // Ищем индекс последнней 4-ки
        for (int i = 0; i < org_length; i++) {
            if (source_array[i] == 4 ) {
                j = i;
            }
        }
        if (j == -1) {
            throw new RuntimeException("Исходный архив не содержит число 4");
        }
        int[] outputarray = new int[org_length - (j + 1)];
        for (int i = 0; i < org_length - (j + 1); i++) {
            outputarray[i] = source_array[j + 1+ i];
        }
        return outputarray;
    }
}
