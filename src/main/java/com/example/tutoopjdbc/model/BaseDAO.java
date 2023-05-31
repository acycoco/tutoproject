package com.example.tutoopjdbc.model;

import java.sql.*;

public class BaseDAO { //중복되는 코드 모아 놓은 것
    protected Connection conn = null;
    protected Statement smt = null;
    protected PreparedStatement psmt = null;
    protected ResultSet rs = null;

    protected void getConn() {
        String url = "jdbc:sqlite:world.db";
        String user ="";
        String pw= "";
        try {

            conn = DriverManager.getConnection(url);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    protected void close(){
        try {
            if (rs != null) rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (smt != null) smt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (psmt != null) psmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
