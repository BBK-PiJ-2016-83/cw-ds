public class FunctionalLinkedList extends LinkedList implements FunctionalList{
	
	private int x = size();
	private Object object;
	private FunctionalLinkedList list;
	
	public ReturnObject head(){
		return super.get(1);
	}
	 
	public FunctionalList rest(){
		 
		new FunctionalLinkedList();
		
		super.remove(1);
		
		for (int i = 2; i <= x; i++){
			
			object = super.get(i);
			ReturnObjectImpl cast = (ReturnObjectImpl)object;
			super.remove(i);
			
			if (i == x){
				add(cast.getData());
				return list;
			}
			super.add(i,cast.getData());
		}
		return list;
	}
	
}