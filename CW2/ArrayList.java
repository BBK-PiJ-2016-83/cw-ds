public class ArrayList implements List{
	
	private int size;

	private ReturnObjectImpl [] array = new ReturnObjectImpl[1];
	
	public boolean isEmpty(){
		
		if (size() == 0){
			return true;
		}
		
		else{
			return false;
		}
	}
	
	public int size(){
		return array.length - 1;
	}
	
	public ReturnObject get(int index){
		
		ReturnObjectImpl object = new ReturnObjectImpl(new Object());
		
		if(isEmpty()){
			
			object.setErrorCode(1);
			object.getReturnValue();
			return null;
		}
		
		else if (index <= 0 || index > size()){
			
			object.setErrorCode(3);
			object.getReturnValue();
			return null;
		}
		
		for (int i = 0; i < array.length; i++){
				
			if(i == index - 1){
					
				object = array[i];
				return object;
			}
		}
		
		return null;
	}
	
	public ReturnObject remove(int index){
		
		ReturnObjectImpl object = new ReturnObjectImpl(new Object());
		
		if(isEmpty()){
			
			object.setErrorCode(1);
			object.getReturnValue();
			return null;
		}
		
		else if (index <= 0 || index > size()){
			
			object.setErrorCode(3);
			object.getReturnValue();
			return null;
		}
		
		else{
			
			for(int i = index - 1; i < array.length - 1; i++){
				
				array[i] = array [i + 1];
			}
			array = shrink(array);
			size--;
			return array [index - 1];
		}
	}
	
	public ReturnObject add(int index, Object item){
			
		ReturnObjectImpl object = new ReturnObjectImpl(item);
		
		if (item == null){
			object.getReturnValue();
			return null;
		}
		
		else if(isEmpty()){
			
			object.setErrorCode(1);
			object.getReturnValue();
			return null;
		}
		
		else if (index <= 0 || index > size()){
			
			object.setErrorCode(3);
			object.getReturnValue();
			return null;
		}
		else{
			
			array = copy(array);
			
			for(int i = array.length - 2; i > index - 1; i--){
				
				array[i] = array[i - 1];
			}
			
			array[index - 1] = object;
			size++;
			return array[index - 1];
		}
	}
	
	public ReturnObject add(Object item){
		
		ReturnObjectImpl object = new ReturnObjectImpl(item);
		
		if (item == null){
			object.getReturnValue();
			return null;
		}
		
		array = copy(array);
		array[size] = object;
		size++;
		return array[size];
	}
	
	public ReturnObjectImpl [] copy(ReturnObjectImpl [] array){
		
		ReturnObjectImpl [] copy = new ReturnObjectImpl [array.length + 1];
		
		for (int i = 0; i < array.length - 1; i++){
			
			copy[i] = array[i];
		}
		return copy;
	}
	
	public ReturnObjectImpl [] shrink(ReturnObjectImpl [] array){
		
		ReturnObjectImpl [] shrink = new ReturnObjectImpl[array.length - 1];
		
		for (int i = 0; i < array.length - 1; i++){
			
			shrink[i] = array[i];
		}
		return shrink;
	}
	
	public void print(){
		
		for(int i = 0; i < array.length - 1; i++){
			
			if(array[i] == null){
				
				System.out.println("EMPTY !!!");
			}
			else{
				System.out.println(array[i].getData() + " " + (i + 1));
			}
		}		
	}
}