package activities;

	
	abstract class Book {
	    String title;
	    abstract void setTitle(String s);
	    
	    String getTitle() {
	        return title;
	    }
	}
	
	class MyBook extends Book {
	    //Define abstract method
	    public void setTitle(String s) {
	        title = s;
	    }
	}