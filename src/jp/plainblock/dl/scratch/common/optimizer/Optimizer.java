package jp.plainblock.dl.scratch.common.optimizer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Optimizer {

	public enum Type {
		SGD,
		Momentum,
		AdaGrad,
		Adam,
	}

	public static Optimizer getOptimizer(Type type) {
		switch(type) {
			case SGD:
				return new SGD();
			case Momentum:
				return new Momentum();
			case AdaGrad:
				return new AdaGrad();
//			case Adam:
//				return new Adam();
			default:
				return null;
		}
	}

	public static Map<String, Optimizer> getOptimizers(Type type, List<Object> keys) {
		Map<String, Optimizer> opts = new HashMap<>();
		for (Object key : keys) {
			switch(type) {
			case SGD:
				opts.put(key.toString(), new SGD());
				break;
			case Momentum:
				opts.put(key.toString(), new Momentum());
				break;
			case AdaGrad:
				opts.put(key.toString(), new AdaGrad());
				break;
//			case Adam:
//				opts.put(key.toString(), new Adam());
//				break;
			default:
				break;
			}
		}
		return opts;
	}

	double[] update(double[] param, double[] grad);

	double[][] update(double[][] param, double[][] grad);
}
