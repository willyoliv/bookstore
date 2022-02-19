package com.oliveira.willy.bookstore.controller;

import com.oliveira.willy.bookstore.model.BookDTO;
import com.oliveira.willy.bookstore.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/bookstore")
public class BookController {

    private final BookService bookService;

    @GetMapping("/{id}")
    private ResponseEntity<BookDTO> getBook(@PathVariable("id") Integer id) {
        BookDTO response = bookService.getBookById(id);

        if (response == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping
    private ResponseEntity<String> addBook(@RequestBody BookDTO bookDTO) {
        bookService.addBook(bookDTO);
        return new ResponseEntity<>("Livro adicionado com sucesso", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<String> updateBook(@PathVariable("id") Integer id, @RequestBody BookDTO bookDTO) {
        Boolean updated = bookService.updateBook(id, bookDTO);
        if (updated) {
            return new ResponseEntity<>("Livro atualizado com sucesso", HttpStatus.OK);
        }
        return new ResponseEntity<>("Não foi possível atualizar o livro", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<String> deleteBook(@PathVariable("id") Integer id) {
        Boolean deleted = bookService.deleteBook(id);

        if (deleted) {
            return new ResponseEntity<>("Livro removido com sucesso", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("Livro não encontrado", HttpStatus.NOT_FOUND);
    }
}
