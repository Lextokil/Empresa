CREATE TABLE funcionario (
	id_funcionario int(10) not null auto_incremeant primary key,
	nm_funcionario VARCHAR(100) not null,
	sl_funcionario DOUBLE(10,2) not null
)

CREATE TABLE gerente (
    id_gerente int(10) NOT NULL auto_incremeant primary key,
    id_funcionario int(10) NOT NULL,
    pw_gerente VARCHAR(50) not null,
    FOREIGN KEY (id_funcionario) REFERENCES funcionario(id_funcionario)
)

CREATE TABLE programador (
    id_programador int(10) NOT NULL auto_incremeant primary key,
    id_funcionario int(10) NOT NULL,
    lg_programador VARCHAR(50) not null,
    FOREIGN KEY (id_funcionario) REFERENCES funcionario(id_funcionario)
)

CREATE TABLE mecanico (
    id_mecanico int(10) NOT NULL auto_incremeant primary key,
    id_funcionario int(10) NOT NULL,
    st_mecanico VARCHAR(50) not null,
    FOREIGN KEY (id_funcionario) REFERENCES funcionario(id_funcionario)
)