public class SumOfTwoIntegers_371 {

    public int getSum(int a, int b) {
        int result = a ^ b;
        int carrier = (a & b) << 1;
        if (carrier != 0) return getSum(result, carrier);
        return result;
    }

}
