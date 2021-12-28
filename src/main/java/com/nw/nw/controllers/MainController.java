package com.nw.nw.controllers;

import com.nw.nw.models.Sweets;
import com.nw.nw.repo.SweetsRepo;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@Controller
public class MainController {

    @Autowired
    private SweetsRepo sweetsRepo;

    @GetMapping("/")
    public String home(Model model) {

        return "home";
    }

    @GetMapping("/gift")
    public String gift(Model model) {
        Iterable<Sweets> sweets = sweetsRepo.findAll();
        int count = 0;
        int count2 = 0;
        for (Sweets sweets1 : sweets) {
            count = count + sweets1.getWeightSweets();
            count2 = count2 + sweets1.getSugarSweets();
        }
        model.addAttribute("sweets", sweets);
        model.addAttribute("count", count);
        model.addAttribute("count2", count2);
        return "gift";
    }

    @GetMapping("/addnew")
    public String addnew(Model model) {
        return "addnew";
    }

    @PostMapping("/addnew")
    public String addnewsub(@RequestParam String sweetsName, @RequestParam int sweetsSugar, @RequestParam int sweetsWeight, Model model) {
        Sweets sweets = new Sweets(sweetsName, sweetsSugar, sweetsWeight);
        sweetsRepo.save(sweets);
        return "redirect:/gift";
    }

    @PostMapping("/gift/delete/{id}")
    public String remsweets(@PathVariable(value = "id") long id, Model model) {
        sweetsRepo.deleteById(id);
        return "redirect:/gift";
    }

    @GetMapping("/sort")
    public String sort(Model model) {
        int count = 0;
        Iterable<Sweets> sweets = sweetsRepo.findAll();
        ArrayList<Sweets> arrayList = new ArrayList<>();
        for (Sweets sweets1 : sweets) {
            arrayList.add(sweets1);
            count = count + sweets1.getWeightSweets();
        }
        arrayList.sort((o1, o2) -> o1.getSugarSweets() - o2.getSugarSweets());
        model.addAttribute("sweets", arrayList);
        model.addAttribute("count", count);
        return "sort";
    }

    @GetMapping("/sortbuparam")
    public String sortbuparam(Model model) {
        return "sortbuparam";
    }

       @PostMapping("/sortbuparam")
    public String sortbuparam(@RequestParam int sugarMin, @RequestParam int sugarMax, Model model) {
        Iterable<Sweets> sweetssort2 = sweetsRepo.findAll();
        ArrayList<Sweets> arrayList = new ArrayList<>();
        for (Sweets sweets1 : sweetssort2) {
            if (sweets1.getSugarSweets() >= sugarMin && sweets1.getSugarSweets() <= sugarMax) {
                arrayList.add(sweets1);
            }
        }
        model.addAttribute("sweetssort2", arrayList);


        return "sortbuparam";
    }

}
