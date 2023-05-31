package com.example.tutoopjdbc;

import com.example.tutoopjdbc.model.BaseDAO;
import com.example.tutoopjdbc.model.Person;
import com.example.tutoopjdbc.model.PersonDAO;

import java.util.List;

public class DBMain extends BaseDAO {
    public static void main(String[] args) {
        PersonDAO psersonDAO = new PersonDAO();
        psersonDAO.initPerson();
        System.out.println( psersonDAO.insertPerson("leo") );
        System.out.println( psersonDAO.insertPerson("yui") );
        List<Person> personList = psersonDAO.findAllPerson();
        System.out.println(personList);
        System.out.println(psersonDAO.findByNamePerson("bab"));
    }


}



