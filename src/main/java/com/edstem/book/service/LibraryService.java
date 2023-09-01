package com.edstem.book.service;

import com.edstem.book.contract.LibraryDto;
import com.edstem.book.exception.RentedBookNotFoundException;
import com.edstem.book.model.Library;
import com.edstem.book.repository.LibraryRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class LibraryService {
    private final LibraryRepository libraryRepository;
    private final ModelMapper modelMapper;


@Autowired
    public LibraryService(LibraryRepository libraryRepository, ModelMapper modelMapper) {
        this.libraryRepository = libraryRepository;
        this.modelMapper = modelMapper;
    }

    public List<LibraryDto> libraryBooksList() {
        List<Library> rentals = this.libraryRepository.findAll();
        return rentals.stream()
                .map(library -> modelMapper.map(library, LibraryDto.class))
                .collect(Collectors.toList());
    }

    public LibraryDto getLibraryBooksById(int id) {
        Library rental =
                libraryRepository
                        .findById(id)
                        .orElseThrow(
                                () -> {
                                    log.error("Rented Book with id: {} not found", id);
                                    return new RentedBookNotFoundException(id);
                                });
        return modelMapper.map(rental, LibraryDto.class);
    }

    public LibraryDto addLibraryBooks(LibraryDto libraryDto) {
        Library rentalEntity = libraryRepository.save(modelMapper.map(libraryDto, Library.class));
        return modelMapper.map(rentalEntity, LibraryDto.class);
    }

    public LibraryDto updateLibraryBooksById(int id, LibraryDto libraryDto) {
        Library nonRentedBook =
                libraryRepository
                        .findById(id)
                        .orElseThrow(
                                () -> {
                                    log.error("Rented Book with id: {} not found", id);
                                    return new RentedBookNotFoundException(id);
                                });

        modelMapper.map(libraryDto, nonRentedBook);
        Library updatedRentedBook = libraryRepository.save(nonRentedBook);
        return modelMapper.map(updatedRentedBook, LibraryDto.class);
    }

    public void deleteLibraryBooksById(int id) {
        if (!libraryRepository.existsById(id)) {
            throw new RentedBookNotFoundException(id);
        }
        libraryRepository.deleteById(id);
    }
}
