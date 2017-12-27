package com.cst.stream.stathour;

import com.cst.stream.common.DateTimeUtil;
import com.cst.stream.stathour.am.AmHourTransfor;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnney.chiu
 * create on 2017/12/22 18:15
 * @Description
 */
public class Test {

    public static void main(String... main) throws IOException {
        List<CSTData> list = new ArrayList<>();
        list.add(new AmHourTransfor());
        list.add(new AmHourTransfor());
        ObjectMapper mapper = new ObjectMapper();
        String data = mapper.writerFor(new TypeReference<List<AmHourTransfor>>() {
        }).writeValueAsString(list);
        System.out.println(data);

        AmHourTransfor amHourTransfor = new AmHourTransfor();
        data=mapper.writeValueAsString(amHourTransfor);
        System.out.println(data);
        amHourTransfor = new AmHourTransfor("0000139ca0124edb90cb5a5d27ab2b43", System.currentTimeMillis() / 1000,
                1, 2, 3, 4, 5, 0, 7f, 1);
        data=mapper.writeValueAsString(amHourTransfor);
        System.out.println(data);

        AmHourTransfor newAm = mapper.readValue(data, AmHourTransfor.class);
        System.out.println(newAm);


        Dog dog = new Dog();
        dog.setName("xiaogougou");
        data = mapper.writeValueAsString(dog);
        System.out.println(data);


        System.out.println(DateTimeUtil.getDayBase(System.currentTimeMillis()));
        System.out.println(DateTimeUtil.getHourBase(System.currentTimeMillis()));
        System.out.println(DateTimeUtil.getMonthBase(System.currentTimeMillis()));
    }

    /**
     * @author Johnney.chiu
     * create on 2017/12/25 13:49
     * @Description
     */
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
    @JsonSubTypes({
            @JsonSubTypes.Type(value = Dog.class, name = "dog"),
            @JsonSubTypes.Type(value = Cat.class, name = "cat")})
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Animal {
        private String pinzhong;
    }

    /**
     * @author Johnney.chiu
     * create on 2017/12/25 13:49
     * @Description
     */
    @JsonTypeName("cat")
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Cat extends Animal {
        private String name;

    }

    /**
     * @author Johnney.chiu
     * create on 2017/12/25 13:49
     * @Description
     */
    @JsonTypeName("dog")
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Dog extends Animal {
        private String name;


    }
}


