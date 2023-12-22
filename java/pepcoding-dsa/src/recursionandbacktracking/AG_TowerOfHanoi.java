package recursionandbacktracking;

public class AG_TowerOfHanoi {
    public static void main(String[] args) {
        int n = 3;
        towerOfHanoi('A', 'B', 'C', n);
    }

    private static void towerOfHanoi(char a, char b, char c, int n) {
        if (n == 0) {
            return;
        }
        towerOfHanoi(a, c, b, n-1);
        System.out.println("Move Disc " + n + " from Tower " + a + " -> Tower" +  b);
        towerOfHanoi(c, b, a, n-1);
    }
}
