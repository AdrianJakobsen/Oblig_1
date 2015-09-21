package Oppgave3;

/**
 * Created by Adrian on 20.09.2015.
 */
public class Rectangle extends GeometricObject implements Comparable<GeometricObject>{


    private double width;
    private double height;

    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea(){
        double area = (this.width*this.height);
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
