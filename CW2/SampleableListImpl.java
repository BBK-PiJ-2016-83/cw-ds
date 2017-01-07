public class SampleableListImpl implements SampleableList{
	
	LinkedList list = new LinkedList();
	
	public SampleableList sample(){
		
		SampleableListImpl sample = new SampleableListImpl();
		Object object;
		
		for(int i = 2; i <= size(); i++){
			
			object = list.remove(i);
			sample.add(object);
		}
		return sample;
		
	}
	
	public ReturnObject remove(int index){
		return list.remove(index);
	}
	
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
	public ReturnObject add(Object item){
		return list.add(item);
	}
	
	public ReturnObject add(int index, Object item){
		return list.add(index, item);
	}
	
	public ReturnObject get(int index){
		return list.get(index);
	}
	
	public int size(){
		return list.size();
	}
	
	public void print(){
		list.print();
	}
}