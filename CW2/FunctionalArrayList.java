public class FunctionalArrayList extends ArrayList implements FunctionalList{
		
	private int x = size();
	private Object object;
	
	public ReturnObject head(){
		return super.get(1);
	}
	
	public FunctionalList rest(){
		
		FunctionalArrayList list = new FunctionalArrayList();
		
		super.remove(1);
		
		for (int i = 2; i <= x; i++){
			
			object = super.get(i);
			ReturnObjectImpl cast = (ReturnObjectImpl)object;
			super.remove(i);
			
			if (i == x){
				super.add(cast.getData());
				return list;
			}
			super.add(i,cast.getData());
		}
		return list;
	}
}