CREATE DATABASE `sistemaVagas`;
USE sistemaVagas;

CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(128) NOT NULL,
  `email` varchar(128) NOT NULL,
  `tel1` varchar(11),
  `tel2` varchar(11),
  `logradouro` varchar(128),
  `numero` int(6),
  `complemento` varchar(128),
  `bairro` varchar(128),
  `localidade` varchar(128),
  `uf` varchar(2),
  `cep` varchar(8),
  `nivel` int(2),
  `descricao` varchar(250),
  `foto` varchar(250),
  `status` boolean,
  `login` varchar(128),
  `senha` varchar(11) NOT NULL,
  `novaSenha` varchar(11),
  `permissoes` varchar(11),
  `token` varchar(11),
  `vagas` varchar(100),
  `redesSociais` varchar(100),
  `denuncias` varchar(100),
  `mensagens` varchar(100),
  `cpf` varchar(11),
  `dataNasc` varchar(10),
  `escolaridade` varchar(30),
  `tempoAtuacao` varchar(10),
  `idiomas` varchar(100),
  `tecnologias` varchar(250),
  `competencias` varchar(100),
  `fornecedor` boolean,
  `cnpj` varchar(20),
  `site` varchar(100),
  `representante` boolean,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`nome`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

CREATE TABLE `vagas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cargo` varchar(128) NOT NULL,
  `localidade` varchar(128) NOT NULL,
  `uf` varchar(2) NOT NULL,
  `dataInclusao` date NOT NULL,
  `prazoCampo` int(128) NULL,
  `valor` long,
  `experienciaDesejada` varchar(128),
  `descricao` varchar(250) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

CREATE TABLE `usuario_vagas` (
  `usuario` INT NOT NULL,
  `vagas` INT NOT NULL,
  PRIMARY KEY (`usuario`, `vagas`),
    CONSTRAINT `Constr_usuario_vagas_usuario_fk`
        FOREIGN KEY `usuario_fk` (`usuario`) REFERENCES `usuario` (`id`)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `Constr_usuario_vagas_vagas_fk`
        FOREIGN KEY `vagas_fk` (`vagas`) REFERENCES `vagas` (`id`)
        ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

CREATE TABLE `denuncia` (
  `id` int NOT NULL AUTO_INCREMENT,
  `usuario` INT NOT NULL,
  `denunciante` varchar(128) NOT NULL,
  `denunciado` varchar(128) NOT NULL,
  `tipo` varchar(128) NOT NULL,
  `detalhe` varchar(128),
  PRIMARY KEY (`id`),
  FOREIGN KEY `usuario_fk` (`usuario`) REFERENCES `usuario` (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

CREATE TABLE `mensagem` (
  `id` int NOT NULL AUTO_INCREMENT,
  `usuario` INT NOT NULL,
  `assunto` INT NOT NULL,
  `detalhe` varchar(128) NOT NULL,
  `emissor` varchar(128) NOT NULL,
  `destinatario` varchar(128) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY `usuario_fk` (`usuario`) REFERENCES `usuario` (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

CREATE TABLE `curriculo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `usuario` INT NOT NULL,
  `tel1` varchar(11),
  `tel2` varchar(11),
  `logradouro` varchar(128),
  `numero` int(6),
  `complemento` varchar(128),
  `bairro` varchar(128),
  `localidade` varchar(128),
  `uf` varchar(2),
  `cep` varchar(8),
  `descricao` varchar(250),
  `cpf` varchar(11),
  `dataNasc` varchar(10),
  `escolaridade` varchar(30),
  `instituicao` varchar(30),
  `tempoAtuacao` varchar(10),
  `vagas` varchar(250),
  `tecnologias` varchar(250),
  `redesSociais` varchar(250),
  `competencias` varchar(10),
  `cnh` varchar(20),
  `viagem` boolean,
  `idiomas` varchar(250),
  PRIMARY KEY (`id`),
  FOREIGN KEY `usuario_fk` (`usuario`) REFERENCES `usuario` (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;