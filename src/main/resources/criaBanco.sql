CREATE DATABASE `sistemaVagas`;
USE sistemaVagas;

CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(60) NOT NULL,
  `email` varchar(60) NOT NULL,
  `fone` varchar(15) NOT NULL,
  `logradouro` varchar(60) NOT NULL,
  `numero` varchar(6),
  `complemento` varchar(10),
  `bairro` varchar(25) NOT NULL,
  `localidade` varchar(25) NOT NULL,
  `uf` varchar(2) NOT NULL,
  `cep` varchar(10),
  `descricao` varchar(400),
  `foto` varchar(255),
  `status` boolean, 					
  `login` varchar(30) NOT NULL,
  `senha` varchar(10) NOT NULL,
  `permissoes` varchar(255),
  `vagas` int, 						
  `redesSociais` varchar(100),
  `denuncias` int, 					
  `mensagens` int, 					
  `cpf` varchar(15),
  `dataNasc` varchar(10) NOT NULL,
  `escolaridade` varchar(30) NOT NULL,
  `idiomas` varchar(100),
  `competencias` varchar(300),
  `fornecedor` boolean,
  `cnpj` varchar(20),
  `site` varchar(100),
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`nome`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

CREATE TABLE `vagas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cargo` varchar(128) NOT NULL,
  `localidade` varchar(25) NOT NULL,
  `uf` varchar(2) NOT NULL,
  `dataInclusao` varchar(10),
  `prazoCampo` int,
  `valor` float,
  `experienciaDesejada` varchar(300),
  `descricao` varchar(400) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

CREATE TABLE `usuario_vagas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `usuario` INT NOT NULL,
  `postador` INT NOT NULL,
  `candidato` INT NOT NULL,
  `vagas` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

CREATE TABLE `denuncias` (
  `id` int NOT NULL AUTO_INCREMENT,
  `usuario` int,
  `denunciante` varchar(60) NOT NULL,
  `denunciado` varchar(60) NOT NULL,
  `tipo` varchar(128) NOT NULL,
  `detalhe` varchar(400),
  PRIMARY KEY (`id`),
  FOREIGN KEY `usuario_fk` (`usuario`) REFERENCES `usuario` (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

CREATE TABLE `mensagens` (
  `id` int NOT NULL AUTO_INCREMENT,
  `usuario` int,
  `assunto` varchar(100),
  `detalhe` varchar(400) NOT NULL,
  `emissor` varchar(60) NOT NULL,
  `destinatario` varchar(60) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY `usuario_fk` (`usuario`) REFERENCES `usuario` (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

CREATE TABLE `curriculo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `usuario` int,
  `email` varchar(20),
  `fone` varchar(15),
  `logradouro` varchar(60),
  `numero` varchar(6),
  `complemento` varchar(10),
  `bairro` varchar(25),
  `localidade` varchar(25),
  `uf` varchar(2),
  `cep` varchar(10),
  `descricao` varchar(400),
  `foto` varchar(255),
  `cpf` varchar(15),
  `dataNasc` varchar(10),
  `escolaridade` varchar(30),
  `instituicao` varchar(30),
  `tempoAtuacao` varchar(250),
  `tecnologias` varchar(250),
  `redesSociais` varchar(250),
  `competencias` varchar(300),
  `cnh` varchar(20),
  `viagem` boolean,
  `idiomas` varchar(100),
  PRIMARY KEY (`id`),
  FOREIGN KEY `usuario_fk` (`usuario`) REFERENCES `usuario` (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

