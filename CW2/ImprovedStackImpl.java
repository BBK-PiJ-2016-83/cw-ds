public class ImprovedStackImpl implements ImprovedStack{
	
	private List improvedStack;
	
	public ImprovedStackImpl(List list){
		this.improvedStack = list;
	}
	
	public boolean isEmpty(){
		return improvedStack.isEmpty();
	}
	
	public int size(){
		return improvedStack.size();
	}
	
	public void push(Object item){
		
		if(isEmpty()){
			improvedStack.add(item);
			return;
		}
		else{
			improvedStack.add(1, item);
			return;
		}
	}
	
	public ReturnObject top(){
		return improvedStack.get(1);
	}
	
	public ReturnObject pop(){
		return improvedStack.remove(1);
	}
	
	public ImprovedStack reverse(){
		
		ImprovedStackImpl reverse = new ImprovedStackImpl(improvedStack);
		
		ReturnObject object;
		int x = size();
		
		for(int i = x; i > 0; i--){

			object = improvedStack.get(i);
			ReturnObjectImpl object1 = (ReturnObjectImpl)object;
			improvedStack.remove(i);
			improvedStack.add(object1.getData());
		}
			
		return reverse;
	}
	
	public void remove(Object object){
		
		ReturnObject object1;
		ReturnObjectImpl object2 = new ReturnObjectImpl(object);
		
		if (object == null){
			object2.getReturnValue();
			return;
		}
		
		int i = 1;
		
		while (i <= size()){
			
			object1 = improvedStack.get(i);
			ReturnObjectImpl object3 = (ReturnObjectImpl)object1;
			
			if(object3.getData().equals(object2.getData())){
				
				improvedStack.remove(i);
				i--;
			}
			i++;
		}

	}
	
	public void print(){
		ReturnObject object;
		for(int i = 1; i <= size(); i++){
			object = improvedStack.get(i);
			ReturnObjectImpl cast = (ReturnObjectImpl)object; 
			System.out.println(cast.getData() + " " + cast.getIndex());
		}
	}
}