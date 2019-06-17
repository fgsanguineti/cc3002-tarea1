# CC3002 - PokemonTCG Game - Homework 2

This is the Homework 2 project, developed using the Java 1.8 SDK, and continued from the old Homework 1 project.
Includes all the files that implements the requested for this work. Here, you can see the UML Java class diagram.
Please refers to the full file "uml_diagram.png" in the GitHub repo root directory for a better view.

![Alt text](uml_diagram.jpg "UML")

## Diseño

Para implementar lo solicitado en esta entrega, se utilizaron tres de los patrones de diseño vistos en clase:
Visitor, Template y NullObject.

### Visitor

Se utilizó el patrón de diseño Visitor para implementar, de partida, la desambiguación al jugar cada tipo de carta presenten en el juego:
TrainerCard, PokemonCards y EnergyCards y en particulara para cada subtipo de ellos, puesto que tienen funcionamientos distintos.

Además, se extendió el double dispatch realizado en la entrega anterior: sigue funcionando para desambiguar los tipos de los ataques, 
pero además ahora es capaz de desambiguar entre ataques y habilidades. También se utilizó para implementar la StadiumCard Frozen City.

Otra habilidad implementada utilizando Visitor fue el Energy Burn.

Todos los Visitor se encuentran en la subcarpeta Visitor y están debidamente testeados, cada uno de ellos en la carpeta de Testing.

### Template

Se utilizó el Template en casi toda la estructura de diseño de las cartas, fundamentalmente en los Pokemon.
A propósito de esto, se actualizó la estructura de todos los Pókemon: si bien antes contábamos con sólo un Pókemon para cada tipo,
ahora, para implementar las evoluciones, tenemos un BasicPokemon, un PhaseOnePokemon y un PhaseTwoPokemon, implementado según los requerimientos de la tarea.

### NullObject

Para no tener problemas en consultar por null o obtener  NullPointerException fundamentalmente, se implementaron NullAbility y NullEffect.



## Testing

The testing was made using JUnit 4.18 for the unit tests, reaching 100% of line coverage. 
To run all the test, import the git project to your machine, open with IntelliJ Ultimate, 
go to test folder, righ-click and select "Run 'All Test' with Coverage". All the 108 test will pass.

## Authors

* **F. Giovanni Sanguineti** - *Universidad de Chile* - [git repo](https://github.com/fgsanguineti/)



