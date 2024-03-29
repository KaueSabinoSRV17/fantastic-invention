package br.com.Loja.repositories;

import br.com.Loja.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existsByCpf(String cpf);
    List<Customer> findAllByParentCustomerId(Long id);
}
