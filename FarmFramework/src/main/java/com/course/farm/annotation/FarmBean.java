package com.course.farm.annotation;

import java.lang.annotation.*;

@FarmComponent
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD})
public @interface FarmBean {
}
