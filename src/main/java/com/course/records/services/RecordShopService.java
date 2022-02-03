package com.course.records.services;

import com.course.records.model.Format;
import com.course.records.model.Shop;
import com.course.records.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/records")
public class RecordShopService {


    private List<Stock> records;
    @Autowired
    public RecordShopService(
            @Qualifier("newStock") List<Stock> newStock,
            @Qualifier("usedStock") List<Stock> usedStock
    ) {
        records = new ArrayList<>();
        records.addAll(newStock);
        records.addAll(usedStock);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Stock>> allRecords() {
        if (records.isEmpty()) {
            return notFound().build();
        }
        return ok(records);
    }

    @GetMapping(value = "/artist/{artist}", produces = "application/json")
    public List<Stock> releaseByArtist(@PathVariable String artist) {
        return records
                .stream()
                .filter(stock -> stock.getArtist().equals(artist))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/album/{name}", produces = "application/json")
    public ResponseEntity<List<Stock>> releaseByAlbum(@PathVariable String name) {
        List<Stock> result = records
                .stream()
                .filter(stock -> stock.getName().equals(name))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return notFound().build();
        }
        return ok(result);
    }

    @GetMapping(value = "/price/{price}", produces = "application/json")
    public ResponseEntity<List<Stock>> releaseByPrice(@PathVariable double price) {
        List<Stock> result = records
                .stream()
                .filter(stock -> stock.getPrice() == price)
                .collect(Collectors.toList());
        if (result.isEmpty()) {
            return notFound().build();
        }
        return ok(result);
    }

    @GetMapping(value = "/vinyl", produces = "application/json")
    public ResponseEntity<List<Stock>> getAllVinyl() {
        List<Stock> result = records
                .stream()
                .filter(stock -> stock.getFormat() == Format.Vinyl)
                .collect(Collectors.toList());
        if (result.isEmpty()) {
            return notFound().build();
        }
        return ok(result);
    }

    @GetMapping(value = "/cd", produces = "application/json")
    public ResponseEntity<List<Stock>> getAllCD() {
        List<Stock> result = records
                .stream()
                .filter(stock -> stock.getFormat() == Format.CD)
                .collect(Collectors.toList());
        if (result.isEmpty()) {
            return notFound().build();
        }
        return ok(result);
    }

    @GetMapping(value = "/cassette", produces = "application/json")
    public ResponseEntity<List<Stock>> getAllCassette() {
        List<Stock> result = records
                .stream()
                .filter(stock -> stock.getFormat() == Format.Cassette)
                .collect(Collectors.toList());
        if (result.isEmpty()) {
            return notFound().build();
        }
        return ok(result);
    }

    @GetMapping(value = "/online", produces = "application/json")
    public ResponseEntity<List<Stock>> getAllOnline() {
        List<Stock> result = records
                .stream()
                .filter(stock -> stock.getShop() == Shop.online)
                .collect(Collectors.toList());
        if (result.isEmpty()) {
            return notFound().build();
        }
        return ok(result);
    }

    @GetMapping(value = "/store", produces = "application/json")
    public ResponseEntity<List<Stock>> getAllInStore() {
        List<Stock> result = records
                .stream()
                .filter(stock -> stock.getShop() == Shop.inStore)
                .collect(Collectors.toList());
        if (result.isEmpty()) {
            return notFound().build();
        }
        return ok(result);
    }

    @PutMapping(value = "{name}", consumes = "application/json")
    public void addStock(
            @RequestBody Stock stock,
            @PathVariable String name){
        records.add(stock);
    }

}
