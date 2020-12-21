import java.util.List;

public class Day1 {
    public static void main(String[] args) {

        List<String> values = TestUtils.readFileIntoList("./Day1.txt");
                int desiredResult = 2020;
                boolean found = false;
        for (String v1: values) {
            for (String v2: values) {
                int i1 = Integer.parseInt(v1);
                int i2 = Integer.parseInt(v2);
                int sum = i1 + i2;

                if (sum == desiredResult){
                    System.out.println(i1 * i2);
                    found = true;
                    break;
                }
            }
            if (found){
                break;
            }
        }
    }
}
