package kr.ac.hansung.cse.animals;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

//@AllArgsConstructor
public class PetOwner {

    @Autowired //wiring by type
    @Qualifier("qf_cat")
    public AnimalType animal; //의존성 주입을 해줘야함

    public void play(){
        animal.sound();
    }
}
