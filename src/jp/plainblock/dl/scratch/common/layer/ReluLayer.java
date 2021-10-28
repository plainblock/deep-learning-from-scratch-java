package jp.plainblock.dl.scratch.common.layer;

import jp.plainblock.dl.scratch.common.Function;
import jp.plainblock.dl.scratch.common.Matrix;

public class ReluLayer implements Layer {

	private boolean[][] mask;

	public ReluLayer() {
		// pass
	}

	@Override
	public double[][] forward(double[][] x) {
		this.mask = Matrix.bool(x);
		double[][] y = Function.relu(x);
		return y;
	}

	@Override
	public double[][] backward(double[][] dy) {
		double[][] dx = Matrix.mask(dy, mask);
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
