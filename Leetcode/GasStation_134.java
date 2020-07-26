public class GasStation_134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int gasSum = 0, costSum = 0;
        for (int i = 0; i < length; ++i) {
            gasSum += gas[i];
            costSum += cost[i];
        }
        if (gasSum < costSum) return -1;

        int[] accVal = new int[length];
        accVal[0] = gas[0] - cost[0];
        int min = accVal[0], minIndex = 0;

        for (int i = 1; i < length; ++i) {
            accVal[i] = accVal[i - 1] + (gas[i] - cost[i]);
            if (accVal[i] < min) {
                min = accVal[i];
                minIndex = i;
            }
        }

        return (minIndex + 1) % length;
    }

}
