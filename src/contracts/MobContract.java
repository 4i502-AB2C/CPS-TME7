package contracts;

import services.Content;
import services.Dir;
import services.EnvironmentService;
import services.MobService;
import services.Cell;
import decorators.MobDecorator;

public class MobContract extends MobDecorator implements MobService {
	MobService delegate;
	
	
	public MobContract(MobService delegate ) {
		super (delegate) ; 
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
		if ((getCol()<0) || (getCol()>= getEnv().getHeight())) 
				throw new Error("debordement colonne"); 
		if ((getRow()<0) || (getRow()>= getEnv().getWidth())) 
			throw new Error("debordement row"); 
		
		if ((getEnv().getCellNature(getCol(), getRow())==Cell.WLL)&&
			(getEnv().getCellNature(getCol(), getRow())==Cell.DNC) &&
			(getEnv().getCellNature(getCol(), getRow())==Cell.DWC))
		
		{
			throw new Error ("cell de nature inaccessible");
		}
	}
	
	@Override
	public void init(EnvironmentService env, int col, int row, Dir face) throws Exception, Error {
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
	public void forward() throws Exception, Error {
		
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
			if ((getEnv().getCellNature(getCol(), getRow()+1)==Cell.EMP)||(getEnv().getCellNature(getCol(), getRow()+1)==Cell.DWO)&&
				(getRow()+1<getEnv().getWidth())&&
			 	(getEnv().getContent(getCol(), getRow()+1)==Content.No))
					if ((getRow()!=r+1)||(getCol()==c))
					 throw new Error ("");
			
		
	
		
	
	}

	@Override
	public void backward() throws Exception, Error {

		delegate.backward();
		
		chekInvariants();

	}

	@Override
	public void turnL() throws Exception, Error {

		delegate.turnL();
		
		chekInvariants();

	}

	@Override
	public void turnR() throws Exception, Error {

		delegate.turnR();
		
		chekInvariants();

	}

	@Override
	public void strafeL() throws Exception, Error {

		delegate.strafeL();
		
		chekInvariants();

	}

	@Override
	public void strafeR() throws Exception, Error {

		
		delegate.strafeR();
		
		
		chekInvariants();

	}

	
	
}
