package jp.plainblock.dl.scratch.common.layer;

import jp.plainblock.dl.scratch.common.Function;
import jp.plainblock.dl.scratch.common.Matrix;

public class SigmoidLayer implements Layer {

	private double[][] y;

	@Override
	public double[][] forward(double[][] x) {
		this.y = Function.sigmoid(x);
		return y;
	}

	@Override
	public double[][] backward(double[][] dy) {
		double[][] dx = Matrix.mul(dy, Matrix.mul(Matrix.broadcastRsub(1.0, y), y));
		return dx;
	}

	@Override
	public double[][] dW() {
		return null;
	}

	@Override
	public double[] db() {
		return null;
	}

}
