package com.booksystem.booksystem.service;

import com.booksystem.booksystem.model.Book;
import com.booksystem.booksystem.model.Order;
import com.booksystem.booksystem.model.User;
import com.booksystem.booksystem.payload.CreateOrderRequest;
import com.booksystem.booksystem.repository.BookRepository;
import com.booksystem.booksystem.repository.OrderRepository;
import com.booksystem.booksystem.repository.UserRepository;
import com.booksystem.booksystem.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    public Order save(UserPrincipal currentUser, CreateOrderRequest order) {
        Order newOrder = new Order();

        List<Book> booksList = bookRepository.findByIdIn(order.getBookIds());
        Optional<User> user = userRepository.findById(currentUser.getId());

        user.ifPresent(newOrder::setCustomer);
        newOrder.getBooks().addAll(booksList);

        Instant now = Instant.now();
        newOrder.setCreatedAt(now);
        newOrder.setUpdatedAt(now);

        newOrder.setCost(
                booksList.stream()
                        .mapToLong(Book::getPrice)
                        .sum()
        );

        return orderRepository.save(newOrder);
    }

    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> findOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Optional<List<Order>> findOrdersByUserId(Long userId) {
        return orderRepository.findOrdersByCustomerId(userId);
    }

    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }
}
