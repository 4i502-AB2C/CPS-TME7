package decorators;

import services.Dir;
import services.EnvirenemmentService;
import services.MobService;

public class MobDecorator implements MobService {

	MobService delegate;
	
	
	public MobDecorator(MobService delegate ) {
		this.delegate =delegate ; 
	}
	@Override
	public EnvirenemmentService getEnv() {
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

	public void chekInvariants(){
		
	}
	
	@Override
	public void init(EnvirenemmentService env, int col, int row, Dir face) {
		delegate.init(env, col, row, face);
	}

	@Override
	public void forward() {
		delegate.forward();		
	}

	@Override
	public void backward() {
		delegate.backward();
	}

	@Override
	public void turnL() {
		delegate.turnL();
	}

	@Override
	public void turnR() {
		delegate.turnR();
	}

	@Override
	public void strafeL() {
		delegate.strafeL();
	}

	@Override
	public void strafeR() {
		delegate.strafeR();
	}

	
}
