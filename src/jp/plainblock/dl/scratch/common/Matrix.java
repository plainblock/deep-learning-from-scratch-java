package jp.plainblock.dl.scratch.common;

import java.util.Random;

public class Matrix {

	public static double[] init(int cols, double x) {
		double[] y = new double[cols];
		for (int i = 0; i < cols; i++) {
			y[i] = (double) x;
		}
		return y;
	}

	public static double[][] init(int rows, int cols, double x) {
		double[][] y = new double[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				y[i][j] = (double) x;
			}
		}
		return y;
	}

	public static double[] zeros(int cols) {
		double[] y = new double[cols];
		for (int i = 0; i < cols; i++) {
			y[i] = (double) 0.0;
		}
		return y;
	}

	public static double[][] zeros(int rows, int cols) {
		double[][] y = new double[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				y[i][j] = (double) 0.0;
			}
		}
		return y;
	}

	public static double[][] rand(int rows, int cols) {
		Random rand = new Random();
		double[][] y = new double[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				y[i][j] = (double) rand.nextDouble();
			}
		}
		return y;
	}

	public static double[][] randn(int rows, int cols) {
		Random rand = new Random();
		double[][] y = new double[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				y[i][j] = (double) rand.nextGaussian();
			}
		}
		return y;
	}

	public static double[] add(double[] x1, double[] x2) {
		double[] y = new double[x1.length];
		for (int i = 0; i < x1.length; i++) {
			y[i] = (double) x1[i] + (double) x2[i];
		}
		return y;
	}

	public static double[][] add(double[][] x1, double[][] x2) {
		double[][] y = new double[x1.length][x1[0].length];
		for (int i = 0; i < x1.length; i++) {
			for (int j = 0; j < x1[0].length; j++) {
				y[i][j] = (double) x1[i][j] + (double) x2[i][j];
			}
		}
		return y;
	}

	public static double[] addi(double[] x1, double[] x2) {
		for (int i = 0; i < x1.length; i++) {
			x1[i] += (double) x2[i];
		}
		return x1;
	}

	public static double[][] addi(double[][] x1, double[][] x2) {
		for (int i = 0; i < x1.length; i++) {
			for (int j = 0; j < x1[0].length; j++) {
				x1[i][j] += (double) x2[i][j];
			}
		}
		return x1;
	}

	public static double[] sub(double[] x1, double[] x2) {
		double[] y = new double[x1.length];
		for (int i = 0; i < x1.length; i++) {
			y[i] = (double) x1[i] - (double) x2[i];
		}
		return y;
	}

	public static double[][] sub(double[][] x1, double[][] x2) {
		double[][] y = new double[x1.length][x1[0].length];
		for (int i = 0; i < x1.length; i++) {
			for (int j = 0; j < x1[0].length; j++) {
				y[i][j] = (double) x1[i][j] - (double) x2[i][j];
			}
		}
		return y;
	}

	public static double[] subi(double[] x1, double[] x2) {
		for (int i = 0; i < x1.length; i++) {
			x1[i] -= (double) x2[i];
		}
		return x1;
	}

	public static double[][] subi(double[][] x1, double[][] x2) {
		for (int i = 0; i < x1.length; i++) {
			for (int j = 0; j < x1[0].length; j++) {
				x1[i][j] -= (double) x2[i][j];
			}
		}
		return x1;
	}

	public static double[] mul(double[] x1, double[] x2) {
		double[] y = new double[x1.length];
		for (int i = 0; i < x1.length; i++) {
			y[i] = (double) x1[i] * (double) x2[i];
		}
		return y;
	}

	public static double[][] mul(double[][] x1, double[][] x2) {
		double[][] y = new double[x1.length][x1[0].length];
		for (int i = 0; i < x1.length; i++) {
			for (int j = 0; j < x1[0].length; j++) {
				y[i][j] = (double) x1[i][j] * (double) x2[i][j];
			}
		}
		return y;
	}

	public static double[] muli(double[] x1, double[] x2) {
		for (int i = 0; i < x1.length; i++) {
			x1[i] *= (double) x2[i];
		}
		return x1;
	}

	public static double[][] muli(double[][] x1, double[][] x2) {
		for (int i = 0; i < x1.length; i++) {
			for (int j = 0; j < x1[0].length; j++) {
				x1[i][j] *= (double) x2[i][j];
			}
		}
		return x1;
	}

	public static double[] div(double[] x1, double[] x2) {
		double[] y = new double[x1.length];
		for (int i = 0; i < x1.length; i++) {
			y[i] = (double) x1[i] / (double) x2[i];
		}
		return y;
	}

	public static double[][] div(double[][] x1, double[][] x2) {
		double[][] y = new double[x1.length][x1[0].length];
		for (int i = 0; i < x1.length; i++) {
			for (int j = 0; j < x1[0].length; j++) {
				y[i][j] = (double) x1[i][j] / (double) x2[i][j];
			}
		}
		return y;
	}

	public static double[] divi(double[] x1, double[] x2) {
		for (int i = 0; i < x1.length; i++) {
			x1[i] /= (double) x2[i];
		}
		return x1;
	}

	public static double[][] divi(double[][] x1, double[][] x2) {
		for (int i = 0; i < x1.length; i++) {
			for (int j = 0; j < x1[0].length; j++) {
				x1[i][j] /= (double) x2[i][j];
			}
		}
		return x1;
	}

	public static double[] pow(double[] x, double index) {
		double[] y = x;
		for (int i = 0; i < x.length; i++) {
			y[i] = Math.pow(x[i], index);
		}
		return y;
	}

	public static double[][] pow(double[][] x, double index) {
		double[][] y = x;
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[0].length; j++) {
				y[i][j] = Math.pow(x[i][j], index);
			}
		}
		return y;
	}

	public static double[] powi(double[] x, double index) {
		for (int i = 0; i < x.length; i++) {
			x[i] = Math.pow(x[i], index);
		}
		return x;
	}

	public static double[][] powi(double[][] x, double index) {
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[0].length; j++) {
				x[i][j] = Math.pow(x[i][j], index);
			}
		}
		return x;
	}

	public static double[][] dot(double[][] x1, double[][] x2) {
		double[][] y = new double[x1.length][x2[0].length];
		for (int i = 0; i < x1.length; i++) {
			for (int j = 0; j < x2[0].length; j++) {
				for (int k = 0; k < x2.length; k++) {
					y[i][j] += (double) x1[i][k] * (double) x2[k][j];
				}
			}
		}
		return y;
	}

	public static double[] broadcastAdd(double[] x1, double x2) {
		double[] y = new double[x1.length];
		for (int i = 0; i < x1.length; i++) {
			y[i] = (double) x1[i] + (double) x2;
		}
		return y;
	}

	public static double[][] broadcastAdd(double[][] x1, double x2) {
		double[][] y = new double[x1.length][x1[0].length];
		for (int i = 0; i < x1.length; i++) {
			for (int j = 0; j < x1[0].length; j++) {
				y[i][j] = (double) x1[i][j] + (double) x2;
			}
		}
		return y;
	}

	public static double[][] broadcastAdd(double[][] x1, double[] x2) {
		double[][] y = new double[x1.length][x1[0].length];
		for (int i = 0; i < x1.length; i++) {
			for (int j = 0; j < x1[0].length; j++) {
				y[i][j] = (double) x1[i][j] + (double) x2[j];
			}
		}
		return y;
	}

	public static double[] broadcastAddi(double[] x1, double x2) {
		for (int i = 0; i < x1.length; i++) {
			x1[i] += (double) x2;
		}
		return x1;
	}

	public static double[][] broadcastAddi(double[][] x1, double x2) {
		for (int i = 0; i < x1.length; i++) {
			for (int j = 0; j < x1[0].length; j++) {
				x1[i][j] += (double) x2;
			}
		}
		return x1;
	}

	public static double[][] broadcastAddi(double[][] x1, double[] x2) {
		for (int i = 0; i < x1.length; i++) {
			for (int j = 0; j < x1[0].length; j++) {
				x1[i][j] += (double) x2[j];
			}
		}
		return x1;
	}

	public static double[] broadcastSub(double[] x1, double x2) {
		double[] y = new double[x1.length];
		for (int i = 0; i < x1.length; i++) {
			y[i] = (double) x1[i] - (double) x2;
		}
		return y;
	}

	public static double[][] broadcastSub(double[][] x1, double x2) {
		double[][] y = new double[x1.length][x1[0].length];
		for (int i = 0; i < x1.length; i++) {
			for (int j = 0; j < x1[0].length; j++) {
				y[i][j] = (double) x1[i][j] - (double) x2;
			}
		}
		return y;
	}

	public static double[][] broadcastSub(double[][] x1, double[] x2) {
		double[][] y = new double[x1.length][x1[0].length];
		for (int i = 0; i < x1.length; i++) {
			for (int j = 0; j < x1[0].length; j++) {
				y[i][j] = (double) x1[i][j] - (double) x2[j];
			}
		}
		return y;
	}

	public static double[] broadcastSubi(double[] x1, double x2) {
		for (int i = 0; i < x1.length; i++) {
			x1[i] -= (double) x2;
		}
		return x1;
	}

	public static double[][] broadcastSubi(double[][] x1, double x2) {
		for (int i = 0; i < x1.length; i++) {
			for (int j = 0; j < x1[0].length; j++) {
				x1[i][j] -= (double) x2;
			}
		}
		return x1;
	}

	public static double[][] broadcastSubi(double[][] x1, double[] x2) {
		for (int i = 0; i < x1.length; i++) {
			for (int j = 0; j < x1[0].length; j++) {
				x1[i][j] -= (double) x2[j];
			}
		}
		return x1;
	}

	public static double[] broadcastRsub(double x1, double[] x2) {
		double[] y = new double[x2.length];
		for (int i = 0; i < x2.length; i++) {
			y[i] = (double) x1 - (double) x2[i];
		}
		return y;
	}

	public static double[][] broadcastRsub(double x1, double[][] x2) {
		double[][] y = new double[x2.length][x2[0].length];
		for (int i = 0; i < x2.length; i++) {
			for (int j = 0; j < x2[0].length; j++) {
				y[i][j] = (double) x1 - (double) x2[i][j];
			}
		}
		return y;
	}

	public static double[][] broadcastRsub(double x1[], double[][] x2) {
		double[][] y = new double[x2.length][x2[0].length];
		for (int i = 0; i < x2.length; i++) {
			for (int j = 0; j < x2[0].length; j++) {
				y[i][j] = (double) x1[j] - (double) x2[i][j];
			}
		}
		return y;
	}

	public static double[] broadcastRsubi(double x1, double[] x2) {
		for (int i = 0; i < x2.length; i++) {
			x2[i] = (double) x1 - (double) x2[i];
		}
		return x2;
	}

	public static double[][] broadcastRsubi(double x1, double[][] x2) {
		for (int i = 0; i < x2.length; i++) {
			for (int j = 0; j < x2[0].length; j++) {
				x2[i][j] = (double) x1 - (double) x2[i][j];
			}
		}
		return x2;
	}

	public static double[][] broadcastRsubi(double x1[], double[][] x2) {
		for (int i = 0; i < x2.length; i++) {
			for (int j = 0; j < x2[0].length; j++) {
				x2[i][j] = (double) x1[j] - (double) x2[i][j];
			}
		}
		return x2;
	}

	public static double[] broadcastMul(double[] x1, double x2) {
		double[] y = new double[x1.length];
		for (int i = 0; i < x1.length; i++) {
			y[i] = (double) x1[i] * (double) x2;
		}
		return y;
	}

	public static double[][] broadcastMul(double[][] x1, double x2) {
		double[][] y = new double[x1.length][x1[0].length];
		for (int i = 0; i < x1.length; i++) {
			for (int j = 0; j < x1[0].length; j++) {
				y[i][j] = (double) x1[i][j] * (double) x2;
			}
		}
		return y;
	}

	public static double[][] broadcastMul(double[][] x1, double[] x2) {
		double[][] y = new double[x1.length][x1[0].length];
		for (int i = 0; i < x1.length; i++) {
			for (int j = 0; j < x1[0].length; j++) {
				y[i][j] = (double) x1[i][j] * (double) x2[j];
			}
		}
		return y;
	}

	public static double[] broadcastMuli(double[] x1, double x2) {
		for (int i = 0; i < x1.length; i++) {
			x1[i] *= (double) x2;
		}
		return x1;
	}

	public static double[][] broadcastMuli(double[][] x1, double x2) {
		for (int i = 0; i < x1.length; i++) {
			for (int j = 0; j < x1[0].length; j++) {
				x1[i][j] *= (double) x2;
			}
		}
		return x1;
	}

	public static double[][] broadcastMuli(double[][] x1, double[] x2) {
		for (int i = 0; i < x1.length; i++) {
			for (int j = 0; j < x1[0].length; j++) {
				x1[i][j] *= (double) x2[j];
			}
		}
		return x1;
	}

	public static double[] broadcastDiv(double[] x1, double x2) {
		double[] y = new double[x1.length];
		for (int i = 0; i < x1.length; i++) {
			y[i] = (double) x1[i] / (double) x2;
		}
		return y;
	}

	public static double[][] broadcastDiv(double[][] x1, double x2) {
		double[][] y = new double[x1.length][x1[0].length];
		for (int i = 0; i < x1.length; i++) {
			for (int j = 0; j < x1[0].length; j++) {
				y[i][j] = (double) x1[i][j] / (double) x2;
			}
		}
		return y;
	}

	public static double[][] broadcastDiv(double[][] x1, double[] x2) {
		double[][] y = new double[x1.length][x1[0].length];
		for (int i = 0; i < x1.length; i++) {
			for (int j = 0; j < x1[0].length; j++) {
				y[i][j] = (double) x1[i][j] / (double) x2[j];
			}
		}
		return y;
	}

	public static double[] broadcastDivi(double[] x1, double x2) {
		for (int i = 0; i < x1.length; i++) {
			x1[i] /= (double) x2;
		}
		return x1;
	}

	public static double[][] broadcastDivi(double[][] x1, double x2) {
		for (int i = 0; i < x1.length; i++) {
			for (int j = 0; j < x1[0].length; j++) {
				x1[i][j] /= (double) x2;
			}
		}
		return x1;
	}

	public static double[][] broadcastDivi(double[][] x1, double[] x2) {
		for (int i = 0; i < x1.length; i++) {
			for (int j = 0; j < x1[0].length; j++) {
				x1[i][j] /= (double) x2[j];
			}
		}
		return x1;
	}

	public static double[] broadcastRdiv(double x1, double[] x2) {
		double[] y = new double[x2.length];
		for (int i = 0; i < x2.length; i++) {
			y[i] = (double) x1 / (double) x2[i];
		}
		return y;
	}

	public static double[][] broadcastRdiv(double x1, double[][] x2) {
		double[][] y = new double[x2.length][x2[0].length];
		for (int i = 0; i < x2.length; i++) {
			for (int j = 0; j < x2[0].length; j++) {
				y[i][j] = (double) x1 / (double) x2[i][j];
			}
		}
		return y;
	}

	public static double[][] broadcastRdiv(double x1[], double[][] x2) {
		double[][] y = new double[x2.length][x2[0].length];
		for (int i = 0; i < x2.length; i++) {
			for (int j = 0; j < x2[0].length; j++) {
				y[i][j] = (double) x1[j] / (double) x2[i][j];
			}
		}
		return y;
	}

	public static double[] broadcastRdivi(double x1, double[] x2) {
		for (int i = 0; i < x2.length; i++) {
			x2[i] = (double) x1 / (double) x2[i];
		}
		return x2;
	}

	public static double[][] broadcastRdivi(double x1, double[][] x2) {
		for (int i = 0; i < x2.length; i++) {
			for (int j = 0; j < x2[0].length; j++) {
				x2[i][j] = (double) x1 / (double) x2[i][j];
			}
		}
		return x2;
	}

	public static double[][] broadcastRdivi(double x1[], double[][] x2) {
		for (int i = 0; i < x2.length; i++) {
			for (int j = 0; j < x2[0].length; j++) {
				x2[i][j] = (double) x1[j] / (double) x2[i][j];
			}
		}
		return x2;
	}

	public static double[][] transpose(double[][] x) {
		double[][] xt = new double[x[0].length][x.length];
		for (int i = 0; i < x[0].length; i++) {
			for (int j = 0; j < x.length; j++) {
				xt[i][j] = (double) x[j][i];
			}
		}
		return xt;
	}

	public static double[] aggregate(double[][] x) {
		double[] y = new double[x[0].length];
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[0].length; j++) {
				y[j] += (double) x[i][j];
			}
		}
		return y;
	}

	public static boolean[][] bool(double[][] x) {
		return bool(x, 0);
	}

	public static boolean[][] bool(double[][] x, double target) {
		boolean[][] mask = new boolean[x.length][x[0].length];
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[0].length; j++) {
				if (x[i][j] <= target) {
					mask[i][j] = true;
				} else {
					mask[i][j] = false;
				}
			}
		}
		return mask;
	}

	public static double[][] mask(double[][] x, boolean[][] mask) {
		double[][] y = new double[x.length][x[0].length];
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[0].length; j++) {
				if (mask[i][j]) {
					y[i][j] = 0;
				} else {
					y[i][j] = (double) x[i][j];
				}
			}
		}
		return y;
	}

	public static double maxValue(double[] x) {
		double value = Double.MIN_VALUE;
		for (int i = 0; i < x.length; i++) {
			value = (double) Math.max(value, x[i]);
		}
		return value;
	}

	public static int maxIndex(double[] x) {
		double value = Double.MIN_VALUE;
		int index = 0;
		for (int i = 0; i < x.length; i++) {
			if (value < x[i]) {
				value = x[i];
				index = i;
			}
		}
		return index;
	}

	public static double minValue(double[] x) {
		double value = Double.MAX_VALUE;
		for (int i = 0; i < x.length; i++) {
			value = (double) Math.min(value, x[i]);
		}
		return value;
	}

	public static int minIndex(double[] x) {
		double value = Double.MAX_VALUE;
		int index = 0;
		for (int i = 0; i < x.length; i++) {
			if (value > x[i]) {
				value = x[i];
				index = i;
			}
		}
		return index;
	}
}
