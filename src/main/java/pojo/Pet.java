package pojo;

import java.util.ArrayList;

public class Pet {

    public class Category{
        public int id;
        public String name;
    }

    public class Root{
        public int id;
        public Category category;
        public String name;
        public ArrayList<Object> photoUrls;
        public ArrayList<Object> tags;
        public String status;
    }
}
