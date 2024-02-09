package com.example.springjdbcdemo.repository;

import com.example.springjdbcdemo.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class AlienRepository {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    public JdbcTemplate getJdbcTemplate(){
        return jdbcTemplate;
    }
    public void saveAlien(Alien alien){
        String sql = "insert into alien (aid, name, tech) values (?,?,?)";
        int row = jdbcTemplate.update(sql,alien.getAid(), alien.getName(), alien.getTech());
        System.out.println(row+ " row/s affected");
    }
    public List<Alien> findAll(){
        String sql  = "Select * from alien";

        RowMapper<Alien> mapper = new RowMapper<Alien>() {
            @Override
            public Alien mapRow(ResultSet rs, int rowNum) throws SQLException {
                Alien a = new Alien();
                a.setAid(rs.getInt("aid"));
                a.setName(rs.getString("name"));
                a.setTech(rs.getString("tech"));
                return a;
            }
        };

        List<Alien> aliens = jdbcTemplate.query(sql, mapper);
        return aliens;
    }
}
