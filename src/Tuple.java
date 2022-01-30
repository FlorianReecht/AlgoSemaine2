public class Tuple {
    public  int _a;
    public int _b;

    public Tuple(int a,int b){
        _a=a;
        _b=b;
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "quotient =" + _a +
                ", reste=" + _b +
                '}';
    }
}
