package newlibrary;

public class Customer {
	
	private String name ;
	//private String ID ;
	private String phoneNumber ;
	private  String adress ;

//    private final Book[] books = new Book[3];//you can see I'm limiting them to 3 books
    
    //Constructor
    public Customer (String name, String phoneNumber2 ,String adress) 
    {
    	
    this.name= name;
    //this.ID=ID;
    this.phoneNumber=phoneNumber2;
    this.setAdress(adress);
    }
    
    public String getName() {
    	
    	return this.name ;
    }
    
    public String getPhoneNumber() {
    	return this.phoneNumber;
    }

	public void add(String name, long phoneNumber
			, String adress2) {
		// TODO Auto-generated method stub
		
	}

	
	public String getAdress() {
		return adress;
	}

	

	
	public void setAdress(String adress) {
		this.adress = adress;
	}
    
    
    }

    