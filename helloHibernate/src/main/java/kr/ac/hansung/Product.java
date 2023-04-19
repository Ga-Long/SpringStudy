package kr.ac.hansung;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString

@Entity //entity class -> table
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue // primary 값(id) 은 자동적으로 생성
    @Column(name="product_id")
    private int id;

    private String name;
    private int price;
    private String Description;


}
