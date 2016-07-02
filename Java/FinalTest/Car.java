package FinalTest;

public class Car extends Vehicle{

    public int Id;

    public int getId(){

         return(super.Id);

    }
    public void main(String[] args){

        Car car = new Car();

        car.Id = 8;

        System.out.println(car.getId());

    }

}

