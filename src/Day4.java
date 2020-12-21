import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day4 {
    public static void main(String[] args) {

        List<String> validPassportAttributes = TestUtils.readFileIntoList("./ValidPassportAttributes.txt");
        List<String> rows = TestUtils.readFileIntoList("./Day4.txt");
        List<Map<String, String>> structuredData = structurePassportData(rows);

        System.out.println(validPassportAttributes);
        System.out.println(structuredData.size());
        System.out.println(structuredData);

        int validPassworts = 0;

        for (Map<String, String> pass: structuredData) {
            int validAttributes = 0;
            for (String attribute: validPassportAttributes) {
                if (pass.containsKey(attribute)){
                    validAttributes++;
                }
            }
            if (validAttributes == 8 && pass.size() == 8){
                validPassworts++;
            }

        }

        System.out.println("Number of valid Passports: " + validPassworts);
    }
    public static List<String> splitRowBySpace(String row){
        return  Arrays.asList(row.split(" "));
    }

    public static Map<String, String> getPair(String keyValue){
        Map<String, String>passport = new HashMap<>();
        int doubleDotIndex = keyValue.indexOf(':');
        String key = keyValue.substring(0, doubleDotIndex);
        String value = keyValue.substring(doubleDotIndex+1);
        passport.put(key, value);
        return passport;
    }

    public static List<Map<String, String>> structurePassportData(List<String> rows){
        Map<String, String> passport = new HashMap<>();
        List<Map<String, String>> passports = new ArrayList<>();

        System.out.println(rows);

        for(String row : rows){
            if(row == null || row.trim().length() == 0){
                passports.add(passport);
                passport = new HashMap<>();
                continue;
            }
            for(String keyValue: splitRowBySpace(row)){
                passport.putAll(getPair(keyValue));
            }
        }
        passports.add(passport);
        return passports;
    }
}
