package careplus.zsgs.target.admin;
import java.util.Iterator;
import java.util.List;

import careplus.zsgs.db.CarePlusDb;
import careplus.zsgs.dto.Receptioinist;
class DeleteReceptionsModel {

	private DeleteReceptionsView view;
	DeleteReceptionsModel(DeleteReceptionsView view)
	{
		this.view=view;
	}
	public void deleteReceptionist(int number) {
		 List<Receptioinist> list=CarePlusDb.getInstance().getReceptioinist();
		 
		 boolean found=false;
		 Iterator<Receptioinist>iterator=list.iterator();
		 while(list.iterator().hasNext())
		 {
			 Receptioinist rst= iterator.next();
			 if(number==rst.getId())
			 {
				 iterator.remove();
			 }
			 found =true;
		 }
		 
		 view.deleteReception(found);
		
		
	}
}
