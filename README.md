# ILU4 - TP Tests

## Objectifs

L'objectif de ces TPs et de faire des jeux de test sur l'algorithme de Bellman-Ford (algorithe du plus court chemin). Les fichiers .txt sont la réponse aux questions du sujet dans le TP. Les fichiers Mutant1.java , Mutant2.java et Mutant3.java sont nos mutants créer lors de la question 6 (cf. le pdf de réponse).

## Convention pour les jeux de tests

Nous cherchons le poid minimum dans un graphe notre script de test fonctionne de la manière suivante :

```
<nb_sommets>                    # le nombre de sommets
<nb_arrête>                     # le nombre d'arrête dans le graphe
<sommet-1> <sommet-2> <poid>
...
<sommet-n> <sommet-m> <poid>
<argument-1> <argument-2>       # deux sommets où on veut calculer le chemin le plus court
<reponse-attendu>               # reponse attendu après exécution de l'algorithme
```

Exemple:

```
4
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

Vintrou Mathéo  
Lagier Hadrien  