package allTogether;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Search {
	
	public static List<String[]> search(Database db, String searchFor, List<String[]> linklist) throws SQLException
	{
		List<String[]> ll = null;
		String subString;
		String[] intoLL = new String[4];
		if(searchFor.contains("&&")) 
		{
			
		}
		else 
		{
			while(searchFor.contains(" "))
			{
				subString = searchFor.substring(0, searchFor.indexOf(" "));
				searchFor = searchFor.substring(searchFor.indexOf(" ") + 1);
				db.search(subString);
				db.getRS().first();
				intoLL[0] = db.getRS().getString("index");
				intoLL[1] = db.getRS().getString("url");
				intoLL[2] = db.getRS().getString("title");
				intoLL[3] = db.getRS().getString("description");
				ll.add(intoLL);
				intoLL = new String[4];
				while(db.getRS().next())
				{
					intoLL[0] = db.getRS().getString("index");
					intoLL[1] = db.getRS().getString("url");
					intoLL[2] = db.getRS().getString("title");
					intoLL[3] = db.getRS().getString("description");
					for(int i = 0; i < intoLL.length; i++)
					{
						String[] obj = ll.get(i);
						if(intoLL[1] == obj[1])
						{
							
						}
					}
					ll.add(intoLL);
					intoLL = new String[4];
				}
			}
			subString = searchFor;
			db.search(subString);
			db.getRS().first();
			intoLL[0] = db.getRS().getString("index");
			intoLL[1] = db.getRS().getString("url");
			intoLL[2] = db.getRS().getString("title");
			intoLL[3] = db.getRS().getString("description");
			ll.add(intoLL);
			intoLL = new String[4];
			while(db.getRS().next())
			{
				intoLL[0] = db.getRS().getString("index");
				intoLL[1] = db.getRS().getString("url");
				intoLL[2] = db.getRS().getString("title");
				intoLL[3] = db.getRS().getString("description");
				ll.add(intoLL);
				intoLL = new String[4];
			}
		}
		return ll;
	}

}
