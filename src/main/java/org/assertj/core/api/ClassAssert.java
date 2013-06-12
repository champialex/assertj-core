/*
 * Created on May 7, 2013
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 * 
 * Copyright @2010-2013 the original author or authors.
 */
package org.assertj.core.api;

import java.lang.annotation.Annotation;

import org.assertj.core.internal.Classes;

/**
 * Assertion methods for {@code Class}s.
 * <p>
 * To create a new instance of this class, invoke <code>{@link org.assertj.core.api.Assertions#assertThat(Class)}</code>
 * </p>
 * 
 * @author William Delanoue
 */
public class ClassAssert extends AbstractAssert<ClassAssert, Class<?>> {

  Classes classes = Classes.instance();

  protected ClassAssert(Class<?> actual) {
    super(actual, ClassAssert.class);
  }

  /**
   * Verifies that the actual {@code Class} is assignable from others {@code Class}
   * 
   * <pre>
   *     class Jedi {}
   *     class HumanJedi extends Jedi {}
   * 
   * Should pass if :
   *     assertThat(Jedi.class).isAssignableFrom(HumanJedi.class);
   * 
   * Should fail if :
   *     assertThat(HumanJedi.class).isAssignableFrom(Jedi.class);
   * 
   * </pre>
   * 
   * @see Class#isAssignableFrom(Class)
   * @param others {@code Class} who can be assignable from.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code Date} is {@code null}.
   * @throws NullPointerException if other {@code Date} is {@code null}.
   * @throws AssertionError if the actual {@code Date} is not before or equals to the given one.
   */
  public ClassAssert isAssignableFrom(Class<?>... others) {
    classes.assertIsAssignableFrom(info, actual, others);
    return this;
  }

  /**
   * Verifies that the actual {@code Class} is not an interface.
   * 
   * <pre>
   *     interface Jedi {}
   *     class HumanJedi implements Jedi {}
   * 
   * Should pass if :
   *     assertThat(HumanJedi.class).isNotInterface();
   * 
   * Should fail if :
   *     assertThat(Jedi.class).isNotInterface();
   * 
   * </pre>
   * 
   * @throws AssertionError if {@code actual} is {@code null}.
   * @throws AssertionError if the actual {@code Class} is not an interface.
   */
  public ClassAssert isNotInterface() {
    classes.assertIsNotInterface(info, actual);
    return this;
  }

  /**
   * Verifies that the actual {@code Class} is an interface.
   * 
   * <pre>
   *     interface Jedi {}
   *     class HumanJedi implements Jedi {}
   * 
   * Should pass if :
   *     assertThat(Jedi.class).isInterface();
   * 
   * Should fail if :
   *     assertThat(HumanJedi.class).isInterface();
   * 
   * </pre>
   * 
   * @throws AssertionError if {@code actual} is {@code null}.
   * @throws AssertionError if the actual {@code Class} is not an interface.
   */
  public ClassAssert isInterface() {
    classes.assertIsInterface(info, actual);
    return this;
  }

  /**
   * Verifies that the actual {@code Class} is an annotation.
   * 
   * <pre>
   *     public @interface Jedi {}
   * 
   * Should pass if :
   *     assertThat(Jedi.class).isAnnotation();
   *     assertThat(Override.class).isAnnotation();
   *     assertThat(Deprecated.class).isAnnotation();
   * 
   * Should fail if :
   *     assertThat(String.class).isAnnotation();
   * 
   * </pre>
   * 
   * 
   * @throws AssertionError if {@code actual} is {@code null}.
   * @throws AssertionError if the actual {@code Class} is not an annotation.
   */
  public ClassAssert isAnnotation() {
    classes.assertIsAnnotation(info, actual);
    return this;
  }

  /**
   * Verifies that the actual {@code Class} is not an annotation.
   * 
   * <pre>
   *     public @interface Jedi {}
   *
   * Should pass if :
   *     assertThat(String.class).isNotAnnotation();
   *
   * Should fail if :
   *     assertThat(Jedi.class).isNotAnnotation();
   *     assertThat(Override.class).isNotAnnotation();
   *     assertThat(Deprecated.class).isNotAnnotation();
   * 
   * </pre>
   * 
   * @throws AssertionError if {@code actual} is {@code null}.
   * @throws AssertionError if the actual {@code Class} is an annotation.
   */
  public ClassAssert isNotAnnotation() {
    classes.assertIsNotAnnotation(info, actual);
    return this;
  }

  /**
   * Verifies that the actual {@code Class} contains {@code Annotation}.
   * <pre>
   *     @Target(ElementType.TYPE)
   *     @Retention(RetentionPolicy.RUNTIME)
   *     private static @interface Forth { }
   *     @Forth
   *     class Jedi implements Jedi {}
   *
   * Should pass if :
   *     assertThat(Jedi.class).containsAnnotation(Forth.class);
   *
   * Should fail if :
   *     assertThat(Jedi.class).containsAnnotation(DarkSide.class);
   *
   * </pre>
   *
   * @param annotations annotations who must be attached to the class
   * @throws AssertionError if {@code actual} is {@code null}.
   * @throws AssertionError if the actual {@code Class} doesn't contains all of these annotations.
   */
  public ClassAssert containsAnnotation(Class<? extends Annotation>... annotations) {
    classes.assertContainsAnnotation(info, actual, annotations);
    return this;
  }

  /**
   * Verifies that the actual {@code Class} has the {@code fields}.
   * 
   * <pre>
   *     class MyClass {
   *         public String fieldOne;
   *         private String fieldTwo;
   *     }
   * 
   * This one should pass :
   *    assertThat(MyClass.class).hasFields("fieldOne");
   *
   * This one should fail :
   *    assertThat(MyClass.class).hasFields("fieldTwo");
   *    assertThat(MyClass.class).hasDeclaredFields("fieldThree");
   * </pre>
   *
   * @see Class#getField(String)
   * @param fields the fields who must be in the class.
   * @throws AssertionError if {@code actual} is {@code null}.
   * @throws AssertionError if the actual {@code Class} doesn't contains all of the field.
   */
  public ClassAssert hasFields(String... fields) {
    classes.assertHasFields(info, actual, fields);
    return this;
  }

  /**
   * Verifies that the actual {@code Class} has the declared {@code fields}.
   * 
   * <pre>
   *     class MyClass {
   *         public String fieldOne;
   *         private String fieldTwo;
   *     }
   *     
   * This one should pass :
   *    assertThat(MyClass.class).hasDeclaredFields("fieldOne", "fieldTwo");
   * 
   * This one should fail :
   *    assertThat(MyClass.class).hasDeclaredFields("fieldThree");
   * </pre>
   *
   * @see Class#getDeclaredField(String)
   * @param fields the fields who must be declared in the class.
   * @throws AssertionError if {@code actual} is {@code null}.
   * @throws AssertionError if the actual {@code Class} doesn't contains all of the field.
   */
  public ClassAssert hasDeclaredFields(String... fields) {
    classes.assertHasDeclaredFields(info, actual, fields);
    return this;
  }

}