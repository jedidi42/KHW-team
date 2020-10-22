package dao;

import bookstore.Models.Categorie;

public class daoCategorie {
	
	
	
	Categorie createcategorie (String cat)
	{
		Categorie cat1 = new Categorie();
		cat1.name = cat;
		return cat1;
		
		
	}

}
