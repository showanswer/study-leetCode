package questionBank;

/**
 * <p>
 * E0168_ConvertToTitle
 *  Excel表列名称
 * </p>
 *
 * @author answer
 * @date 2023/6/7 21:32
 */
public class E0168_ConvertToTitle {

    /**
     * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
     * @param args
     */
    public static void main(String[] args) {
        E0168_ConvertToTitle test = new E0168_ConvertToTitle();
        System.out.println(test.convertToTitle(28));
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            int num = (columnNumber -1) % 26 +1;
            sb.append((char) (num-1 + 'A'));
            columnNumber = (columnNumber - num) / 26;
        }
        return sb.reverse().toString();
    }

}
