package com.lex.practice.reflection.base;

/**
 * @author : Lex Yu
 */
@Deprecated
public class ConcreteClass extends BaseClass implements BaseInterface {
	public int publicInt;
	private String privateString = "private string";
	protected boolean protectedBoolean;
	Object defaultObject;

	public ConcreteClass(int i) {
		this.publicInt = i;
	}

	@Override
	public void baseMethod_1() {
		System.out.println("baseMethod_1 impl.");

	}

	@Override
	public int baseMethod_2(String str) {
		System.out.println("baseMethod_2 impl.");
		return 0;
	}

	@Override
	public int method4() {
		System.out.println("Method4 overriden.");
		return 0;
	}

	public int method5(int i) {
		System.out.println("Method4 overriden.");
		return 0;
	}


	// inner classes
	public class ConcreteClassPublicClass {
	}

	private class ConcreteClassPrivateClass {
	}

	protected class ConcreteClassProtectedClass {
	}

	class ConcreteClassDefaultClass {
	}

	//member enum
	enum ConcreteClassDefaultEnum {}

	public enum ConcreteClassPublicEnum {}

	//member interface
	public interface ConcreteClassPublicInterface {
	}
}
