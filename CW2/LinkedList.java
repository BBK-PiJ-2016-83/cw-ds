public class LinkedList implements List{
	
	private int size;
	private ReturnObjectImpl head = null;
	
	public boolean isEmpty(){
		
		if (size() == 0){
			return true;
		}
		
		else{
			return false;
		}
	}
	
	public int size(){
		return this.size;
	}
	
	public ReturnObject get(int index){
		
		ReturnObjectImpl object = new ReturnObjectImpl(new Object());
		
		if (isEmpty()){
			object.setErrorCode(1);
			object.getReturnValue();
			return null;
		}
		
		else if(index <= 0 || index > size()){
			head.setErrorCode(3);
			head.getReturnValue();
			return null;
		}
		
		ReturnObjectImpl current = head;
		
		while (current != null){
			
			if(current.getIndex() == index){
				return current;
			}
			
			current = current.getNext();
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
		
		else if(index <= 0 || index > size()){
			object.setErrorCode(3);
			object.getReturnValue();
			return null;
		}
		
		else if(index == 1){
			head = head.getNext();
			adjustIndex();
			size--;
			
			return head;
		}

		ReturnObjectImpl current = head;
		
		while (current.getNext() != null){
			
			if(current.getNext().getIndex() == index){
				current.setNext(current.getNext().getNext());
				size--;
				adjustIndex();
				return current;
			}
			
			current = current.getNext();
		}
		return null;
	}
	
	public ReturnObject add(int index, Object item){
			
			ReturnObjectImpl object = new ReturnObjectImpl(item);
			
			if (item == null){
				object.getReturnValue();
				return null;
			}
			
			if(index <= 0 || index > size()){
				object.setErrorCode(3);
				object.getReturnValue();
				return null;
			}
			
			if (index == 1){
				object.setNext(head);
				head = object;
				adjustIndex();
				size++;
				
				return head;
			}
			
			ReturnObjectImpl current = head;
			ReturnObjectImpl last = current.getNext();
			
			while(current != null){
				
				if(current.getNext().getIndex() == index){
					current.setNext(object);
					object.setNext(last);
					adjustIndex();
					object.setIndex(index);
					size++;
					
					return object;
				}
				current = current.getNext();
				last = current.getNext();
			}
			
			
		return null;
	}
	
	public ReturnObject add(Object item){
		
		ReturnObjectImpl object = new ReturnObjectImpl(item);
		
		if (item == null){
			object.getReturnValue();
			return null;
		}
		
		else if (isEmpty()){
			head = object;
			size++;
			adjustIndex();
			return head;
		}
		
		ReturnObjectImpl current = head;
		
		while(current.getNext() != null){
			current = current.getNext();
		}
		current.setNext(object);
		size++;
		adjustIndex();
		return object;
	}
	
	public void adjustIndex(){
		
		ReturnObjectImpl current = head;
		int index = 0;
		
		while(current != null){
			
			index++;
			current.setIndex(index);
			current = current.getNext();
		}
	}
	
	public void print(){
		
		if (isEmpty()){
			System.out.println("EMPTY");
		}
		else{
			ReturnObjectImpl current = head;
			
			while(current != null){
				System.out.println(current.getData() + " " + current.getIndex());
				current = current.getNext();
			}
		}
	}
}