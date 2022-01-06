public class BasicNetwork {
	Layer[] layer;
	
	public BasicNetwork(String newnet) {
		
	}
	public BasicNetwork(int[] entire) {
		layer = new Layer[entire.length - 1];
		for(int i=1; i< entire.length ; i++)
			layer[i - 1] = new Layer(entire[i], entire[i - 1]);
	}
	
	public BasicNetwork(BasicNetwork bn) {
		layer = new Layer[bn.layer.length];
		
		for(int j=0 ; j< layer.length ; j++)
			layer[j] = new Layer(bn.layer[j]);
	}
	
	public float[] output(float[] input) {
		for(int i=0 ; i< layer.length ; i++) {
			input = layer[i].allActivation(input);
		}
		
		return input;
	}
}

class Neuron {
	final double MUTATION_RATE = 0.1;
	float[] weight;
	float bias;
	float activation;
	
	public Neuron(int num) {
		weight = new float[num];
		
		for(int i=0;i< weight.length;i++)
			weight[i] = (float) ( 4 * Math.random() - 2 );
		bias = (float) (4 * Math.random() -2 );
	}
	
	public Neuron(Neuron n) {
		weight = new float[n.weight.length];
		
		for(int i=0;i< weight.length;i++) {
			if( Math.random() < MUTATION_RATE )								//mutation
				weight[i] = n.weight[i] + (float) ( 4 * Math.random() - 2 );
			else
				weight[i] = n.weight[i];
		}
		if( Math.random() < MUTATION_RATE )
			bias = n.bias + (float) ( 4 * Math.random() - 2 );
		else
			bias = n.bias;
	}
	
	public float activation(float[] act) {
		activation = 0;
		
		for(int i=0 ; i< weight.length ; i++)
			activation += weight[i] * act[i];
		
		activation += bias;
		activation = sigmoid(activation);
		
		return activation;
	}
	
	private float sigmoid(float x) {
		return x / (1 + Math.abs(x));
	}
}

class Layer {
	Neuron[] neuron;
	
	public Layer(int much,int prevneu) {
		neuron = new Neuron[much];
		for(int j=0 ; j< much ; j++)
			neuron[j] = new Neuron(prevneu);
	}
	public Layer(Layer l) {
		neuron = new Neuron[l.neuron.length];

		for(int i=0;i< neuron.length;i++)
			neuron[i] = new Neuron(l.neuron[i]);
	}
	
	public float[] allActivation(float[] actprev) {
		float[] store = new float[neuron.length];
		
		for(int k=0 ; k<neuron.length ; k++)
			store[k]= neuron[k].activation(actprev);
		
		return store;
	}
}