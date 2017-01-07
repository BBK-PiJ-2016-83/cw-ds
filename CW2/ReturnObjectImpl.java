public class ReturnObjectImpl implements ReturnObject{
	
	private ErrorMessage error;
	private Object data;
	private ReturnObjectImpl next;
	private int index;
	private int errorCode;
	
	public ReturnObjectImpl(Object data){
		this.data = data;
		this.next = null;
		this.index = getIndex();
	}
	
	public ReturnObjectImpl(ErrorMessage error){
		System.out.println(error);
	}
	
	public boolean hasError(){
		
		if (data == null){
			this.error = ErrorMessage.INVALID_ARGUMENT;
			return true;
		}
		
		else if (getErrorCode() == 1){
			this.error = ErrorMessage.EMPTY_STRUCTURE;
			return true;
		}
		
		else if (getErrorCode() == 3){
			this.error = ErrorMessage.INDEX_OUT_OF_BOUNDS;
			return true;
		}
		else{
			return false;
		}
	}
	
	public ErrorMessage getError(){
		
		if (hasError()){
			
			if(getErrorCode() == 1){
				return error;
			}
			
			if (data == null){
				return error;
			}
			
			if (getErrorCode() == 3){
				return error;
			}
		}
		return null;
	}
	
	public Object getReturnValue(){
		
		if(!hasError()){
			ReturnObject object = new ReturnObjectImpl(data);
			return object;
		}
		else{
			ReturnObject object = new ReturnObjectImpl(error);
			return null;
		}
	}
	
	public void setIndex(int index){
		this.index = index;
	}
	
	public int getIndex(){
		return this.index;
	}
	
	public ReturnObjectImpl getNext(){
		return this.next;
	}
	
	public void setNext(ReturnObjectImpl object){
		this.next = object;
	}
	
	public void setErrorCode(int errorCode){
		this.errorCode = errorCode;
	}
	
	public int getErrorCode(){
		return errorCode;
	}
	
	public Object getData(){
		return this.data;
	}
}