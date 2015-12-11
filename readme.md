Get Book //returns data about given book: Name, Author, Date of entry, Current owner
{
	"name":"String",    //the name of the book
	"author":"String"   //the author of the book
	//at least one value must be given
}


Add Book //returns whether the book was successfully added or not
{
	"name":"String",    //the name of the book
	"author":"String",  //the author of the book
	"takenBy":"String"  //the person who's currently owning the book. Null if book in not takenBy
}

Search //returns name or author (correspondingly) that is closest to given value
{
	"name":"String",    //the name of the book
	"author":"String"   //the author of the book
}