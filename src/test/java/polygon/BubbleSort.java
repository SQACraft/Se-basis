package polygon;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int m[] = new int[] {5, 2, 3, 1, 4};

        int i = 0;

        for (int k = 0; k < m.length; k++) {

            i=0;
            while (i < m.length -1) {
                if (m[i] > m[i+1]) {
                    int q;
                    q = m[i];
                    m[i] = m[i+1];
                    m[i+1] = q;
                }
                i++;
                System.out.println(Arrays.toString(m));
            }
        }
    }
}
