# Programowanie klient serwer z u¿yciem gniazd, kana³ów i selektorów


Aplikacja obs³uguje rozsy³anie wiadomoœci do klientów.

Ka¿dy klient, ³¹cz¹c siê z serwerem, mo¿e zapisaæ siê do œwiadczonej us³ugi podaj¹c tematy, którymi siê interesuje (np. polityka, sport, celebryci, gotowanie, randki, ...) jak równie¿ zrezygnowaæ ze swoich istniej¹cych tematów. Aplikacja powinna umo¿liwiæ jednoczeœn¹ obs³ugê wielu klientów.

Osobnym programem (administruj¹cym tematami/wiadomoœciami) przesy³amy do serwera wiadomoœci z ró¿nych dziedzin, a on rozsy³a je do subskrybentów zainteresowanych danym tematem. Tym samym programem, przy pomocy serwera, zarz¹dzamy tematami (usuwanie istniej¹cych tematów, dodawanie nowych tematów, informowanie klientom o zmianach dotycz¹cych tematów, ...).

Do obs³ugi po³¹czeñ (typu "subscribe", "unsubscribe", oraz po³¹czeñ przysy³aj¹cych nowe wiadomoœci do rozes³ania) u¿yj selektorów - nie twórz nowych w¹tków!

Stwórz proste GUI separuj¹ce od logiki przetwarzania danych.

Aplikacja powinna byæ odporna na ró¿ne sytuacje awaryjne.