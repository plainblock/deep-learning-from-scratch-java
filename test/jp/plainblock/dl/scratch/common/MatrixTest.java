package jp.plainblock.dl.scratch.common;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import jp.plainblock.dl.scratch.common.util.ArrayUtil;

class MatrixTest {

	@Test
	void add() {
		double[][] x1 = new double[][] {{1, 2, 3}, {4, 5, 6}};
		double[][] x2 = new double[][] {{3, 6, 9}, {8, 4, 2}};
		double[][] expect = new double[][] {{4, 8, 12}, {12, 9, 8}};
		double[][] actual = Matrix.add(x1, x2);

		System.out.println("add");
		ArrayUtil.print(actual);
		System.out.println("");
		for (int i = 0; i < actual.length; i++) {
			for (int j = 0; j < actual[0].length; j++) {
				assertEquals(expect[i][j], actual[i][j], 5e-6);
			}
		}
	}

}
