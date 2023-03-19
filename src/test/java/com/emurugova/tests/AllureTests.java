package com.emurugova.tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AllureTests extends TestBase{

private String REPOSOTORIY = "allure-examples/allure-examples";
private int ISSUE = 33;

  @Test
  @AllureId("16193")
  @DisplayName("Поиск задачи в репозитории неавторизованным пользователем")
  @Tag("Critical")
  @Owner("allure8")
  public void issueSearchTest() {
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

}
