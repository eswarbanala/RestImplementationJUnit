package com.eswar.demo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;
import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@RestController
@RequestMapping(value = "/book")
public class BookController {
	@Autowired
	BookRepository bookRepository;

	@GetMapping
	public List<Book> getAllBookRecords() {
		return bookRepository.findAll();
	}

	@GetMapping(value = "{bookId}")
	public Book getBookById(@PathVariable(value = "bookId") Long bookId) {
		return bookRepository.findById(bookId).get();
	}

	@PostMapping
	public Book createBookRecord(@RequestBody @Valid Book bookRecord) {
		return bookRepository.save(bookRecord);
	}

	@PutMapping
	public Book updateBookRecord(@RequestBody @Valid Book bookRecord) throws NotFoundException {
		if (bookRecord == null || bookRecord.getBookId() == null) {
			throw new NotFoundException("BookRecord or BookId should not be null");
		}
		java.util.Optional<Book> optionalBook = bookRepository.findById(bookRecord.getBookId());
		if (!optionalBook.isPresent()) {
			throw new NotFoundException("Book with ID : " + bookRecord.getBookId() + "doesn't Exist");
		}
		Book existingBookRecord = optionalBook.get();
		existingBookRecord.setName(bookRecord.getName());
		existingBookRecord.setSummary(bookRecord.getSummary());
		existingBookRecord.setRating(bookRecord.getRating());
		return bookRepository.save(existingBookRecord);

	}

}
