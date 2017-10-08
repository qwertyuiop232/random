package classTest;

class Methods {
	
    private int lenSide;

    public Methods(int lenSide) {
       this.lenSide = lenSide;
    }

    public double calcRegPolyArea() {
       double a;
       a = Math.pow(lenSide, 2);
       return a;
    }
 }
