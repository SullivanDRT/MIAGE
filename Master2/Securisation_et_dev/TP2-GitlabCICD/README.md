# Going Further Gitlab CICD

[[_TOC_]]

## Exercices
### Exercice 1 - création de groupes et projets Gitlab

Via Terraform (OpenTofu) et géré via un pipeline.

L'objectif est, via un projet Gitlab dédié, de gérer les différents groupes et projets nécessaires dans le scope d'un projet global (ici le TP).  
Nous allons ici nous concentrer uniquement sur la création de groupes et projets mais nous pourrions aller plus loin en gérant les règles de commit, les règles de merges, les membres, etc...

Pour cet exercice, et l'ensemble du TP, commencer par créer un nouveau groupe Gitlab et y créer un nouveau projet (par exemple, `Gitlab Management`).  
Dans ce projet, initialiser le repo avec ce dossier, ce cera votre point de travail central. Vous aurez besoin d'y revenir et d'en modifier la configuration afin de créer les nouveaux projets nécessaires.

Dans un premier temps, le but est de créer dans le groupe où se trouve le nouveau projet :
- Un groupe `Apps` et dans ce groupe :
  - Un projet `Java App`
- Un groupe `Infra`
- Un groupe `Tools`

>>> [!warning] Règles supplémentaires
- Respecter au mieux une modularisation propre au niveau de Terraform
- Les secrets doivent rester secrets
>>>

>>> [!note] Ressources intéressantes
- https://registry.terraform.io/providers/gitlabhq/gitlab/latest/docs
- https://gitlab.com/components/opentofu
>>>

### Exercice 2 - ajout du code du projet Java

En préambule des prochains exercices, nous allons reprendre le code du TP précédent afin de pouvoir l'utiliser dans notre nouveau contexte. Ajouter le code du TP précédent dans le projet `Java App`.  

### Exercice 3 - ajout d'un runner Gitlab

Afin de pouvoir faire la suite du TP, un runner Gitlab local sous Docker est nécessaire. Créer ce runner et ajouter le au groupe Gitlab au plus haut niveau.

>>> [!note] Ressources intéressantes
- https://docs.gitlab.com/runner/install/
>>>

### Exercice 4 - ajout de renovate

Afin de tenir à jour le projet Java dont les versions sont dépassées, plutôt que de le faire manuellement, nous allons mettre en place Renovate. Pour se faire :
- Créer un projet `renovate` dans le groupe `Tools`
- Ajouter Renovate sur ce projet et le configurer pour qu'il prenne en charge le projet `Java App`

>>> [!warning] Règle supplémentaire
- Le projet ne doit pas être créé manuellement mais via le code Terraform
>>>

>>> [!note] Ressources intéressantes
- https://docs.renovatebot.com/examples/self-hosting/#gitlab-cicd-pipeline
- https://gitlab.com/renovate-bot/renovate-runner
>>>

### Exercice 5 - modification de la méthode de merge des projets

Je préfère avoir des merges en fast-forward plutôt que la méthode par défaut afin de ne pas avoir de commit de merge.  
Nous allons donc modifier les méthodes de merge des projets `Java App` et `Renovate`. Mais sans modifier à la main les paramètres des projets, uniquement via la configuration Terraform.

### Exercice 6 - créer un cluster KinD en local

Le prochain exercice consistera à déployer l'application Java sur un Kubernetes. Pour se faire, nous allons donc avoir besoin de ce Kubernetes.  
Nous allons déployer un KinD en local. Le code Terraform nécessaire est disponible dans `kind/tofu`. Ce code est à exécuter directement là où est le Docker et le gitlab-runner. Mais ça ne veut pas dire qu'il ne faut pas versionner ce code et avoir une pipeline pour vérifier le bon fonctionnement.

De la même façon qu'auparavant, créer un projet `Kind Provisioning` dans le groupe `Infra`, y ajouter le code Terraform et créer une pipeline pour vérifier le bon déroulement sans exécuter le provisionnement.

### Exercice 7 - déployer l'application Java via la pipeline

Afin de terminer ce TP, nous allons mettre en place le "D" de CICD : "deploy". Le but sera d'utiliser une chart Helm ainsi que Terraform pour déployer sur le cluster KinD. À noter que cette combinaison Helm + Terraform n'est pas forcément à faire dans des cas réels, le mieux étant de choisir l'un ou l'autre. Gitlab est capable de gérer un déploiement de chart Helm.

Vous allez devoir modifier l'application Java afin d'y ajouter le code Terraform (incluant la chart Helm) fournie dans `java/tofu` et de rajouter une étape de déploiement, sur déclenchement manuel, dans la pipeline. Attention, la configuration du gitlab-runner devra être adaptée pour que celui-ci puisse accéder au cluster KinD, l'appel se faisant entre deux container Docker.
