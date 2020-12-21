import java.util.List;

public class Day2 {
    static int counterCorrectPasswords = 0;
    static int counterCorrectPasswordsPT2 = 0;
    public static void main(String[] args) {

        List<String> values = TestUtils.readFileIntoList("./Day2.txt");

        for (String v1: values) {
            int minusIndex = v1.indexOf("-");
            int spaceIndex = v1.indexOf(" ");
            int min = Integer.parseInt(v1.substring(0, minusIndex));
            int max = Integer.parseInt(v1.substring(minusIndex + 1, spaceIndex));
            int doubleDotIndex = v1.indexOf(":");
            char mainChar = v1.charAt(doubleDotIndex - 1);
            String password = v1.substring(doubleDotIndex + 2);
            part1(mainChar, password, min, max);
            part2(mainChar, password, min-1, max-1);
        }
        System.out.println(counterCorrectPasswords);
        System.out.println(counterCorrectPasswordsPT2);
    }

    public static void part1(char mainChar, String password, int min, int max){
        int counterChar = 0;
        for (char singleChar: password.toCharArray()) {
            if (mainChar == singleChar){
                counterChar++;
            }
        }
        if (min <= counterChar && counterChar <= max){
            counterCorrectPasswords++;
        }
    }

    public static void part2(char mainChar, String password, int min, int max){
        int counterChar = 0;
        if(min < password.length() && min >= 0 && password.charAt(min) == mainChar){
            counterChar ++;
        }
        if(max < password.length() && max > min && password.charAt(max) == mainChar){
           counterChar++;
        }
        if (counterChar == 1){
            counterCorrectPasswordsPT2++;
        }
    }
}
