class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romanNumerals = new HashMap<>();
        int romanNumeralTotal = 0;
        int romanNumeralLength = s.length();

        romanNumerals.put('I', 1);
        romanNumerals.put('V', 5);
        romanNumerals.put('X', 10);
        romanNumerals.put('L', 50);
        romanNumerals.put('C', 100);
        romanNumerals.put('D', 500);
        romanNumerals.put('M', 1000);

        for (int i = romanNumeralLength - 1; i >= 0; i--) {

            int currentRomanNumeralValue = romanNumerals.get(s.charAt(i));
            int previousRomanNumeralValue = (i - 1 >= 0) ? romanNumerals.get(s.charAt(i - 1)) : 0;

            romanNumeralTotal += currentRomanNumeralValue;
            if (currentRomanNumeralValue > previousRomanNumeralValue) {
                romanNumeralTotal -= previousRomanNumeralValue;
                i--;
            }

        }
        return romanNumeralTotal;
    }

}