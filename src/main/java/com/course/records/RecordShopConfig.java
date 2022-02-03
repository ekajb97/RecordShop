package com.course.records;

import com.course.records.model.Format;
import com.course.records.model.Stock;
import com.course.records.model.Shop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RecordShopConfig {
    @Bean(name = "newStock")
    public List<Stock> buildNewStock() {
        List<Stock> data = List.of(
                new Stock("Kerplunk", "Green Day", Format.Vinyl, 25.85, Shop.online),
                new Stock("Kerplunk", "Green Day", Format.CD, 11.99, Shop.online),
                new Stock("Dookie", "Green Day", Format.Vinyl, 15.99, Shop.online),
                new Stock("Dookie", "Green Day", Format.CD, 6.99, Shop.online),
                new Stock("Insomniac", "Green Day", Format.Vinyl, 17.99, Shop.online),
                new Stock("Insomniac", "Green Day", Format.CD, 7.99, Shop.online),
                new Stock("Insomniac", "Green Day", Format.Cassette, 6.79, Shop.inStore),
                new Stock("Inflammable Material", "Stiff Little Fingers", Format.Vinyl, 16.99, Shop.inStore),
                new Stock("Inflammable Material", "Stiff Little Fingers", Format.CD, 7.65, Shop.online),
                new Stock("Suspect Device", "Stiff Little Fingers", Format.Vinyl, 5.65, Shop.inStore),
                new Stock("True Love", "Fangclub", Format.Vinyl, 8.99, Shop.inStore),
                new Stock("Vulture Culture", "Fangclub", Format.Vinyl, 18.50, Shop.inStore),
                new Stock("True Love", "Fangclub", Format.Vinyl, 10.00, Shop.online),
                new Stock("Master of Puppets", "Metallica", Format.Vinyl, 26.99, Shop.inStore),
                new Stock("Ride the Lightning", "Metallica", Format.Vinyl, 26.99, Shop.inStore),
                new Stock("Metallica", "Metallica", Format.Vinyl, 26.99, Shop.inStore),
                new Stock("Nevermind", "Nirvana", Format.Vinyl, 22.99, Shop.online),
                new Stock("Hybrid Theory", "Linkin Park", Format.CD, 10.95, Shop.inStore),
                new Stock("Growing Pains", "Dinosaur Pile-Up", Format.Cassette, 8.25, Shop.inStore)
        );
        return new ArrayList<>(data);
    }

    @Bean(name = "usedStock")
    public List<Stock> buildUsedStock() {
        return List.of(
                new Stock("Dookie", "Green Day", Format.Vinyl, 11.99, Shop.online),
                new Stock("London Calling", "The Clash", Format.Vinyl, 9.99, Shop.inStore)
        );
    }
}
