package com.google;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;



public class Tests extends WebDriverSettings {
    @BeforeEach
    public void before(){
        System.out.println("before");
    }

@AfterEach
public void after(){
    System.out.println("after");
}
    @Test
    public void firstTest(){
        System.out.println("first test");
        Assertions.assertTrue(1==1,"Один не равен одному");

    }
    @Test
    public void seachFlower(){
        chromeDriver.get("http://www.google.com/");
        WebElement searchField = chromeDriver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
        WebElement searchButton = chromeDriver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]"));

        searchField.click();
        searchField.sendKeys("гладиолус");
        searchButton.click();

        // Assertions.assertTrue(title.contains("Bell Integrator"),"Тайтл не корректен");
        List<WebElement> pages = chromeDriver.findElements(By.xpath("//*[@class=\"r\"]//*[@class=\"LC20lb DKV0Md\"]"));
        System.out.println(pages.size());
        //pages.stream().forEach(x-> System.out.println(x.getText()));
        Assertions.assertTrue(
                pages.size()>3
                , "Страниц не больше 3-х"
        );



    }
    @Test
    public void ExistWiki(){
        chromeDriver.get("http://www.google.com/");
        WebElement searchField = chromeDriver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
        WebElement searchButton = chromeDriver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]"));

        searchField.click();
        searchField.sendKeys("гладиолус");
        searchButton.click();
        List<WebElement> pages = chromeDriver.findElements(By.xpath("//*[@class=\"r\"] //*[@href]"));
        pages.stream().forEach(x-> System.out.println(x.getText()));

        Assertions.assertTrue(
               pages.stream().anyMatch(x->x.getText().contains("wikipedia.org"))
                , "ссылка Википедия отсутствует"  );


    }

}

