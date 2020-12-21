import java.util.List;

public class Day1Part2 {
    public static void main(String[] args) {

        List<String> values = TestUtils.readFileIntoList("./Day1.txt");
        int desiredResult = 2020;
        boolean found = false;
        for (String v1 : values) {
            for (String v2 : values) {
                for (String v3 : values) {
                    int i1 = Integer.parseInt(v1);
                    int i2 = Integer.parseInt(v2);
                    int i3 = Integer.parseInt(v3);
                    int sum = i1 + i2 + i3;

                    if (sum == desiredResult) {
                        System.out.println(i1 * i2 * i3);
                        found = true;
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }
            if (found) {
                break;
            }
        }
    }
}
