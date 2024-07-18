class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romanNumerals = new HashMap<>();
        int romanNumeralTotal = 0;

        romanNumerals.put('I', 1);
        romanNumerals.put('V', 5);
        romanNumerals.put('X', 10);
        romanNumerals.put('L', 50);
        romanNumerals.put('C', 100);
        romanNumerals.put('D', 500);
        romanNumerals.put('M', 1000);

        for (int i = s.length() - 1; i >= 0; i--) {
            int currentRomanNumeralValue = romanNumerals.get(s.charAt(i));
            int previousRomanNumeralValue;

            romanNumeralTotal = romanNumeralTotal + currentRomanNumeralValue;
            if (i - 1 < 0) {
                return romanNumeralTotal;
            } else
                previousRomanNumeralValue = romanNumerals.get((s.charAt(i - 1)));

            if ((currentRomanNumeralValue == 5 || currentRomanNumeralValue == 10) && previousRomanNumeralValue == 1) {
                romanNumeralTotal = romanNumeralTotal - 1;
                i--;
            } else if ((currentRomanNumeralValue == 50 || currentRomanNumeralValue == 100)
                    && previousRomanNumeralValue == 10) {
                romanNumeralTotal = romanNumeralTotal - 10;
                i--;
            } else if ((currentRomanNumeralValue == 500 || currentRomanNumeralValue == 1000)
                    && previousRomanNumeralValue == 100) {
                romanNumeralTotal = romanNumeralTotal - 100;
                i--;
            }
        }
        return romanNumeralTotal;
    }

}