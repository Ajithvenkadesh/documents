interface GfG{
    default void display()
    {
        System.out.println("GEEKSFORGEEKS");
    }
}


interface gfg{

    public default void display()
    {
        System.out.println("geeksforgeeks");
    }
}

public class InterfaceExample implements GfG,gfg {

    public void display() {

        GfG.super.display();

        gfg.super.display();
    }

    public static void main(String args[]) {
        InterfaceExample obj = new InterfaceExample();
        obj.display();
    }
}
