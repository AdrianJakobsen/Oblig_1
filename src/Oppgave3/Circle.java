package Oppgave3;

public class Circle extends GeometricObject implements Comparable<GeometricObject>{

    private double radius;

    public Circle(Double radius){
        this.radius = radius;
    }
    public Circle(int radius){
        this.radius = radius;
    }

    @Override
    public double getArea(){
        double area = Math.PI*Math.pow(this.radius, 2);
        return area;
    }

    @Override
    public int compareTo(GeometricObject geometricObject) {
        if(getArea() > geometricObject.getArea()){
            return 1;
        }else if(getArea() < geometricObject.getArea()){
            return -1;
        }else{
            return 0;
        }
    }
}
