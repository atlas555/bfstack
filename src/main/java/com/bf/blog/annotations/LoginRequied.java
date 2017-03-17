package com.bf.blog.annotations;

import java.lang.annotation.*;

/**
 * Created by zhubin on 2017/1/14.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LoginRequied {
}
