# PetHotelMS

## Funkcjonalności do zakodowani:
* Logowanie i autoryzacja pracowników:
  - System logowania z różnymi poziomami dostępu, aby zarządzać uprawnieniami poszczególnych pracowników.
    - poziomy będą dodawane jako scopy
    - już jest rozwiązanie, należy się połączyć i pobrać dane, logalhost:8081
    - użytkownik może utworzyć konto w aplikacji po kliknięciu "specjalnego" linka
      - będzie przesyłane login i hasło - ZABEZPIECZYĆ
    - dodanie bazy danych użytkownika z przypisanymi scopów - uprawnień
      - stworzenie repozytorium - mongoDB - Docker
      - dodanie encji + prosty mapper dto <-> encja
    - przygotowanie tokena z odpowiednimi uprawnieniami
      - proste zabezpieczenie przed niewłaściwym wykorzystaniem tokena
    - dodanie domyślnego użytkownika 
* Zarządzanie rezerwacjami:
  - Możliwość dodawania, edytowania i usuwania rezerwacji dla zwierząt, a także przypisywania konkretnych zwierząt do pokoi lub klatek.
    - etap pierwszy - zapis rezerwacji do bazy danych
      - rezerwacji dokonuje pracownik z odpowiednimi uprawnieniami - scopy zapisane w tokenie
      - dodanie systemu kontroli wersji bazy danych - liquidbase

* Harmonogram pracy pracowników:
  - Narzędzie do planowania i monitorowania grafiku pracy personelu, aby zapewnić odpowiednią liczbę pracowników w hotelu o różnych porach.

* Profil zwierzęcia:
  - Szczegółowe informacje o każdym zwierzęciu, w tym dane kontaktowe właścicieli, preferencje żywieniowe, informacje o zdrowiu i historię opieki.

* Rejestr dzienny:
  - Funkcjonalność do notowania codziennych obserwacji dotyczących zwierząt, takich jak jedzenie, zachowanie, zdrowie oraz ewentualne problemy.

* Zarządzanie zapasami:
  - Monitorowanie stanu zapasów:
    - jedzenia
    - zabawek
    - środków higienicznych
    - innych artykułów.
  Automatyczne powiadomienia o niskim stanie zapasów.

* Alarmy i przypomnienia:
  - Automatyczne przypomnienia dla pracowników o ważnych zadaniach, takich jak podawanie leków, karmienie czy zabiegi pielęgnacyjne.

* Raportowanie:
  - Możliwość generowania raportów dotyczących rezerwacji, stanu zapasów, harmonogramów pracowników oraz ogólnej działalności hotelu.

* Rejestr usług dodatkowych:
  - Możliwość rejestrowania i śledzenia dodatkowych usług świadczonych dla zwierząt, takich jak kąpiele, strzyżenie czy spacery, wraz z możliwością przypisywania ich do konkretnych zwierząt.


## Zależności
[SimpleAuthenticationService](https://github.com/dicedev-pl/SimplyAuthorizationMicroservice) 
Serwis jest wykorzystywany do sprawdzenia użytkowników, jego rozwój opisuje punkt:
[Logowanie i autoryzacja pracowników](https://github.com/dicedev-pl/PetHotelMS/blob/master/README.md#L4)