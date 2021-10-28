package jp.plainblock.dl.scratch.common;

import java.util.Arrays;

public class Function {

	public static double identity(double x) {
		return x;
	}

	public static double[] identity(double[] x) {
		return x;
	}

	public static double[][] identity(double[][] x) {
		return x;
	}

	public static double step(double x) {
		return x > 0.0 ? 1.0 : 0.0;
	}

	public static double[] step(double[] x) {
		double[] y = new double[x.length];
		for (int i = 0; i < x.length; i++) {
				y[i] = step(x[i]);
		}
		return y;
	}

	public static double[][] step(double[][] x) {
		double[][] y = new double[x.length][x[0].length];
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[0].length; j++) {
				y[i][j] = step(x[i][j]);
			}
		}
		return y;
	}

	public static double sigmoid(double x) {
		return (double) 1 / (1 + Math.exp(-x));
	}

	public static double[] sigmoid(double[] x) {
		double[] y = new double[x.length];
		for (int i = 0; i < x.length; i++) {
				y[i] = sigmoid(x[i]);
		}
		return y;
	}

	public static double[][] sigmoid(double[][] x) {
		double[][] y = new double[x.length][x[0].length];
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[0].length; j++) {
				y[i][j] = sigmoid(x[i][j]);
			}
		}
		return y;
	}

	public static double relu(double x) {
		return x > 0.0 ? x : 0.0;
	}

	public static double[] relu(double[] x) {
		double[] y = new double[x.length];
		for (int i = 0; i < x.length; i++) {
				y[i] = relu(x[i]);
		}
		return y;
	}

	public static double[][] relu(double[][] x) {
		double[][] y = new double[x.length][x[0].length];
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[0].length; j++) {
				y[i][j] = relu(x[i][j]);
			}
		}
		return y;
	}

	public static double[] softmax(double[] x) {
		double[] y = new double[x.length];
		double c = Arrays.stream(x).max().getAsDouble();
		double denominator = 0.0;
		for (double d : x) {
			denominator += Math.exp(d - c);
		}
		for (int i = 0; i < x.length; i++) {
			y[i] = Math.exp(x[i] - c) / denominator;
		}
		return y;
	}

	public static double[][] softmax(double[][] x) {
		double[][] y = new double[x.length][x[0].length];
		for (int i = 0; i < x.length; i++) {
			y[i] = softmax(x[i]);
		}
		return y;
	}

}
