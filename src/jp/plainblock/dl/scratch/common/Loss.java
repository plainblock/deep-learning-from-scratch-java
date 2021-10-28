package jp.plainblock.dl.scratch.common;

public class Loss {

	public static double meanSquaredError(double[] y, double[] t) {
		double loss = 0;
		for (int i = 0; i < y.length; i++) {
			loss += (Math.pow(y[i] - t[i], 2) / 2.0);
		}
		return loss;
	}

	public static double meanSquaredError(double[][] y, double[][] t) {
		double loss = 0;
		for (int i = 0; i < y.length; i++) {
			loss += meanSquaredError(y[i], t[i]);
		}
		return loss;
	}

	public static double crossEntropyError(double[] y, double[] t) {
		double loss = 0;
		double detla = 1e-7;
		for (int i = 0; i < y.length; i++) {
			loss += -t[i] * Math.log(y[i] + detla);
		}
		return loss;
	}

	public static double crossEntropyError(double[][] y, double[][] t) {
		double loss = 0;
		for (int i = 0; i < y.length; i++) {
			loss += crossEntropyError(y[i], t[i]);
		}
		return loss / y.length;
	}
}
