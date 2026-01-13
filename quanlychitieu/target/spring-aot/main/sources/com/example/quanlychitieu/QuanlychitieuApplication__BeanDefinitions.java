package com.example.quanlychitieu;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link QuanlychitieuApplication}.
 */
@Generated
public class QuanlychitieuApplication__BeanDefinitions {
  /**
   * Get the bean definition for 'quanlychitieuApplication'.
   */
  public static BeanDefinition getQuanlychitieuApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(QuanlychitieuApplication.class);
    beanDefinition.setInstanceSupplier(QuanlychitieuApplication::new);
    return beanDefinition;
  }
}
