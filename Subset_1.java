import java.util.Arrays;

public class Subset_1 {
    public static void main(String[] args) {
        int n = 3; // 집합 원소의 개수
        int selected[] = new int[n];

        for (int i = 0; i < 2; i++) { // 사용하고 안하고
            selected[0] = i;
            for (int j = 0; j < 2; j++) {
                selected[1] = j;
                for (int k = 0; k < 2; k++) {
                    selected[2] = k;

                    System.out.println(Arrays.toString(selected));
                }
            }

        }
    }
}
