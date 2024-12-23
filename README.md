# Проект по автоматизации тестирования мобильной версии сайта [Википедия](https://ru.wikipedia.org/wiki)

> Википедия — многоязычная общедоступная интернет-энциклопедия со свободным контентом, поддержку и написание которой осуществляют добровольцы — «википедисты», посредством открытого сотрудничества и с использованием MediaWiki, системы редактирования на основе вики-принципов.

## **Содержание:**
____

* <a href="#tools">Технологии и инструменты</a>

* <a href="#cases">Примеры автоматизированных тест-кейсов</a>

* <a href="#jenkins">Сборка в Jenkins</a>

* <a href="#console">Запуск из терминала</a>

* <a href="#allure">Allure отчет</a>

* <a href="#allure-testops">Интеграция с Allure TestOps</a>

* <a href="#jira">Интеграция с Jira</a>

* <a href="#video">Примеры видео выполнения тестов на Selenoid</a>
____
<a id="tools"></a>
## <a name="Технологии и инструменты">**Технологии и инструменты:**</a>

<p align="center">  
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a>  
<a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://github.com/"><img src="images/logo/Github.svg" width="50" height="50"  alt="Github"/></a>  
<a href="https://junit.org/junit5/"><img src="images/logo/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>  
<a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>  
<a href="https://selenide.org/"><img src="images/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>  
<a href="https://aerokube.com/selenoid/"><img src="images/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>  
<a href="ht[images](images)tps://github.com/allure-framework/allure2"><img src="images/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a> 
<a href="https://qameta.io/"><img src="images/logo/Allure2.svg" width="50" height="50"  alt="Allure TestOps"/></a>   
<a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>  
<a href="https://www.atlassian.com/ru/software/jira/"><img src="images/logo/Jira.svg" width="50" height="50"  alt="Jira"/></a>  
<a href="https://www.browserstack.com/"><img src="images/logo/Browserstack.svg" width="50" height="50"  alt="Jira"/></a>  
</p>

- Язык для написания тестов : [Java](https://www.java.com/ru/)
- Фреймворк для модульного тестирования : [Junit5](https://github.com/junit-team/junit5)
- Система автоматической сборки : [Gradle](https://github.com/gradle)
- Удаленный запуск с выбором параметров для тестов реализован при помощи :  [Jenkins](https://www.jenkins.io/)
- Отчеты о пройденных тестах формируются при помощи : [Allure](https://github.com/allure-framework)
- Реализована интеграция  с [Allure TestOps](https://qameta.io/)
- Тесты мобильного приложения проходят на сервисе [BrowserStack](https://www.browserstack.com)

____
<a id="cases"></a>
## <a name="Примеры автоматизированных тест-кейсов">**Примеры автоматизированных тест-кейсов:**</a>
____
- ✓ *Успешный поиск по поисковому запросу*
- ✓ *Проверка краткого описания статьи*
- ✓ *Открытие первой статьи в результатах поиска* 
- ✓ *Проверка наличия регистрации*
____
<a id="jenkins"></a>
## <img alt="Jenkins" height="25" src="images/logo/Jenkins.svg" width="25"/></a><a name="Сборка"></a>Сборка в [Jenkins](https://jenkins.autotests.cloud/job/Browser_Stack_20/)</a>
____
<p align="center">  
<a href="https://jenkins.autotests.cloud/job/Browser_Stack_20/"><img src="images/screen/Jenkins.png" alt="Jenkins" width="950"/></a>  
</p>


## Команды для запуска из терминала
___
***Локальный запуск через BrowserStack:***

```bash  
gradle clean browserstack -DdeviceHost=browserstack -Dusername=ЛОГИН -Dpassword=ПАРОЛЬ
```
Чтобы получить логин и пароль, можно зарегистрироваться на [BrowserStack](https://www.browserstack.com/) (или запустите тесты через Jenkins)


***Локальный запуск через эмулятор:***

```bash  
gradle clean emulator -DdeviceHost=emulator -DdeviceName=ДЕВАЙС -DplatformVersion=ВЕРСИЯ_ПЛАТФОРМЫ
```
По умолчанию:
- deviceName=Pixel 3 API 29
- platformVersion=10.0

Перед запуском тестов необходимо установить и настроить сервер Appium и Uiautomator2. 
После этого запустите сервер Appium с помощью команды:

```bash  
appium server --base-path /wd/hub
```


***Удалённый запуск через Jenkins (только BrowserStack):***
```bash  
clean browserstack -DdeviceHost=browserstack
```

___
<a id="allure"></a>
## <img alt="Allure" height="25" src="images/logo/Allure.svg" width="25"/></a> <a name="Allure"></a>Allure [отчет](https://jenkins.autotests.cloud/job/Browser_Stack_20/44/allure/)</a>
___

### *Основная страница отчёта Android*

<p align="center">  
<img title="Allure Overview Dashboard" src="images/screen/AllureAndroid.png" width="850">  
</p>  

### *Графики Android*

  <p align="center">  
<img title="Allure Graphics" src="images/screen/AllureAndroidGraphics.png" width="850">
</p>

### *Основная страница отчёта Ios*

<p align="center">  
<img title="Allure Overview Dashboard" src="images/screen/AllureIos.png" width="850">  
</p>  

### *Графики Ios*

  <p align="center">  
<img title="Allure Graphics" src="images/screen/AllureIosGraphics.png" width="850">
</p>

___
<a id="allure-testops"></a>
## <img alt="Allure" height="25" src="images/logo/Allure2.svg" width="25"/></a>Интеграция с <a target="_blank" href="https://allure.autotests.cloud/project/4065/dashboards">Allure TestOps</a>
____
### *Allure TestOps Dashboard Android*

<p align="center">  
<img title="Allure TestOps Dashboard" src="images/screen/TestOpsAndroid2.png" width="850">  
</p>

### *Авто тест-кейсы Android*

<p align="center">  
<img title="Allure TestOps Tests" src="images/screen/TestOpsAndroid.png" width="850">  
</p>

### *Allure TestOps Dashboard Ios*

<p align="center">  
<img title="Allure TestOps Dashboard" src="images/screen/TestOpsIos2.png" width="850">  
</p>

### *Авто тест-кейсы Ios*

<p align="center">  
<img title="Allure TestOps Tests" src="images/screen/TestOpsIos.png" width="850">  
</p>

____
<a id="telegram"></a>
## <img alt="Telegram" height="25" src="images/logo/Telegram.svg" width="25"/></a> Уведомление в Telegram при помощи бота
____
<p align="center">  
<img title="Telegram Notification" src="images/screen/Telegramm.png" width="550">  
</p>

____
<a id="video"></a>
## <img alt="BrowserStack" height="25" src="images/logo/Browserstack.svg" width="20"/></a> Примеры видео выполнения тестов на BrowserStack
____
<p align="center">
<img title="BrowserStack Video" src="images/video/Android.gif" width="200" alt="video">   
</p>

____
<a id="video"></a>
## Пример видео выполнения тестов локально через эмулятор
____
<p align="center">
<img title="Emulator Video" src="images/video/Emulator.gif" width="200" alt="video">   
</p>

## Пример видео выполнения тестов удалённо на Ios
____
<p align="center">
<img title="Emulator Video" src="images/video/Ios.gif" width="200" alt="video">   
</p>
