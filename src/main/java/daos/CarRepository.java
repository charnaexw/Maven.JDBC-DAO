package daos;

import models.Car;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarRepository implements Repo{
    private Connection connection;

    public CarRepository(Connection connection){
        this.connection=connection;
    }
    @Override
    public Connection getConnection() {
        return connection;
    }

    public void create(Car car){
        executeStatement(
                String.format(new StringBuilder()
                .append("INSERT INTO automobiles.carTable(")
                .append("id, make, model, color, vin) ")
                .append("VALUES (%s, '%s', '%s', '%s', %s;")
                .toString(),
                car.getId(),
                car.getMake(),
                car.getModel(),
                car.getColor(),
                car.getVin()));
    }

    public List<Car> readAll(){
        ResultSet resultSet =executeQuery(String.format("Select * FROM automobiles.carTable WHERE id=%s"));
        List<Car> list = new ArrayList<>();
        try {
            while(resultSet.next()) {
                String id = resultSet.getString(1);
                String make = resultSet.getString(2);
                String model = resultSet.getString(3);
                String color = resultSet.getString(4);
                String vin = resultSet.getString(5);
                list.add(new Car(
                        Long.parseLong(id),
                        make,
                        model,
                        color,
                        Long.parseLong(vin)));
            }
        }catch (SQLException throwables){
            throw new RuntimeException(throwables);
        }
        return list;
    }
    public Car read(Long carId){
        return readAll()
                .stream()
                .filter(car -> car.getId().equals(carId))
                .findAny()
                .get();
    }

    public void update(Long id, Car newCarData){

    }

    public void delete(Long id){

    }

    public void delete(Car car){

    }



}