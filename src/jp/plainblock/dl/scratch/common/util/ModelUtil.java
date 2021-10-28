package jp.plainblock.dl.scratch.common.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.plainblock.dl.scratch.common.bean.Params;

public class ModelUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(ModelUtil.class);

	public static Map<String, Params> load(String path) {
		Map<String, double[][]> weights = new HashMap<>();
		Map<String, double[]> biases = new HashMap<>();
		Map<String, Params> params = new HashMap<>();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] header = line.split("\\s+");
				if (header.length == 3) {
					int dimension = Integer.parseInt(header[2]);
					double[] value = new double[dimension];
					for (int i = 0; i < dimension; i++) {
						value[i] = Double.parseDouble(br.readLine());
					}
					biases.put(header[0], value);
				} else if (header.length == 4) {
					int size = Integer.parseInt(header[2]);
					int dimension = Integer.parseInt(header[3]);
					double[][] value = new double[size][dimension];
					for (int i = 0; i < size; i++) {
						for (int j = 0; j < dimension; j++) {
							value[i][j] = Double.parseDouble(br.readLine());
						}
					}
					weights.put(header[0], value);
				} else {
					throw new IOException("Invalid format: " + line);
				}
			}
			Object[] keys = weights.keySet().toArray();
			for (Object key : keys) {
				params.put(key.toString(), new Params(weights.get(key), biases.get(key)));
			}
		} catch (IOException e) {
			LOGGER.info("error", e);
		}
		return params;
	}

	public static void save(String path, Map<String, Params> params) {
		try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path)))) {
			Object[] keys = params.keySet().toArray();
			for (Object key : keys) {
				double[][] weight = params.get(key).getWeight();
				pw.println(key.toString() + " weight " + weight.length + " " + weight[0].length);
				for (int i = 0; i < weight.length; i++) {
					for (int j = 0; j < weight[0].length; j++) {
						pw.println(weight[i][j]);
					}
				}
				double[] bias = params.get(key).getBias();
				pw.println(key.toString() + " bias " + bias.length);
				for (int i = 0; i < bias.length; i++) {
					pw.println(bias[i]);
				}
			}
		} catch (IOException e) {
			LOGGER.info("error", e);
		}
	}

}
