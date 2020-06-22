public class RomanToInteger_13 {

    public int romanToInt(String s) {
        int result = 0;
        char prev = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            switch (c) {
                case 'I': result++; break;
                case 'V': result += (prev == 'I') ? 3 : 5; break;
                case 'X': result += (prev == 'I') ? 8 : 10; break;
                case 'L': result += (prev == 'X') ? 30 : 50; break;
                case 'C': result += (prev == 'X') ? 80 : 100; break;
                case 'D': result += (prev == 'C') ? 300 : 500; break;
                case 'M': result += (prev == 'C') ? 800 : 1000; break;
            }
            prev = c;
        }
        return result;
    }

}
