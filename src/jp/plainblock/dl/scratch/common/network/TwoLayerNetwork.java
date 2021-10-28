package jp.plainblock.dl.scratch.common.network;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jp.plainblock.dl.scratch.common.Matrix;
import jp.plainblock.dl.scratch.common.bean.Grads;
import jp.plainblock.dl.scratch.common.bean.Params;
import jp.plainblock.dl.scratch.common.layer.AffineLayer;
import jp.plainblock.dl.scratch.common.layer.LastLayer;
import jp.plainblock.dl.scratch.common.layer.Layer;
import jp.plainblock.dl.scratch.common.layer.ReluLayer;
import jp.plainblock.dl.scratch.common.layer.SoftmaxWithLossLayer;
import jp.plainblock.dl.scratch.common.optimizer.Optimizer;
import jp.plainblock.dl.scratch.common.util.ModelUtil;

public class TwoLayerNetwork implements Network {

	private Map<String, Params> params;
	private Map<String, Layer> layers;
	private LastLayer lastLayer;
	private Map<String, Optimizer> optimizers;
	private List<Object> forKeys;
	private List<Object> backKeys;

	public TwoLayerNetwork(int input, int hidden, int output, double weightRate) {
		Map<String, Params> params = new LinkedHashMap<>();
		params.put("Affine1", new Params(Matrix.broadcastMuli(Matrix.randn(input, hidden), weightRate), Matrix.zeros(hidden)));
		params.put("Affine2", new Params(Matrix.broadcastMuli(Matrix.randn(hidden, output), weightRate), Matrix.zeros(output)));

		Map<String, Layer> layers = new LinkedHashMap<>();
		layers.put("Affine1", new AffineLayer(this, "Affine1"));
		layers.put("Relu1", new ReluLayer());
		layers.put("Affine2", new AffineLayer(this, "Affine2"));

		LastLayer lastLayer = new SoftmaxWithLossLayer();

		this.params = params;
		this.layers = layers;
		this.lastLayer = lastLayer;

		List<Object> forKeys = Arrays.asList(params.keySet().toArray());
		List<Object> backKeys = Arrays.asList(params.keySet().toArray());
		Collections.reverse(backKeys);
		this.forKeys = forKeys;
		this.backKeys = backKeys;
	}

	public TwoLayerNetwork(String modelPath) {
		Map<String, Params> params = ModelUtil.load(modelPath);

		Map<String, Layer> layers = new LinkedHashMap<>();
		layers.put("Affine1", new AffineLayer(this, "Affine1"));
		layers.put("Relu1", new ReluLayer());
		layers.put("Affine2", new AffineLayer(this, "Affine2"));

		LastLayer lastLayer = new SoftmaxWithLossLayer();

		this.params = params;
		this.layers = layers;
		this.lastLayer = lastLayer;

		List<Object> forKeys = Arrays.asList(params.keySet().toArray());
		List<Object> backKeys = Arrays.asList(params.keySet().toArray());
		Collections.reverse(backKeys);
		this.forKeys = forKeys;
		this.backKeys = backKeys;
	}

	@Override
	public double[][] predict(double[][] x) {
		for (Layer layer : layers.values()) {
			x = layer.forward(x);
		}
		return x;
	}

	@Override
	public double loss(double[][] x, double[][] t) {
		double[][] y = predict(x);
		return lastLayer.forward(y, t);
	}

	@Override
	public double accuracy(double[][] x, double[][] t) {
		double[][] y = predict(x);
		int count = 0;
		for (int i = 0; i < x.length; i++) {
			int yi = Matrix.maxIndex(y[i]);
			int ti = Matrix.maxIndex(t[i]);
			if (yi == ti) {
				count ++;
			}
		}
		return (double) count / x.length;
	}

	@Override
	public Map<String, Grads> gradient(double[][] x, double[][] t) {
		loss(x, t);
		Map<String, Grads> grads = new HashMap<>();
		double[][] dy = lastLayer.backward(1.0);
		for (Object key : backKeys) {
			dy = layers.get(key).backward(dy);
			if (params.containsKey(key)) {
				grads.put(key.toString(), new Grads(layers.get(key).dW(), layers.get(key).db()));
			}
		}
		return grads;
	}

	@Override
	public void update(double[][] x, double[][] t) {
		Map<String, Grads> grads = gradient(x, t);
		for (Object key : forKeys) {
			optimizers.get(key).update(params.get(key).getWeight(), grads.get(key).getWeight());
			optimizers.get(key).update(params.get(key).getBias(), grads.get(key).getBias());
		}
	}

	@Override
	public double[][] getWeight(String key) {
		return params.get(key).getWeight();
	}

	@Override
	public double[] getBias(String key) {
		return params.get(key).getBias();
	}

	public Map<String, Params> getParams() {
		return params;
	}

	public Map<String, Optimizer> getOptimizers() {
		return optimizers;
	}

	public void setOptimizers(Map<String, Optimizer> optimizers) {
		this.optimizers = optimizers;
	}

	public List<Object> getForKeys() {
		return forKeys;
	}

	public List<Object> getBackKeys() {
		return backKeys;
	}

}
