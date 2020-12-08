package com.doancuoiki.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.doancuoiki.demo.Entity.Book;
import com.doancuoiki.demo.Repository.BookRepository;

@RestController
@CrossOrigin(origins="http://localhost:8081")
@RequestMapping("/books")
public class BookController {
	private BookRepository bookRepository;

	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@GetMapping("/all")
	public List<Book> getAll() {
		List<Book> books = this.bookRepository.findAll();
		return books;
	}

	@PostMapping("/create")
	public void insert(@RequestBody Book book) {
		this.bookRepository.insert(book);
	}

	@PostMapping("/update/{id}")
	public void update(@RequestBody Book nbook,@PathVariable("id") String id) {
		Optional<Book> book = this.bookRepository.findById(id);
		book.get().setTitle(nbook.getTitle());
		book.get().setAuthor(nbook.getAuthor());
		book.get().setPrice(nbook.getPrice());
		this.bookRepository.save(book.get());
	}

	@GetMapping("/{id}")
	public Optional<Book> getById(@PathVariable("id") String id) {
		Optional<Book> book = this.bookRepository.findById(id);

		return book;
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") String id) {
		this.bookRepository.deleteById(id);
		
	}
}
