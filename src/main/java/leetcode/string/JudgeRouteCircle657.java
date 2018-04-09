package leetcode.string;

/**
 * @author blank
 * @Description
 * @Date 创建于 18-4-9 下午5:29
 */
public class JudgeRouteCircle657 {
    
    public boolean judgeCircle(String moves) {
        int Ucnt = 0, Dcnt = 0, Lcnt = 0, Rcnt = 0;
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'U':
                    Ucnt++;
                    break;
                case 'D':
                    Dcnt++;
                    break;
                case 'L':
                    Lcnt++;
                    break;
                case 'R':
                    Rcnt++;
                    break;
                default:
                    break;
            }
        }
        return Ucnt == Dcnt && Lcnt == Rcnt;
    }
}
