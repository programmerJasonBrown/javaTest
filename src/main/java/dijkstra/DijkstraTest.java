package dijkstra;

/**
 * @program: test1
 * @description: http://wiki.jikexueyuan.com/project/easy-learn-algorithm/dijkstra.html
 * @author: Chao Qian
 * @create: 2018-08-21 14:29
 **/
public class DijkstraTest {
    public static void main(String[] args) {
        int inf = Integer.MAX_VALUE;
        int[][] map = {
                {0, 1, 12, inf, inf, inf},
                {inf, 0, 9, 3, inf, inf},
                {inf, inf, 0, inf, 5, inf},
                {inf, inf, 4, 0, 13, 15},
                {inf, inf, inf, inf, 0, 4},
                {inf, inf, inf, inf, inf, 0}};
        int pointNum = map.length;
        int[] dis = new int[pointNum];  //使用一个dis数组记录0点到其他各个点的最小距离，后面会松弛
        for (int i = 0; i < pointNum; i++) {
            dis[i] = map[0][i];
        }

        boolean[] isComfirm = new boolean[pointNum];   //表示最短距离是否已确定

        isComfirm[0] = true;
        for (int i = 0; i < pointNum; i++) {
            int min = inf;
            int minIndex = 0;
            for (int j = 1; j < pointNum; j++) {         //找出下一个最短的点
                if (!isComfirm[j] && dis[j] < min) {
                    min = dis[j];
                    minIndex = j;
                }
            }

            isComfirm[minIndex] = true;
            for (int j = 1; j < pointNum; j++) {
                if (map[minIndex][j] < inf)
                    dis[j] = Math.min(dis[j],dis[minIndex]+map[minIndex][j]); //松弛
            }
        }


        System.out.println();

    }
}
