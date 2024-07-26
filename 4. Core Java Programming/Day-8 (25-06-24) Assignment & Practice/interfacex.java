public interface interfacex {
    // only method decl, but no body
    public void walk();
    public void talk();
    public void eat();
}

class inner implements interfacex {
    @Override
    public void walk() {
        System.out.println("walk");
    }

    @Override
    public void talk() {
        System.out.println("talk");    
    }

    @Override
    public void eat() {
        System.out.println("eat");    
    }
}