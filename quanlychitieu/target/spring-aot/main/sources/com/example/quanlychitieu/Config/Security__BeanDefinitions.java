package com.example.quanlychitieu.Config;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Bean definitions for {@link Security}.
 */
@Generated
public class Security__BeanDefinitions {
  /**
   * Get the bean definition for 'security'.
   */
  public static BeanDefinition getSecurityBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(Security.class);
    beanDefinition.setTargetType(Security.class);
    ConfigurationClassUtils.initializeConfigurationClass(Security.class);
    beanDefinition.setInstanceSupplier(Security$$SpringCGLIB$$0::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'filterChain'.
   */
  private static BeanInstanceSupplier<SecurityFilterChain> getFilterChainInstanceSupplier() {
    return BeanInstanceSupplier.<SecurityFilterChain>forFactoryMethod(Security$$SpringCGLIB$$0.class, "filterChain", HttpSecurity.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("security", Security.class).filterChain(args.get(0)));
  }

  /**
   * Get the bean definition for 'filterChain'.
   */
  public static BeanDefinition getFilterChainBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SecurityFilterChain.class);
    beanDefinition.setFactoryBeanName("security");
    beanDefinition.setInstanceSupplier(getFilterChainInstanceSupplier());
    return beanDefinition;
  }
}
