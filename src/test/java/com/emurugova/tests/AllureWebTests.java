package com.emurugova.tests;

import com.emurugova.allure.Layer;
import com.emurugova.allure.Microservice;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Layer("web")
public class AllureWebTests extends TestBase{

private String REPOSOTORIY = "allure-examples/allure-examples";
private int ISSUE = 33;
private int REQUEST= 29;

   @Test
   @AllureId("16193")
   @DisplayName("Поиск задачи в репозитории неавторизованным пользователем")
   @Tags({@Tag("critical"), @Tag("UI-tests")})
   @Owner("allure8")
   @Microservice("Issue")
   @Story("Поиск задачи в репозитории используя главную страницу")
   @Feature("Поиск")
   public void issueSearchUsingMainPageTest() {
     step("Открываем главную страницу", () -> {
               open("/");
             });

     step("Ищем репозиторий " + REPOSOTORIY +  " в форме поиска в шапке", () -> {
       step("Кликаем на поисковую строку", () -> {
         $(By.name("q")).click();
      });
       step("Вводим текст "  + REPOSOTORIY,  () -> {
         $(By.name("q")).setValue("allure-examples");
       });

       step("Нажимаем кнопку Enter", () -> {
         $(By.name("q")).pressEnter();
       });
     });

     step("Переходим по ссылке репозитория " + REPOSOTORIY, () -> {
       $$(".repo-list li").first().$("a").click();
     });

     step("Переходим во вкладку Задачи", () -> {
       $("#issues-tab").click();
     });

     step("Проверяем что задача " + ISSUE+ " существует", () -> {
       $(".js-navigation-container.js-active-navigation-container").shouldHave(text("#"+ISSUE));
     });
   }

    @Test
    @AllureId("16495")
    @DisplayName("Поиск задачи в репозитории по прямой ссылке репозитория")
    @Tags({@Tag("critical"), @Tag("UI-tests")})
    @Owner("allure8")
    @Microservice("Issue")
    @Story("Поиск задачи в репозитории используя прямую ссылку")
    @Feature("Поиск")
    void issueSearchByDirectLinkTest() {
     step("Открываем репозиторий  allure-examples/allure-examples", ()-> {
       open("/"+REPOSOTORIY);
     });

     step("Переходим во вкладку Issues", ()-> {
       $("#issues-tab").click();
     });

     step("Проверяем что задача " + ISSUE+ " существует", () -> {
       $(".js-navigation-container.js-active-navigation-container").shouldHave(text("#"+ISSUE));
     });
    }

    @Test
    @AllureId("16494")
    @DisplayName("Поиск pull request в репозитории неавторизованным пользователем")
    @Tags({@Tag("critical"), @Tag("UI-tests")})
    @Owner("allure8")
    @Microservice("Request")
    @Story("Поиск pull request используя главную страницу")
    @Feature("Поиск")
    public void requestSearchUsingMainPageTest() {
     step("Открываем главную страницу", () -> {
       open("/");
        });

     step("Ищем репозиторий " + REPOSOTORIY +  " в форме поиска в шапке", () -> {
       step("Кликаем на поисковую строку", () -> {
          $(By.name("q")).click();
       });
       step("Вводим текст "  + REPOSOTORIY,  () -> {
          $(By.name("q")).setValue("allure-examples");
       });

     step("Нажимаем кнопку Enter", () -> {
       $(By.name("q")).pressEnter();
       });
     });

     step("Переходим по ссылке репозитория " + REPOSOTORIY, () -> {
       $$(".repo-list li").first().$("a").click();
     });

     step("Переходим во вкладку Запросов", () -> {
       $("#pull-requests-tab").click();
     });

     step("Проверяем что задача " + REQUEST + " существует", () -> {
       $(".js-navigation-container.js-active-navigation-container").shouldHave(text("#"+REQUEST));
     });
    }

    @Test
    @AllureId("16493")
    @DisplayName("Поиск pull request в репозитории по прямой ссылке репозитория")
    @Tags({@Tag("critical"), @Tag("UI-tests")})
    @Owner("allure8")
    @Microservice("Request")
    @Story("Поиск pull request используя прямую ссылку")
    @Feature("Поиск")
    void requestSearchByDirectLinkTest() {
     step("Открываем репозиторий  allure-examples/allure-examples", ()-> {
       open("/"+REPOSOTORIY);
     });

     step("Переходим во вкладку Issues", ()-> {
       $("#issues-tab").click();
     });

     step("Проверяем что задача " + ISSUE+ " существует", () -> {
       $(".js-navigation-container.js-active-navigation-container").shouldHave(text("#"+ISSUE));
     });
   }
}
