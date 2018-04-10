package contracts;

import decorators.EnvironmentDecorator;
import services.Cell;
import services.Content;
import services.EnvironmentService;

public class EnvironmentContract extends EnvironmentDecorator{

	public EnvironmentContract(EnvironmentService delegate) {
		super(delegate);
		// TODO Auto-generated constructor stub
	}
	
	public void checkInvariant() {
		
	}

	
	public void CloseDoor(int x, int y) throws Exception {
		// TODO Auto-generated method stub
		
		// \pre CellContent(x,y) =No
		if(! (getContent(x,y)==Content.No )) {
			throw new Exception("pre CellContent(x,y) =No");
		}
		super.CloseDoor(x, y);
		
		
	}

	@Override
	public Content getContent(int i, int j) throws Exception {
		// TODO Auto-generated method stub
		return super.getContent(i, j);
	}

}
