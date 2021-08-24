# Tour Guide Clojure

CRUD Clojure Tour Guide Web app.

## Running the app

To start up the application first create a mysql database (name it *clojure-tour-guide*) and run *clojure-tour-guide.sql* script to create all the tables and insert data. 

Make sure to add database credentials by replacing ```<your-username>``` and ```<your-password>``` in the file ```/src/tour_guide_clojure/database.clj``` .

	
Then start the app in terminal using the command:

```console
lein ring server
```

The app will open in the following url: ```http://localhost:3000/``` .