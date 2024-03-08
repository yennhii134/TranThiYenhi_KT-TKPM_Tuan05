package com.example.tranthiyennhi_tuan05_service.controller;

import com.example.tranthiyennhi_tuan05_service.models.Gallery;
import com.example.tranthiyennhi_tuan05_service.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/")
public class HomeController {
    @Autowired
    private Environment env;
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/")
    public String home() {

        return null;
    }

    @RequestMapping("/items")
    public List<Item> getImages() {
        List<Item> items = Arrays.asList(
                new Item(1L, "Treehouse of Horror V"),
                new Item(2L, "The Town"),
                new Item(3L, "The Last Traction Hero"));
        return items;
    }

    @RequestMapping("/{id}")
    public Gallery getGallery(@PathVariable final int id) {
        // create gallery object
        Gallery gallery = new Gallery();
        gallery.setId(id);

        // get list of available images
        List<Object> items = restTemplate.getForObject("http://image-service/images/", List.class);
        gallery.setItems(items);

        return gallery;
    }
    public String homeAdmin() {
        return "This is the admin area of Gallery service running at port: " + env.getProperty("local.server.port");
    }
}
