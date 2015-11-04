package jnit.session6;

// static method vs non-static method
// to call a non-static method, object is to be created
// to call a static method... ClassName.staticmethod()
// static method cannot call non-static method
// non-static method can call static methods

public class StaticMethod {
	
	int i=10;  // object owned variable(non-static variable)
	static int y=7;
	
	public void print(){ // non-static method
		System.out.println("non-static print method");
	}

	public static void test(){  // static method
		System.out.println("static method");
		
		// i=11; // cannot refer to a non-static variable from static method
	}
	public static void main(String[] args) {
		
		test(); // calling a static method
		
	//	print();        non-static method, so cannot be accessed by static method
		
		StaticMethod sm = new StaticMethod(); // creating object to call non-static method
		
		sm.print(); // calling non-static method print using object
		
		System.out.println(sm.i); // accessing non-static variable from static method using the object
		
		System.out.println(y); // can directly access static variable from static method
	}

}
