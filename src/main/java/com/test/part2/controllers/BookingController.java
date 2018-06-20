package com.test.part2.controllers;

import com.test.part2.dto.BookOrderDto;
import com.test.part2.dto.SearchDto;
import com.test.part2.persistence.model.Row;
import com.test.part2.persistence.model.Seat;
import com.test.part2.persistence.model.UserType;
import com.test.part2.services.RowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Controller
public class BookingController {

    @Autowired
    private RowService rowService;

    @RequestMapping(value = {"/", "/booking"}, method = RequestMethod.GET)
    public String booking(Model model) {
        model.addAttribute("searchParams", new SearchDto());
        model.addAttribute("bookParams", new BookOrderDto());
        List<Row> rowList = rowService.getOrderedRows();
        model.addAttribute("rowList", rowList);

        boolean isAdmin = SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority(UserType.ADMIN.getValue()));
        model.addAttribute("isAdmin", isAdmin);
        return "booking";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@ModelAttribute("searchParams") SearchDto searchParams, BindingResult bindingResult, Model model) {

        List<Seat[]> availableSeats = rowService.search(searchParams);
        model.addAttribute("availableSeats", availableSeats);
        Set<Seat> forBookingSeats = new LinkedHashSet<>();
        availableSeats.forEach(array -> {
            for (Seat seat : array) {
                forBookingSeats.add(seat);
            }
        });
        List<Row> rowList = rowService.markAvailableSeats(forBookingSeats);
        model.addAttribute("rowList", rowList);
        model.addAttribute("bookParams", new BookOrderDto());

        boolean isAdmin = SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority(UserType.ADMIN.getValue()));
        model.addAttribute("isAdmin", isAdmin);

        return "booking";
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public String book(@ModelAttribute("bookParams") BookOrderDto bookParams, BindingResult bindingResult, Model model) {

        rowService.bookSeats(bookParams.getSeatsToBook());
        return "redirect:/booking";
    }

    @RequestMapping(value = "/redistribute", method = RequestMethod.GET)
    public String book(Model model, HttpSession session, HttpServletRequest request) {

        rowService.redistributeAllSeats();
        return "redirect:/booking";
    }

}
