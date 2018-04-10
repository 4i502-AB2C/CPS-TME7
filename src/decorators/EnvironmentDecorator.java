package decorators;

import services.Cell;
import services.Content;
import services.EnvironmentService;
import services.MapService;


public class EnvironmentDecorator extends MapDecorator implements EnvironmentService {

	
	public EnvironmentDecorator(EnvironmentService delegate) {
		super(delegate);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EnvironmentService  getDelegate() {
		// TODO Auto-generated method stub
		return (EnvironmentService )super.getDelegate();
	}

	
	@Override
	public Content getContent(int i, int j) throws Exception {
		// TODO Auto-generated method stub
		return getDelegate().getContent(i, j);
	}
	
	
	public void CloseDoor(int x, int y) throws Exception {
		// TODO Auto-generated method stub
		getDelegate().CloseDoor(x, y);
	}

	
	

}
