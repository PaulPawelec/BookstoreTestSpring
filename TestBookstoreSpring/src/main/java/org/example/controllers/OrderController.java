package org.example.controllers;

import org.example.model.Books;
import org.example.model.Cart;
import org.example.model.Order;
import org.example.model.User;
import org.example.model.enums.Status;
import org.example.services.BookService;
import org.example.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final Cart cart;
    private final BookService bookService;

    @Autowired
    public OrderController(OrderService orderService, Cart cart, BookService bookService) {
        this.orderService = orderService;
        this.cart = cart;
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public String listOrders(Model model, Authentication authentication) {
        List<Order> orders = orderService.getOrders(authentication.getName());

        model.addAttribute("orders", orders);
        return "ordersList";
    }

    @GetMapping("/listAdmin")
    @Secured("ROLE_ADMIN")
    public String listOrdersAdmin(Model model) {
        List<Order> orders = orderService.getOrders();

        model.addAttribute("orders", orders);
        return "ordersList";
    }

    @PostMapping("/add")
    public String saveOrder(Authentication authentication){
        Order order = new Order(new User(authentication.getName()));
        HashSet<Books> books = new HashSet<>(bookService.getBooks(cart.getBookIds()));
        order.setBooks(books);

        float totalPrice = 0;
        for (Books book : books) {
            totalPrice += book.getPrice();
        }
//        System.out.println(totalPrice);

        order.setPrice(totalPrice);
        orderService.saveOrder(order);
        cart.getBookIds().clear();

        return "redirect:/orders/list";
    }

    @PostMapping("/changeStatus")
    @Secured("ROLE_ADMIN")
    public String changeStatusOrder(@RequestParam(name = "orderId") int id){
        orderService.changeStatusOrder(id, Status.COMPLETED);

        return "redirect:/orders/listAdmin";
    }
}
