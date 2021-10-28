package jp.plainblock.dl.scratch.common.layer;

import jp.plainblock.dl.scratch.common.Function;
import jp.plainblock.dl.scratch.common.Loss;
import jp.plainblock.dl.scratch.common.Matrix;

public class SoftmaxWithLossLayer implements LastLayer {

	private double[][] y;
	private double[][] t;
	private double loss;

	public SoftmaxWithLossLayer() {
		// pass
	}

	@Override
	public double forward(double[][]x, double[][] t) {
		this.y = Function.softmax(x);
		this.t = t;
		this.loss = Loss.crossEntropyError(y, t);
		return loss;
	}

	@Override
	public double[][] backward(double dy) {
		double batch = t.length;
		double[][] dx = Matrix.broadcastDiv(Matrix.sub(y, t), batch);
		return dx;
	}

}
