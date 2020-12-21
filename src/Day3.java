import java.util.List;

public class Day3 {
    public static void main(String[] args) {

        List<String> values = TestUtils.readFileIntoList("./Day3.txt");
        long trees1 = 0;
        long trees = 0;
        long trees3 = 0;
        long trees4 = 0;
        long trees5 = 0;
        long result = 0;
        trees1 = count(1, 1,values);
        trees = count(3, 1,values);
        trees3 = count(5, 1,values);
        trees4 = count(7, 1,values);
        trees5 = count(1, 2,values);

        result = trees1 * trees * trees3 * trees4 * trees5;
        System.out.println(trees1);
        System.out.println(trees);
        System.out.println(trees3);
        System.out.println(trees4);
        System.out.println(trees5);
        System.out.println("The result of the multiplication is: " + result);
    }

    public static long count(int right, int down, List<String> values){
        long trees = 0;
        for (int i = down, r = right; i < values.size(); i+=down) {
            String row = values.get(i);
            if('#' == row.charAt(r)){
                trees++;
            }
            r = (r + right) % row.length();
        }
        return  trees;
    }
}
