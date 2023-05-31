package com.example.tutoopjdbc.model;

import java.sql.SQLException;

public class CountryDAO extends BaseDAO {
    public void getCode() {
        String sql = "select code, name from country order by code, name";

        try {
            getConn();
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                System.out.print(rs.getString("code") + "\t"); //result라는 이름의 문자열의 결과가 있으면 가져와라
                System.out.println(rs.getString("name")); //result라는 이름의 문자열의 결과가 있으면 가져와라
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
}
