package p1;

public class IndependentClassInP1Package {
    Protection o=new Protection();
    public IndependentClassInP1Package()
    {
        System.out.println("It is IndependentClassInP1Package class Constructor");
   //     System.out.println("private_a :"+o.private_a);
   // private members cannot be accessed outsid the class
        System.out.println("default_b :"+o.default_b);
        System.out.println("protected_c :"+o.protected_c);
        System.out.println("public_d :"+o.public_d);
        System.out.println("+++++++++++++++++++++++++++");
    }
}
