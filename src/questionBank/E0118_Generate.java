package questionBank;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * E0118_Generate
 * </p>
 *
 * @author answer
 * @date 2023/6/2 22:48
 */
public class E0118_Generate {

    public static void main(String[] args) {
        E0118_Generate test = new E0118_Generate();
        System.out.println(test.generate(5));
    }


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            res.add(0,1);
            for (int j = 1; j < res.size()-1; j++) {
                res.set(j, res.get(j) + res.get(j+1));
            }
            list.add(new ArrayList<>(res));
        }
        return list;
    }
}
