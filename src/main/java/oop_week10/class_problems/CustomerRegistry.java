package main.java.oop_week10.class_problems;

import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

public class CustomerRegistry {
    public static class Customer {
        private String id;
        private String name;

        public Customer(String id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Customer customer = (Customer) o;
            return Objects.equals(id, customer.id) && Objects.equals(name, customer.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    private Set<Customer> customers = new HashSet<>();

    public boolean addCustomer(String id, String name) {
        Customer c = new Customer(id, name);
        return customers.add(c);
    }

    public int getUniqueCount() {
        return customers.size();
    }

    public boolean contains(String id, String name) {
        return customers.contains(new Customer(id, name));
    }
}