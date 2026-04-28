Fortgeschrittene Programmierung (Java 2)


# Übung 3


Klonen Sie dieses Repository direkt in Eclipse und importieren Sie das Maven-Projekt. Legen Sie einen neuen Branch an, den Sie nach Ihrem GitHub-Benutzernamen benennen.


## a) Unit-Tests schreiben

In der Klasse `idh.java.ATM` finden Sie eine vereinfachte Version des Geldautomaten, den wir früher schonmal gesehen haben. Der Automat kennt jetzt keine Banken oder Kontos mehr, sondern gibt nur noch die passende Stückelung an Scheinen für einen Betrag aus. Dies passiert in der Methode `convertToBills(int amount)`, die ein `int[]` zurückliefert. Verstehen Sie zunächst wie diese Methode funktioniert. 

Für diese Methode sollen Sie nun Unit-Tests schreiben um zu überprüfen, ob sie sich korrekt verhält.

Das korrekte Verhalten ist das folgende:

- Bei einer durch fünf teilbaren Eingabe wird eine Stückelung erzeugt, die möglichst wenig Scheine verbraucht (d.h. es werden immer möglichst große Scheine ausgegeben). Testen Sie dies mit einer Reihe von möglichen Eingaben. Achten Sie dabei auf extreme Eingaben, also mit kleinst- und größtmöglichen Zahlen.

- Bei Eingabe einer negativen Zahl wird ein Array mit Nullen zurückgegeben.

- Bei Eingabe einer Zahl die nicht durch fünf teilbar ist, wird eine Exception der Klasse `IllegalInputException` geworfen.

Schreiben Sie die Unit-Tests in einer neuen Klasse `TestATM`, die im Package `idh.java` liegt. (Welche Konsequenzen hat es, dass die Klasse im gleichen Package liegt? Könnte sie auch in einem anderen sein?)

## b) Gegen Unit-Tests implementieren

In einer der ersten Sitzungen haben wir uns mit Schaltjahren und deren Bestimmung beschäftigt. In dieser Aufgabe kommen wir darauf zurück. In der Klasse `LeapYear` finden Sie eine Methode, `isLeapYear(int)`, die einen boolean zurückliefert, und angibt, ob es sich um ein Schaltjahr handelt. Wie Sie sehen, ist diese Methode so implementiert, dass Sie immer `false` zurückgibt. Sie finden außerdem die Klasse `TestLeapYear`, die eine Reihe von Unit-Tests enthält, die das richtige Verhalten der Klasse testen. Wenn Sie die Tests verwenden (machen Sie das ruhig am Anfang mal) sollten Sie sehen, dass die Tests fehlschlagen.

Implementieren Sie die Methode `isLeapYear()` in der Klasse `LeapYear` so, dass die Tests alle erfüllt werden. 

Das richtige Verhalten entspricht dabei den Regeln, die wir im Wintersemester kennengelernt haben (und die z.B. auch [hier](https://de.wikipedia.org/wiki/Schaltjahr) stehen. Zusätzlich -- wird sind ja historisch reflektiert unterwegs -- berücksichtigen wir aber, dass Schaltjahre eine Erfindung im Gregorianischen Kalender sind. Für Jahre vor dessen Einführung ist die Frage nach dem Schaltjahr nicht anwendbar -- die Methode soll dann die Exception `OutOfRangeException` werfen.


----

Wenn Sie fertig sind, committen Sie alle Ihre Änderungen, und pushen Sie den neuen Branch auf das remote namens `origin` (= GitHub). 