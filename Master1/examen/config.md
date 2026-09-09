
## Config Docker Postgres

Création du dossier

```bash
mkdir -p $HOME/postgres-share/
```

On lance le container en pointant sur le posteshare :

```bash
docker run --name postgres-tp -e POSTGRES_PASSWORD=postgres -v $HOME/postgres share/:/tmp/postgres -p 5432:5432 -d postgres
```

Mettre les fichiers dans le dossier **postgres-share**.


Commande pour aller dans le container :

```bash
docker exec -it postgres-tp bash
```

Commande pour entrer dans postgres :

```bash
psql -h localhost -U postgres
```

Commande de création de la database :

```sql
create database tpl1;
\c tpl1
```

Importer les fichiers excels pour insertions bdd :

```sql
copy table from '/tmp/postgres/nom_fichier_excel_table.csv' with (format 'csv', header);
```

## Création index



