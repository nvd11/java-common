package com.home.javacommon.study.lambda.doublecolon;
import com.home.javacommon.study.Example;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;


import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

@Slf4j
public class DoubleColonClient implements Example {

    @Override
    public void runApp() {
        new DoubleColonCase1().example1();
    }

    public static void main(String[] args){
        log.info("Running DoubleColonClient");
        new DoubleColonCase1().example1();
        new DoubleColonCase2().example();
        new InstanceMethodReferenceExample().example();
        new StaticMethodReferenceExample().example();
        new ConstructorMethodReferenceExample().example();
        new SubclassMethodReferenceExample().example();
        
    }

}


@Slf4j
class DoubleColonCase1{

    public void example1(){
        BinaryOperator<Integer> max = (x, y) -> Integer.max(x, y);
        BinaryOperator<Integer> max2 = Integer::max;
        log.info("max of 3 and 5 is {}", max.apply(3, 5));
        log.info("max2 of 3 and 5 is {}", max2.apply(3  , 5));
    }
}


interface Cal1{
    int cal(int a, int b);
}

interface Cal2{
    int cal(int a);
}

class Calcalss {
    //2 methods with the same name, but different parameters
    public int cal(int a, int b){
        return a + b;
    }

    public int cal(int a){
        return a * 2;
    }
}

/**
 * 
 * DoubleColon :: One of the most important features:
 *      it can inter the required parameter type , and select the right method to call, based on the code context, and the method signature.
 */
@Slf4j 
class DoubleColonCase2{
    public void example(){
        Calcalss calcalss = new Calcalss();
        Cal1 cal1o = (a, b) -> calcalss.cal(a, b);
        int c = cal1o.cal(3,4);
        log.info("3 + 4 = {}", c);
        Cal1 cal1 = calcalss::cal; //will select the   public int cal(int a, int b), as Cal1 interface's method has 2 parameters, 
        c = cal1.cal(3,4);
        log.info("3 + 4 = {}", c);

        Cal2 cal2o = (a) -> calcalss.cal(a);
        c = cal2o.cal(3);
        log.info("3 * 2 = {}", c);
        Cal2 cal2 = calcalss::cal; //will select the   public int cal(int a), as Cal2 interface's method has 1 parameter,
        c = cal2.cal(3);
        log.info("3 * 2 = {}", c);
    } 
}





//============================================instance method reference========================================

@Data 
@AllArgsConstructor 
@Builder 
@NoArgsConstructor 
@ToString 
class StudentA implements Comparable<StudentA>{
    private String name;
    private int score;

    @Override
    public int compareTo(StudentA other) {
        return other.getScore() - this.getScore(); //descending order
    }
}

interface MyComparator<T> {
    int compare(T o1, T o2);
}

@Slf4j 
class InstanceMethodReferenceExample{
    public void example(){
        StudentA student1 = new StudentA("Alice", 90);
        StudentA student2 = new StudentA("Bob", 85);
        StudentA student3 = new StudentA("Charlie", 95);

        MyComparator<StudentA> comparator1o =(a, b) -> a.compareTo(b);
        int result1 = comparator1o.compare(student1, student2);
        log.info("Comparison result1: {}", result1);

        MyComparator<StudentA> comparator1 = StudentA::compareTo; //instance method reference
        int result2 = comparator1.compare(student1, student2);
        log.info("Comparison result2: {}", result2);

        List<StudentA> students = List.of(student1, student2, student3);
        students.stream().sorted(StudentA::compareTo)
            .forEach(s -> log.info("{}: {}", s.getName(), s.getScore()));
    }
}


//====================================Static method reference========================================
@FunctionalInterface 
interface MathOperation {
   
    int operate(int a, int b);
}

@Slf4j 
class StaticMethodReferenceExample{
    public void example(){
        MathOperation addition = (a, b) -> Math.addExact(a, b);
        int result1 = addition.operate(5, 3);
        log.info("Addition result1: {}", result1);

        MathOperation addition2 = Math::addExact; //static method reference
        int result2 = addition2.operate(5, 3);
        log.info("Addition result2: {}", result2);
    }
}


//====================================Constructor method reference========================================
@Data
class Cat {
    
    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Cat() {
        this.name = "Default Cat";
        this.age = 0;
    }

    private String name;
    private int age;

}

@FunctionalInterface
interface CatServiceNoArgs{
       Cat getCat();
}

@FunctionalInterface 
interface CatServiceWithArgs{
       Cat getCat(String name, int age);
}


class ConstructorMethodReferenceExample{
    public void example(){
        CatServiceNoArgs catService1 = () -> new Cat();
        Cat cat1 = catService1.getCat();
        System.out.println("Cat1: " + cat1);

        CatServiceNoArgs catService2 = Cat::new; //constructor method reference
        Cat cat2 = catService2.getCat();
        System.out.println("Cat2: " + cat2);

        CatServiceWithArgs catService3 = (name, age) -> new Cat(name, age);
        Cat cat3 = catService3.getCat("Whiskers", 3);
        System.out.println("Cat3: " + cat3);    

        CatServiceWithArgs catService4 = Cat::new; //constructor method reference
        Cat cat4 = catService4.getCat("Mittens", 5);                                            
        System.out.println("Cat4: " + cat4);
    }
}


//===================================Subclass method reference========================================

@FunctionalInterface 
interface addService<T>{ 
    boolean add (ArrayList<T> arrlist, T t);// as we will ues add method of ArrayList, so the order of the parameters must be the same as the add method of ArrayList, which is (E e), so we put the ArrayList<T> arrlist as the first parameter, and T t as the second parameter
}

@Slf4j 
class SubclassMethodReferenceExample{
    public void example(){
        log.info("SubclassMethodReferenceExample example");
        addService<Integer> intAddService = (list, a) ->list.add(a);
        ArrayList<Integer> intList = new ArrayList<>();
        intAddService.add(intList, 5);
        log.info("Integer List: {}", intList);

        addService<String> strAddService = List::add; //instance method reference 
        ArrayList<String> strList = new ArrayList<>();
        strAddService.add(strList, "Hello");
        log.info("String List: {}", strList);


        ArrayList<Double> doubleList = new ArrayList<>();
        addService<Double> doubleAddService = ArrayList::add; //subclasses method reference
        doubleAddService.add(doubleList, 3.14);
        log.info("Double List: {}", doubleList);

        addService<Boolean> boolAddService = List::add; //subclasses method reference, pls note that List is an interface, but ArrayList is a subclass of List, so we can use List::add to refer to the add method of ArrayList
        ArrayList<Boolean> boolList = new ArrayList<>();
        boolAddService.add(boolList, true);
        log.info("Boolean List: {}", boolList);

    }

    

}