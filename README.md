# Textbasiertes RPG "Exam Escape"
Ein Projekt in Advanced Software Engineering
## Einführung
### Übersicht über die Applikation

Die Applikation ist ein Rogue-like-RPG-Spiel, bei dem der Spieler aus drei Klassen wählen und gegen verschiedene Feinde in verschiedenen Stufen (Levels) kämpfen kann. Die Feinde sind von anderen Spielen stark inspiriert und das Spiel bietet eine textbasierte Spielerfahrung.

Die Funktionsweise der Applikation besteht darin, dass der Spieler eine Klasse wählt und dann in rundenbasierten Kämpfen gegen Feinde antritt. Jeder Feind hat einzigartige Fähigkeiten und Angriffe. Der Spieler kann sowohl normale Angriffe als auch spezielle Angriffe einsetzen, um den Feind zu besiegen. 

Es gibt drei verschiedene Level mit zufällig generierten Feinden. Jedes Mal, wenn der Spieler ein neues Level betritt, werden die Feinde zufällig ausgewählt.       

Die Würfel im Spiel werden verwendet, um zufällige Zahlen zu generieren und Entscheidungen im Spiel zu treffen. Zum Beispiel kann mit einem Würfelwurf entschieden werden, ob ein Feind seinen Spezialangriff einsetzt oder einen normalen Angriff durchführt. Darüber hinaus wird mithilfe der Würfel auch der Schaden ermittelt, den ein Angriff verursacht. Durch die Verwendung von Würfeln wird eine gewisse Unvorhersehbarkeit und Variation in den Spielverlauf gebracht.       

Die Applikation löst das Problem der Langeweile, indem sie eine zugängliche Spielerfahrung bietet. Das Spiel ist relativ einfach gehalten und wurde für Spaß und zur Unterhaltung entwickelt. Für Testzwecke und zur Einfachheit wurden die Schwierigkeit der Feinde und der Levels bewusst niedrig gehalten.
### Wie startet man die Applikation?       
Um die Anwendung zu starten, benötigt man IntelliJ IDEA und Maven. Die folgende Schritt-für-Schritt-Anleitung beschreibt den Installationsprozess:
1. Kopieren Sie das Projekt aus dem GitHub-Repository oder entpacken Sie die ZIP-Datei auf Ihrem Computer.
2. Öffnen Sie das Projekt in IntelliJ IDEA.
3. Führen Sie einen Maven-Build des Projekts durch. Dabei werden alle Abhängigkeiten heruntergeladen und alle Tests durchgelaufen.
4. Navigieren Sie im Projektbaum zur Klasse "StartGame" in dem Modul "x-global-ase-project" (Pfad: /IdeaProjects/ase-textbased-rpg/x-global-ase-project/src/main/java/ase/project/StartGame.java).
5. Klicken Sie mit der rechten Maustaste auf die Klasse "StartGame" und wählen Sie "Run", um das Spiel zu starten.

Das Spiel wird im Terminal gestartet und man erhält Anweisungen zur Steuerung des Spiels.

