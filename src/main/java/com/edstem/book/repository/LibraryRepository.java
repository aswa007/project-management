package com.edstem.book.repository;

import com.edstem.book.model.Book;
import com.edstem.book.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {
    Optional<Library> findById(int id);
    List<Library>findByStatus(String status);

    boolean existsByIsbn(Long isbn);
}
