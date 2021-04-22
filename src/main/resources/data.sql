INSERT INTO USUARIO(nome, email, senha) VALUES('Aluno', 'aluno@email.com', '$2a$10$vaw4bIOWl4//QpuWS9JAKOqQQoF8HHmD3mShLEVhwa5TcZxzVQ.E.');
INSERT INTO USUARIO(nome, email, senha) VALUES('Moderador', 'moderador@email.com', '$2a$10$vaw4bIOWl4//QpuWS9JAKOqQQoF8HHmD3mShLEVhwa5TcZxzVQ.E.');

INSERT INTO PERFIL(id,nome) values (1,'ROLE_ALUNO');
INSERT INTO PERFIL(id,nome) values (2,'ROLE_MODERADOR');

INSERT INTO USUARIO_PERFIS(usuario_id,perfis_id) values (1,1);
INSERT INTO USUARIO_PERFIS(usuario_id,perfis_id) values (2,2);



INSERT INTO CURSO(nome, categoria) VALUES('Spring Boot', 'Programação');
INSERT INTO CURSO(nome, categoria) VALUES('HTML 5', 'Front-end');

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('B Dúvida 1', 'Projeto não compila', '2021-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('C Dúvida 2', 'Erro ao criar projeto', '2019-05-05 19:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('A Dúvida 3', 'Tag HTML', '2018-05-05 20:00:00', 'NAO_RESPONDIDO', 1, 2);
