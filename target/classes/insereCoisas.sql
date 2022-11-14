use sistemavagas;


#insere usuario:
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

select * from usuario;
