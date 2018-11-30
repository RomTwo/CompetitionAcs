all: compile

compile:
	@javac Ihm/Admin/*.java Ihm/Client/*.java Classe/*.java Contrat/*.java Lanceur/*.java

server:
	@java Lanceur/Server

client1:
	@java Lanceur/Client 127.0.0.1 Romain

client2:
	@java Lanceur/Client 127.0.0.1 Mathieu

client3:
	@java Lanceur/Client 127.0.0.1 Didier

admin:
	@java Lanceur/Admin 127.0.0.1

clean:
	@rm Ihm/Admin/*.class 
	@rm Ihm/Client/*.class 
	@rm Classe/*.class
	@rm Contrat/*.class 
	@rm Lanceur/*.class