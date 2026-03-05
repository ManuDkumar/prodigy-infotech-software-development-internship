package com.manu;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

public class WebScraper {

    public static void main(String[] args) {

        String url = "https://books.toscrape.com/";
        String fileName = "products.csv";

        try {

            Document doc = Jsoup.connect(url).get();

            Elements products = doc.select("article.product_pod");

            FileWriter writer = new FileWriter(fileName);
            writer.append("Name,Price,Rating\n");

            for (Element product : products) {

                String name = product.select("h3 a").attr("title");
                String price = product.select(".price_color").text();
                String rating = product.select(".star-rating").attr("class").replace("star-rating ", "");

                writer.append(name + "," + price + "," + rating + "\n");
            }

            writer.close();

            System.out.println("Scraping completed successfully.");
            System.out.println("Data saved to products.csv");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}