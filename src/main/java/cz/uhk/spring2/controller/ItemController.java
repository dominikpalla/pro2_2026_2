package cz.uhk.spring2.controller;

import cz.uhk.spring2.model.Item;
import cz.uhk.spring2.service.ItemService;
import cz.uhk.spring2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/items")
public class ItemController {

    private ItemService itemService;
    private UserService userService;

    @Autowired
    public ItemController(ItemService itemService, UserService userService) {
        this.itemService = itemService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String list(Model model){
        model.addAttribute("items", itemService.getAllItems());
        return "items_list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("item", new Item());
        model.addAttribute("users", userService.getAllUsers());
        return "items_edit";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable long id, Model model){
        Item u = itemService.getItem(id);
        if (u != null) {
            model.addAttribute("item", u);
            model.addAttribute("users", userService.getAllUsers());
            return "items_edit";
        }else{
            return "redirect:/items/";
        }
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable long id, Model model){
        model.addAttribute("item", itemService.getItem(id));
        return "items_detail";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable long id){
        itemService.deleteItem(id);
        return "redirect:/items/";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Item item){
        itemService.saveItem(item);
        return "redirect:/items/";
    }

}
