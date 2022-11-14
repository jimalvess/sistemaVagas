use sistemavagas;

######## insere usuario:

INSERT INTO `sistemavagas`.`usuario` (
`id`, `nome`, `email`, `fone`, `logradouro`, `numero`, `complemento`, 
`bairro`, `localidade`, `uf`, `cep`, `descricao`, `foto`, `status`, `login`, `senha`,  
`permissoes`, `vagas`, `redesSociais`, `denuncias`, `mensagens`, `cpf`, `dataNasc`, `escolaridade`, 
`idiomas`, `competencias`, `fornecedor`, `cnpj`, `site`) 
VALUES ('1', 'laurindo', 'laurindo@guasca.com', '51985587878', 'rua feliz', '22', 'fundos', 
'alegria', 'roscavo do sul', 'rs', '95784520', 'lindo', 'linkfoto', true, 'laurindo', '12345', 
'adm', 3, 'orkutes', 2, '5', '66545878523', '20/12/2021', 'formado',  
'ingles', 'eita', false, '123', 'www.laurindo.com');

INSERT INTO `sistemavagas`.`usuario` (
`id`, `nome`, `email`, `fone`, `logradouro`, `numero`, `complemento`, 
`bairro`, `localidade`, `uf`, `cep`, `descricao`, `foto`, `status`, `login`, `senha`,  
`permissoes`, `vagas`, `redesSociais`, `denuncias`, `mensagens`, `cpf`, `dataNasc`, `escolaridade`, 
`idiomas`, `competencias`, `fornecedor`, `cnpj`, `site`) 
VALUES ('2', 'juca', 'juca@bala.com', '51235698778', 'rua triste', '422', 'frente', 
'alisblau', 'almeida prado', 'sp', '56989852', 'feio', 'linkfoto', true, 'juca', '12345',  
'adm', 2, 'orkutel', 1, 3, '225469874', '15/05/1960', 'conformado',  
'espanhol', 'eita pleura', true, '123', 'www.juca.com');

######## insere vagas:

INSERT INTO `sistemavagas`.`vagas` (`id`, `cargo`, `localidade`, `uf`, `dataInclusao`, `prazoCampo`, `valor`, `experienciaDesejada`, `descricao`) 
VALUES ('1', 'especialista', 'sao paulo', 'sp', '16/03/1969', 2, 0.30, 'saber lidar', 'descrition etc');

INSERT INTO `sistemavagas`.`vagas` (`id`, `cargo`, `localidade`, `uf`, `dataInclusao`, `prazoCampo`, `valor`, `experienciaDesejada`, `descricao`) 
VALUES ('1', 'naturalista', 'rio', 'rj', '18/12/1950', 1, 5.20, 'fritar ovo', 'mas que tal');

######## insere denuncia:

INSERT INTO `sistemavagas`.`denuncias` (`id`, `usuario`, `denunciante`, `denunciado`, `tipo`, `detalhe`) 
VALUES ('1', '1', '1', '2', 'ladroagem', 'metendo a mao');

INSERT INTO `sistemavagas`.`denuncias` (`id`, `usuario`, `denunciante`, `denunciado`, `tipo`, `detalhe`) 
VALUES ('2', '2', '2', '1', 'bagaceirada', 'fala nome feio');

######## insere mensagem:

INSERT INTO `sistemavagas`.`mensagens` (`id`, `usuario`, `assunto`, `detalhe`, `emissor`, `destinatario`) 
VALUES ('1', '1', 'duvida', 'nao entendi isso', '1', '2');

INSERT INTO `sistemavagas`.`mensagens` (`id`, `usuario`, `assunto`, `detalhe`, `emissor`, `destinatario`) 
VALUES ('2', '2', 'resposta', 'nem eu', '2', '1');

######## insere curriculo

INSERT INTO `sistemavagas`.`curriculo` (
`id`, `usuario`, `email`, `fone`, `logradouro`, `numero`, `complemento`, 
`bairro`, `localidade`, `uf`, `cep`, `descricao`, `foto`, `cpf`, `dataNasc`, `escolaridade`,  
`instituicao`, `tempoAtuacao`, `tecnologias`, `redesSociais`, `competencias`, `cnh`, `viagem`, `idiomas`) 
VALUES ('1', '1', 'lau@guasca.com', '51985587878', 'rua feliz', '22', 'fundos', 
'alegria', 'roscavo do sul', 'rs', '95784520', 'lindo', 'linkfoto', '55632862', '10/12/1965', '2 grau', 
'ifrs', 3, 'informatica', 'orkut.com.br', 'fala bem', '66545878523', true, 'ingles');

INSERT INTO `sistemavagas`.`curriculo` (
`id`, `usuario`, `email`, `fone`, `logradouro`, `numero`, `complemento`, 
`bairro`, `localidade`, `uf`, `cep`, `descricao`, `foto`, `cpf`, `dataNasc`, `escolaridade`,  
`instituicao`, `tempoAtuacao`, `tecnologias`, `redesSociais`, `competencias`, `cnh`, `viagem`, `idiomas`) 
VALUES ('2', '2', 'eita@pleura.com', '51548767878', 'rua triste', '44', 'casa', 
'tristeza', 'alvorada', 'rs', '53652520', 'feio', 'linkfoto', '54562162', '09/05/1990', '2 grau', 
'unimed', 2, 'medicina', 'facebook.com.br', 'faz miojo', '64256897523', false, 'espanhol');

######## insere postador, candidato e vaga em usuario_vagas:
######## usa duas queries até eu ver como se faz em uma:

UPDATE `sistemavagas`.`usuario_vagas` SET `postador` = /* pega id de quem criou a vaga pelo app */ 1 WHERE (`id` = 1);
UPDATE `sistemavagas`.`usuario_vagas` SET `candidato` = 2 WHERE (`id` = 1);
UPDATE `sistemavagas`.`usuario_vagas` SET `vagas` = 2 WHERE (`id` = 1);

######## Adiciona campos em tabelas:

ALTER TABLE vagas ADD prazoPagto int AFTER prazoCampo;

######## seleciona tudo:

select * from usuario;
select * from vagas;
select * from denuncias;
select * from mensagens;
select * from curriculo;
select * from usuario_vagas;

######## seleciona pela id:

select * from usuario where id = 1;
select * from vagas where id = 1;
select * from denuncias where id = 1;
select * from mensagens where id = 1;
select * from curriculo where id = 1;
select * from usuario_vagas where id = 1;
select * from usuario_denuncias where id = 1;
select * from usuario_mensagens where id = 1;
select * from usuario_mensagens;

######## OBS: vou remover as tabelas auxiliares e deixar só a usuario_vagas.
######## é que em denuncias e mensagens dá pra fazer um select
######## de denunciante, denunciado, etc, dentro delas mesmo.
######## já na usuario vagas eu guardo 3 campos pra usar em selects
######## EX: só meter um select all vagas where candidato ou postador = id dele
######## A busca vai ser sempre pela id destes caras pq as ids de vagas são muitas, mas
######## quem postou ou se candidatou vai ser um unico campo em cada uma delas

######## OBS: denuncias e mensagens vao ser inseridas pelo app pegando a id de quem denuncia e a id de quem é denunciado
########  a mesma coisa se dá em mensagens


