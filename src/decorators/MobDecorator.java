package decorators;

import services.Dir;
import services.EnvironmentService;
import services.MobService;

public class MobDecorator implements MobService {

	MobService delegate;
	
	
	public MobDecorator(MobService delegate ) {
		this.delegate =delegate ; 
	}
	@Override
	public EnvironmentService getEnv() {
		return delegate.getEnv();
	}

	@Override
	public int getCol() {
		return delegate.getCol();
	}

	@Override
	public int getRow() {
		return delegate.getRow();
	}

	@Override
	public Dir getFace() {
		return delegate.getFace();
	}

	public void chekInvariants() throws Exception, Error{
		
	}
	
	@Override
	public void init(EnvironmentService env, int col, int row, Dir face) throws Exception, Error {
		delegate.init(env, col, row, face);
	}

	@Override
	public void forward() throws Exception, Error {
		delegate.forward();		
	}

	@Override
	public void backward() throws Exception, Error {
		delegate.backward();
	}

	@Override
	public void turnL() throws Exception, Error {
		delegate.turnL();
	}

	@Override
	public void turnR() throws Exception, Error {
		delegate.turnR();
	}

	@Override
	public void strafeL() throws Exception, Error {
		delegate.strafeL();
	}

	@Override
	public void strafeR() throws Exception, Error {
		delegate.strafeR();
	}

	
}
