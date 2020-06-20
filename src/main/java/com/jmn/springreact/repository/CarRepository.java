package com.jmn.springreact.repository;

import com.jmn.springreact.domain.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository <Car, Long> {
    //Fetch cars by brand
    List<Car> findByBrand(String brand);

    //Fetch cars by color
    List <Car> findByColor(String color);

    //Fetch cars byh year and order by price
    List <Car> findByYearOrderByPriceAsc(Integer year);

    //Fetch cars by brand and color
    List <Car> findByBrandAndColor(String brand, String color);

    //Fetch car by brand using SQL
    @Query("select c from Car c where c.brand = ?1")
    List<Car>findByBrandSql(String brand);
}
