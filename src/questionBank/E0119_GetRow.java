package questionBank;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * E0119_GetRow
 * </p>
 *
 * @author answer
 * @date 2023/6/2 23:05
 */
public class E0119_GetRow {

    public static void main(String[] args) {
        E0119_GetRow test = new E0119_GetRow();
        System.out.println(test.getRow(4));
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            res.add(0, 1);
            for (int j = 1; j < res.size() - 1; j++) {
                res.set(j, res.get(j) + res.get(j + 1));
            }
        }
        return res;
    }

}
