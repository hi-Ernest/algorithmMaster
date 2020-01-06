package com.algorithm.DP.test;

import com.algorithm.DP.*;
import java.util.*;

public class DPTest {

    public static void main(String[] args) {
//        BarricadesMaze bm = new BarricadesMaze();
//        //默认都是false -> 将有障碍物设置true
//        boolean[][] grid = new boolean[8][8];
//        grid[1][2] = grid[1][6]
//                = grid[2][4]
//                = grid[3][5] = grid[3][0] = grid[3][2]
//                = grid[4][2]
//                = grid[5][3] = grid[5][4] = grid[5][6]
//                = grid[6][5] = grid[6][1] = true;
//
//        System.out.println(bm.countPathsOfMaze_dp(grid, 8, 8));

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,2));
        triangle.add(Arrays.asList(6,5,4));
        triangle.add(Arrays.asList(4,1,116,26));

        System.out.println(triangle);

        TheMinimumPathOfAtriangle tmpoa = new TheMinimumPathOfAtriangle();
        System.out.println(tmpoa.minimumtotal(triangle));

    }
}
