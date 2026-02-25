package pojo;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;

@Data
public class Pet {

    public void pet(){};

    public  Pet(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    private Integer id;
    private String name;

}
