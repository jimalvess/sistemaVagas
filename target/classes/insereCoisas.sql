use sistemavagas;


#insere usuario:
INSERT INTO `sistemavagas`.`usuario` (
`id`, `nome`, `email`, `tel1`, `tel2`, `logradouro`, `numero`, `complemento`, 
`bairro`, `localidade`, `uf`, `cep`, `nivel`, `descricao`, `foto`, `status`, `login`, `senha`, `novaSenha`, 
`permissoes`, `token`, `vagas`, `redesSociais`, `denuncias`, `mensagens`, `cpf`, `dataNasc`, `escolaridade`, 
`tempoAtuacao`, `idiomas`, `tecnologias`, `competencias`, `fornecedor`, `cnpj`, `site`, `representante`) 
VALUES ('1', 'laurindo', 'laurindo@guasca.com', '51985587878', '51959585654', 'rua feliz', '22', 'fundos', 
'alegria', 'roscavo do sul', 'rs', '95784520', '2', 'lindo', 'linkfoto', 5, 'laurindo', '12345', '12345', 
'adm', 'tokxxxxxxx', 'sem vaga', 'orkutes', 'sem denuncia', 'sem mensagem', '66545878523', '20/12/2021', 'formado',  
'2', 'ingles', 'joga damas', 'eita', false, '123', 'www.laurindo.com', false);

select * from usuario;