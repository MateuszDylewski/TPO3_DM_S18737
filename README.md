# Programowanie klient serwer z u�yciem gniazd, kana��w i selektor�w


Aplikacja obs�uguje rozsy�anie wiadomo�ci do klient�w.

Ka�dy klient, ��cz�c si� z serwerem, mo�e zapisa� si� do �wiadczonej us�ugi podaj�c tematy, kt�rymi si� interesuje (np. polityka, sport, celebryci, gotowanie, randki, ...) jak r�wnie� zrezygnowa� ze swoich istniej�cych temat�w. Aplikacja powinna umo�liwi� jednocze�n� obs�ug� wielu klient�w.

Osobnym programem (administruj�cym tematami/wiadomo�ciami) przesy�amy do serwera wiadomo�ci z r�nych dziedzin, a on rozsy�a je do subskrybent�w zainteresowanych danym tematem. Tym samym programem, przy pomocy serwera, zarz�dzamy tematami (usuwanie istniej�cych temat�w, dodawanie nowych temat�w, informowanie klientom o zmianach dotycz�cych temat�w, ...).

Do obs�ugi po��cze� (typu "subscribe", "unsubscribe", oraz po��cze� przysy�aj�cych nowe wiadomo�ci do rozes�ania) u�yj selektor�w - nie tw�rz nowych w�tk�w!

Stw�rz proste GUI separuj�ce od logiki przetwarzania danych.

Aplikacja powinna by� odporna na r�ne sytuacje awaryjne.