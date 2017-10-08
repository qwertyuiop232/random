package classTest;

class RandomClass extends Methods{
	
    public RandomClass(int lenSide) {
        super(lenSide);
     }

     public double calcArea() {
        double area;
        area = Math.sqrt(3.0) / 4.0 * calcRegPolyArea();
        return area;
     }
}