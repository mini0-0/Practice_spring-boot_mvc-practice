package org.example;

import org.example.mvc.Model.User;
import org.example.mvc.annotation.Service;
import org.slf4j.Logger;
import org.example.mvc.annotation.Controller;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ReflectionTest {
    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);
    @Test
    void controllerScan() {

        Set<Class<?>> beans = getTyepesAnnotationWith(List.of(Controller.class, Service.class));


        logger.debug("beans: [{}]", beans);
    }

    @Test
    void showClass() {
        Class<User> clazz = User.class;
        logger.debug(clazz.getName());
        logger.debug("User all declared fields [{}]", Arrays.stream(clazz.getDeclaredFields()).collect(Collectors.toList()));
        logger.debug("User all declared constructors [{}]", Arrays.stream(clazz.getDeclaredConstructors()).collect(Collectors.toList()));
        logger.debug("User all declared method [{}]", Arrays.stream(clazz.getDeclaredMethods()).collect(Collectors.toList()));
    }

    @Test
    void load() throws ClassNotFoundException {
        // 방법1
        Class<User> clazz1 = User.class;

        // 방법2
        User user = new User("mini","미니");
        Class<? extends User> clazz2 = User.class;

        // 방법3
        Class<?> clazz3 = Class.forName("org.example.mvc.Model.User");

        logger.debug("clazz1: [{}]",clazz1);
        logger.debug("clazz2: [{}]",clazz2);
        logger.debug("clazz3: [{}]",clazz3);

        assertThat(clazz1==clazz2).isTrue();
        assertThat(clazz2==clazz3).isTrue();
        assertThat(clazz3==clazz1).isTrue();
    }

    private Set<Class<?>> getTyepesAnnotationWith(List<Class<? extends Annotation>> annotations){
        Reflections reflections = new Reflections("org.example");

        Set<Class<?>> beans = new HashSet<>();
        annotations.forEach(annotation -> beans.addAll(reflections.getTypesAnnotatedWith(annotation)));
        return beans;
    }


}
