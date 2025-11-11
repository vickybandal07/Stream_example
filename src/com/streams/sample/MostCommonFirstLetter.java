package com.streams.sample;

import com.streams.sample.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

//To find most common first letter from the given word array list
public class MostCommonFirstLetter {


    public static void main(String[] args) {

        List<Employee> employees = Employee.getEmployees();

        Optional<Map.Entry<Character, Long>> max = employees
                .stream()
                .map(e -> e.getName()
                        .charAt(0)).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
                .max(Map.Entry.comparingByValue());

        System.out.println("MostCommonFirstLetter --> " + max);
    }
}
