# ILU4 - TP Tests

## Objectifs

L'objectif de ces TPs et de faire des jeux de test sur l'algorithme de Bellman-Ford (algorithe du plus court chemin). On utilise la lib <b>JGraphT</b> pour l'implémentation des graphes ainsi que de l'algorithme de Bellman-Ford.

## Convention pour les jeux de tests

Nous cherchons le poid minimum dans un graphe notre script fonctionne de la manière suivante :

```
<nb_arrête>                     # le nombre d'arrête dans le graphe
<sommet-1> <sommet-2> <poid>
...
<sommet-n> <sommet-m> <poid>
<argument-1> <argument-2>       # deux sommets où on veut calculer le chemin le plus court
<reponse-attendu>               # reponse attendu après exécution de l'algorithme
```

Exemple:

```
5
A B 1
B C 2
A C 4
C D 1
B D 5
A D
4.0
```

## Authors

Vintrou (??) Mathéo  
Lagier Hadrien  