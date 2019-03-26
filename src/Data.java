public class Data {
    private String s;
    public int i;
    public Data(String s,int i) {
        this.s = s;
        this.i = i;
    }
    public String getString() {
        return s;
    }
    public String parseString(String string) {
        if(string.length() > 1) {
            return string.substring(0, 1) + " " + parseString(string.substring(1));
        }
        return string;
    }
}
