package polygon;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int m[] = new int[1000] ;

        for (int i=0; i< m.length;i++){
            m[i] = (int) (Math.random()*100);
        }

        // **************Сортировка пузырьком - БЕЗ Arrays.sort() **************
        long t0 = System.currentTimeMillis();
        for (int k = 0; k < m.length; k++) {

            int i=0;
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

        long t1 = System.currentTimeMillis();
        System.out.println(Arrays.toString(m));

        System.out.println((t1-t0)+ " ms без Arrays.sort()");

        // **************Сортировка С Arrays.sort() *******************
        for (int i=0; i<m.length; i++){
            m[i] = (int) (Math.random()*100);
        }
        t0 = System.currentTimeMillis();
        Arrays.sort(m);
        t1 = System.currentTimeMillis();
        System.out.println((t1-t0) + " ms  с Arrays.sort()");

    }
}
