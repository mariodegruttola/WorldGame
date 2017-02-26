CREATE SCHEMA ecommerce;

USE ecommerce;

CREATE TABLE amministratore(
Email		CHAR(40) PRIMARY KEY,
Password	CHAR(30)
);

CREATE TABLE cliente(
Email		CHAR(40) PRIMARY KEY,
Password	CHAR(30),
CodFisc		CHAR(16),
Nome		CHAR(30),
Cognome		CHAR(30),
Indirizzo	CHAR(40),
Telefono	CHAR(10),
Citta		CHAR(40),
Cap			CHAR(10),
Provincia	CHAR(40),
NumeroCarta CHAR(16),
ScadenzaCarta DATE,
PinCarta CHAR(3)
);

CREATE TABLE spedizione(
Nome			CHAR(20) PRIMARY KEY,
Costi			INTEGER,
Stima_Consegna	INTEGER
);

CREATE TABLE ordine (
IdOrdine	INTEGER PRIMARY KEY AUTO_INCREMENT,
Data 		DATE,
Cliente		CHAR(40),
Spedizione	CHAR(20),
Pagamento	CHAR(20),
FOREIGN KEY (Cliente) REFERENCES cliente(Email) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (Spedizione) REFERENCES spedizione(Nome) ON DELETE CASCADE
);

CREATE TABLE prodotto(
IdProdotto	INTEGER PRIMARY KEY AUTO_INCREMENT,
Nome		CHAR(40),
Prezzo		FLOAT,
Quantita	INTEGER,
Tipo		CHAR(15),
Categoria	CHAR(20),
Descrizione	CHAR(255)
);

CREATE TABLE prodottoOrdine(
Ordine		INTEGER,
Prodotto	INTEGER,
Quantita	INTEGER,
Prezzo		FLOAT,
FOREIGN KEY(Ordine) REFERENCES ordine(IdOrdine) ON DELETE CASCADE,
FOREIGN KEY(Prodotto) REFERENCES prodotto(IdProdotto) ON DELETE CASCADE
);