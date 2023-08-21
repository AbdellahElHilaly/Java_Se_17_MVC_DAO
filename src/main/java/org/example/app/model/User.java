package org.example.app.model;


import org.example.dao.ORM.ModelMapper;


public class User extends ModelMapper<User> {

    public int id;
    public String name;
    public int age;
    public double salary;
    public boolean isMarried;



    public User(String name, int age, double salary, boolean isMarried) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.isMarried = isMarried;

    }

    public  User(){

    }

    @Override
    public User createInstance() {
        return new User();
    }


//    @Override
//    public User setData(ResultSet resultSet) throws SQLException {
//        this.id = resultSet.getInt("id");
//        this.name = resultSet.getString("name");
//        this.age = resultSet.getInt("age");
//        this.salary = resultSet.getDouble("salary");
//        this.isMarried = resultSet.getBoolean("isMarried");
//        return this;
//    }
//
//    @Override
//    public List<User> setDataList(ResultSet resultSet) throws SQLException {
//
//        while (resultSet.next()) {
//            User user = new User();
//            user.setData(resultSet);
//            this.dataList.add(user);
//        }
//        return this.dataList;
//    }

}

