package com.example.aop.flightsapp.dao;

import com.example.aop.flightsapp.domain.Passenger;
import com.example.aop.flightsapp.exception.CountryDoesNotExistException;
import com.example.aop.flightsapp.exception.PassengerDoesNotExistException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class PassengerDaoImpl implements PassengerDao {

    // map of the passengers that have already been created
    private static Map<Integer, Passenger> passengersMap = new HashMap<>();

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Passenger> rowMapper = (resultSet, rowNum) -> {
        Passenger passenger = new Passenger();
        passenger.setName(resultSet.getString("name"));
        passenger.setCountry(resultSet.getString("country"));
        return passenger;
    };

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    private Passenger getById(int id) {
        String sql = "SELECT * FROM PASSENGERS WHERE ID = ?";
        return  jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    private void insert(Passenger passenger) {
        String sql = "INSERT INTO PASSENGERS (NAME, COUNTRY) VALUES (?,?)";
        jdbcTemplate.update(sql, new Object[]{passenger.getName()}, passenger.getCountry());
    }

    public static Map<Integer, Passenger> getPassengersMap() {
        return passengersMap;
    }

    @Override
    public Passenger getPassenger(int id) {
        if (null != passengersMap.get(id)) {
            return passengersMap.get(id);
        }
        Passenger passenger;
        try {
            passenger = getById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new PassengerDoesNotExistException(new Long(id));
        }
        return passenger;
    }

    @Override
    public void insertPassenger(Passenger passenger) {
        if (!Arrays.asList(Locale.getISOCountries()).contains(passenger.getCountry())) {
            throw new CountryDoesNotExistException(passenger.getCountry());
        }
        insert(passenger);
    }

}
