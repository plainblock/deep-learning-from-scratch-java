package jp.plainblock.dl.scratch.common;

public class Perceptron {

	public static int AND(int x1, int x2) {
		double[] x = {x1, x2};
		double[] w = {0.5, 0.5};
		double b = -0.7;

		double tmp = 0;
		for (int i = 0; i < x.length; i++) {
			tmp += x[i] * w[i];
		}
		tmp += b;

		return tmp <= 0 ? 0 : 1;
	}

	public static int NAND(int x1, int x2) {
		double[] x = {x1, x2};
		double[] w = {-0.5, -0.5};
		double b = 0.7;

		double tmp = 0;
		for (int i = 0; i < x.length; i++) {
			tmp += x[i] * w[i];
		}
		tmp += b;

		return tmp <= 0 ? 0 : 1;
	}

	public static int OR(int x1, int x2) {
		double[] x = {x1, x2};
		double[] w = {0.5, 0.5};
		double b = -0.2;

		double tmp = 0;
		for (int i = 0; i < x.length; i++) {
			tmp += x[i] * w[i];
		}
		tmp += b;

		return tmp <= 0 ? 0 : 1;
	}

	public static int XOR(int x1, int x2) {
		int nand = NAND(x1, x2);
		int or = OR(x1, x2);
		return AND(nand, or);
	}

}
