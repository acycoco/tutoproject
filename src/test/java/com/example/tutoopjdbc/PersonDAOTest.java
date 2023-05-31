package com.example.tutoopjdbc;

import com.example.tutoopjdbc.model.PersonDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PersonDAOTest {

    PersonDAO personDAO = new PersonDAO();
    @BeforeEach
    void setUp() { //초기화
        personDAO.initPerson(); // 테이블 새로 생성
    }

    @Test
    void insertPerson() {
        int cnt = personDAO.insertPerson("leo");
        assertEquals(1, cnt);
    }

    @Test
    void findAllPerson() {
        personDAO.insertPerson("leo");
        personDAO.insertPerson("yui");
        assertEquals("[001 leo, 002 yui]",personDAO.findAllPerson().toString());
    }

    @Test
    void findByNamePerson() {
        String name = "leo";
        personDAO.insertPerson(name);
        assertEquals(name,personDAO.findByNamePerson(name).get().getName());//객체를 가져오고 거기서 getter
        assertNotEquals(name,personDAO.findByNamePerson("aa"));//null이 나옴
        assertEquals(Optional.empty(),personDAO.findByNamePerson("aa"));//null이 나옴

    }
}