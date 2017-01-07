public class StackImpl extends AbstractStack{
	
	public StackImpl(List list){
		super(list);
	}
	
	public boolean isEmpty(){
		return internalList.isEmpty();
	}
	
	public int size(){
		return internalList.size();
	}
	
	public void push(Object item){
		if(isEmpty()){
			internalList.add(item);
			return;
		}
		else{
			internalList.add(1, item);
			return;
		}
	}
	
	public ReturnObject top(){
		return internalList.get(1);
	}
	
	public ReturnObject pop(){
		return internalList.remove(1);
	}
}