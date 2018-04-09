package decorators;

import services.Cell;
import services.MapService;

public class MapDecorator implements MapService{
	private final MapService delegate;

	public MapDecorator(MapService delegate) {
		this.delegate = delegate;
	}

	protected MapService getDelegate(){
		return delegate;
	}
	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return delegate.getHeight();
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return delegate.getWidth();
	}

	@Override
	public Cell getCellNature(int x, int y ) throws Exception {
		// TODO Auto-generated method stub
		return delegate.getCellNature(x,y);
	}

	@Override
	public void init(int height , int width) throws Exception {
		// TODO Auto-generated method stub
		delegate.init(height, width);
	}

	@Override
	public void OpenDoor(int x , int y ) throws Exception {
		// TODO Auto-generated method stub
		delegate.OpenDoor( x ,y);
	}

	@Override
	public void CloseDoor(int x , int y) throws Exception {
		// TODO Auto-generated method stub
		delegate.CloseDoor( x , y);
	}

	
}
