=========
= Heaps =
=========


public class Heap {

	private ArrayList<Integer> data = new ArrayList<>();

	public int size() {
		return this.data.size();
	}

	public void insert(int item) {
		data.add(item);
		upheapify(data.size() - 1);
	}

	private void upheapify(int ci) {
		int pi = (ci - 1) / 2;

		if (data.get(pi) > data.get(ci)) {
			swap(pi, ci);
			upheapify(pi);
		}

	}

	private void swap(int i, int j) {
		int ith = data.get(i);
		int jth = data.get(j);
		data.set(i, jth);
		data.set(j, ith);

	}

	public int remove() {
		swap(0, data.size() - 1);
		int rv = data.remove(data.size() - 1);
		downheapify(0);
		return rv;
	}
	
	
	void display(){
		System.out.println(this.data);
	}

	private void downheapify(int pi) {
		int mini = pi;
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		if (lci < this.data.size() && data.get(lci) < data.get(mini)) {
			mini = lci;
		}

		if (rci < this.data.size() && data.get(rci) < data.get(mini)) {
			mini = rci;
		}

		if (mini != pi) {
			swap(mini, pi);
			downheapify(mini);
		}
	}

	public int getmin() {
		return data.get(0);
	}
	
	public boolean isEmpty(){
		return this.size()==0;
	}

}