/* CREATING DATABASE */
CREATE DATABASE empresa ;

/* SELECT DATABASE FOR THE NEXT COMMANDS */
USE empresa; 

/* ADD TABLE `FUNCIONARIO` */
CREATE TABLE funcionario (
	id_funcionario INT(10) not null primary key auto_increment,
	nm_funcionario VARCHAR(100) not null,
    sl_funcionario DOUBLE(10,2) not null,
	pw_gerente VARCHAR(50),
    lg_programador VARCHAR(100),
    st_mecanico VARCHAR(100),
    tp_funcionario VARCHAR(50) not null
) ;

/* ADD A FEW EMPLOYEES FOR THE @GET OPERATION */
INSERT INTO funcionario (nm_funcionario, sl_funcionario, pw_gerente, tp_funcionario)
				values("Luca Gerentão", 3543.30, "lucalokosenha", "gerente") ;

INSERT INTO funcionario (nm_funcionario, sl_funcionario, lg_programador, tp_funcionario)
				values("Luca Programador", 5540.20, "Java", "programador") ;
				
INSERT INTO funcionario (nm_funcionario, sl_funcionario, st_mecanico, tp_funcionario)
				values("Luca Mecanico", 2540.20, "Empilhadeiras", "mecanico") ;