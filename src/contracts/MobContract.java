package contracts;

import services.Content;
import services.Dir;
import services.EnvirenemmentService;
import services.MobService;
import services.Cell;
import decorators.MobDecorator;

public class MobContract extends MobDecorator implements MobService {
	MobService delegate;
	
	
	public MobContract(MobService delegate ) {
		super (delegate) ; 
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
		if ((getCol()<0) || (getCol()>= getEnv().getHeight())) 
				throw new Error("debordement colonne"); 
		if ((getRow()<0) || (getRow()>= getEnv().getWidth())) 
			throw new Error("debordement row"); 
		
		if ((getEnv().getNature(getCol(), getRow())==Cell.WLL)&&
			(getEnv().getNature(getCol(), getRow())==Cell.DNC) &&
			(getEnv().getNature(getCol(), getRow())==Cell.DWC))
		
		{
			throw new Error ("cell de nature inaccessible");
		}
	}
	
	@Override
	public void init(EnvirenemmentService env, int col, int row, Dir face) {
		//precond
		if ((getCol()<0) || (getCol()>= getEnv().getHeight())) 
			throw new Error("debordement colonne"); 
		if ((getRow()<0) || (getRow()>= getEnv().getWidth())) 
			throw new Error("debordement row"); 
	
		//run
		super.init(env, col, row, face);
		
		//Inv post
		chekInvariants();
		
		//post
		if ((getCol()!=col)||(getRow()!=row)||(getEnv()!=env)||(getFace()!= face)){
			throw new Error("init faillure");
		}
		
	}

	@Override
	public void forward() {
		
		//capture 
		int r =getRow();
		int c = getCol();		
		Dir d = getFace();
		//run
		super.forward();		
		//inv post
		chekInvariants();
		//post 
		
		if (getFace() == Dir.N) 
			if ((getEnv().getNature(getCol(), getRow()+1)==Cell.EMP)||(getEnv().getNature(getCol(), getRow()+1)==Cell.DWO)&&
				(getRow()+1<getEnv().getWidth())&&
			 	(getEnv().getContent(getCol(), getRow()+1)==Content.No))
					if ((getRow()!=r+1)||(getCol()==c))
					 throw new Error ("");
			
		
	
		
	
	}

	@Override
	public void backward() {

		delegate.backward();
		
		chekInvariants();

	}

	@Override
	public void turnL() {

		delegate.turnL();
		
		chekInvariants();

	}

	@Override
	public void turnR() {

		delegate.turnR();
		
		chekInvariants();

	}

	@Override
	public void strafeL() {

		delegate.strafeL();
		
		chekInvariants();

	}

	@Override
	public void strafeR() {

		
		delegate.strafeR();
		
		
		chekInvariants();

	}

	
	
}
