public class Example extends Ease {
    public Example(int width, int height, int refreshRate) throws InterruptedException {
        super(width, height, refreshRate);
    }
    public static void main(String[] args) throws InterruptedException {
        Example e = new Example(400,400,100);
    }
    public void paint() {

    }
}
