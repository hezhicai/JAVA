package dao;

import domain.City;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CityDao {


    /**
     *     查询所有city
     */
    @Select("select * from city")
    List<City> findCityAll();
}
