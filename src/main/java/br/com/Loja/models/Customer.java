package br.com.Loja.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String cpf;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Address> addresses = new ArrayList<Address>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer parentCustomer;

    @OneToMany(mappedBy = "parentCustomer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Customer> customersDependents = new HashSet<Customer>();


    public Customer(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public void addCustomerDependent(Customer customer){
        if(!this.customersDependents.contains(customer))
            this.customersDependents.add(customer);
    }
}
