public class CodeTest {

    public static void main(String[] args) {
        int COUNT_BITS = Integer.SIZE - 3;
        System.out.println( 1 << COUNT_BITS );
        System.out.println( (1 << COUNT_BITS) - 1 );
        System.out.println( -1 << COUNT_BITS);
        System.out.println( 0 << COUNT_BITS);
    }
}
