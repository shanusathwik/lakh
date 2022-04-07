package com.example.charan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static jdk.internal.logger.LoggerFinderLoader.service;

@Controller
public class appmain {



        @Autowired
        private studentservice;

        @RequestMapping("/")
        public String viewHomePage(Model model) {
            List<student> listProducts = service.listAll();
            model.addAttribute("listProducts", listProducts);

            return "index";
        }

        @RequestMapping("/new")
        public String showNewProductPage(Model model) {
            Product product = new Product();
            model.addAttribute("product", product);

            return "new_product";
        }

        @RequestMapping(value = "/save", method = RequestMethod.POST)
        public String saveProduct(@ModelAttribute("product") Product product) {
            service.save(product);

            return "redirect:/";
        }

        @RequestMapping("/edit/{id}")
        public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
            ModelAndView mav = new ModelAndView("edit_product");
            Product product = service.get(id);
            mav.addObject("product", product);

            return mav;
        }

        @RequestMapping("/delete/{id}")
        public String deleteProduct(@PathVariable(name = "id") int id) {
            service.delete(id);
            return "redirect:/";
        }
    }
}
