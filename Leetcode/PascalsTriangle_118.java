import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle_118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        if (numRows == 0) return result;
        List<Integer> prevList = new ArrayList<>(1);
        prevList.add(1);
        result.add(prevList);
        for (int i = 1; i < numRows; ++i) {
            List<Integer> list = new ArrayList<>(i + 1);
            list.add(0, 1);
            for (int j = 1; j <= i >> 1; ++j)
                list.add(j, prevList.get(j - 1) + prevList.get(j));
            for (int j = (i >> 1) + 1; j < i; ++j)
                list.add(j, list.get(i - j));
            list.add(i, 1);
            result.add(list);
            prevList = list;
        }
        return result;
    }

}
