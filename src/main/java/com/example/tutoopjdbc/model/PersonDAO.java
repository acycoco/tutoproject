package com.example.tutoopjdbc.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonDAO extends BaseDAO {
    public void initPerson() {
        String sql = """
                create table person (
                id integer primary key autoincrement, 
                name string
                )
                """;
        try {
            getConn();
            smt = conn.createStatement();
            smt.executeUpdate("drop table if exists person");
            smt.executeUpdate(sql);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            close();
        }
    }

    public int insertPerson(String name) {
        int cnt = 0; //몇 번 insert됐는지
        String sql = "insert into person(name) values(?)";

        try {
            getConn();
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, name);
            cnt = psmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            close();
        }
        return cnt;
    }

    public List<Person> findAllPerson() {
        List<Person> result = new ArrayList<>();
        String sql = "select id, name from person";

        try {
            getConn();
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id"); //result라는 이름의 문자열의 결과가 있으면 가져와라
                String name = rs.getString("name"); //result라는 이름의 문자열의 결과가 있으면 가져와라
                result.add(new Person(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return result;
    }

    public Optional<Person> findByNamePerson(String pName) {
        String sql = "select id, name from person where name = ?";

        try {
            getConn();
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, pName);
            rs = psmt.executeQuery();
            if (rs.next()) { //if문으로 한개만 가져오기
                int id = rs.getInt("id"); //result라는 이름의 문자열의 결과가 있으면 가져와라
                String name = rs.getString("name"); //result라는 이름의 문자열의 결과가 있으면 가져와라
                return Optional.of(new Person(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {//finally는 어차피 반드시 실행됨 return이 되어도
            close();
        }
        return Optional.empty();
    }
}
