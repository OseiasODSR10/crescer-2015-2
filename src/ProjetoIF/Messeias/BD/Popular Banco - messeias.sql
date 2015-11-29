
INSERT INTO Messeias.Usuario(nome, senha, tipo) VALUES ('Oseias', 'oss', 'Aluno');
INSERT INTO Messeias.Usuario(nome, senha, tipo) VALUES ('Marcos', 'mgr', 'Aluno');
INSERT INTO Messeias.Usuario(nome, senha, tipo) VALUES ('Bertolla', 'lb', 'Aluno');
INSERT INTO Messeias.Usuario(nome, senha, tipo) VALUES ('Jesus', 'lb', 'Aluno');
INSERT INTO Messeias.Usuario(nome, senha, tipo) VALUES ('Rodrigo Remor', 'mito', 'Professor');

INSERT INTO Messeias.Turma(nome) VALUES ('2I');
INSERT INTO Messeias.Turma(nome) VALUES ('2K');
INSERT INTO Messeias.Turma(nome) VALUES ('3I');
INSERT INTO Messeias.Turma(nome) VALUES ('3K');
INSERT INTO Messeias.Turma(nome) VALUES ('4K');
INSERT INTO Messeias.Turma(nome) VALUES ('4I');

INSERT INTO Messeias.usuario_turma(id_usuario, id_turma) VALUES (1, 1);
INSERT INTO Messeias.usuario_turma(id_usuario, id_turma) VALUES (2, 1);
INSERT INTO Messeias.usuario_turma(id_usuario, id_turma) VALUES (3, 1);
INSERT INTO Messeias.usuario_turma(id_usuario, id_turma) VALUES (4, 1);
INSERT INTO Messeias.usuario_turma(id_usuario, id_turma) VALUES (1, 2);

INSERT INTO Messeias.Avaliacao(id_avaliacao, tipo, data_avaliacao, conteudo, disciplina, id_turma, id_usuario) 
VALUES (null, 'Prova', '2015/11/23', 'Java + mysql', 'BD', 1, 5);
INSERT INTO Messeias.Avaliacao(id_avaliacao, tipo, data_avaliacao, conteudo, disciplina, id_turma, id_usuario) 
VALUES (null, 'Trabalho', '2015/11/30', 'Java + mysql 2', 'BD e LP', 2, 5);
INSERT INTO Messeias.Avaliacao(id_avaliacao, tipo, data_avaliacao, conteudo, disciplina, id_turma, id_usuario) 
VALUES (null, 'Teste', '2015/11/30', 'Um conteudo gigantesco do caralho pra ver se da merda com o layout que já está bosta', 'BD e LP', 1, 5);

INSERT INTO Messeias.Comentario(texto, id_usuario, id_avaliacao) VALUES ('Prova legal até...', 1, 1);
INSERT INTO Messeias.Comentario(texto, id_usuario, id_avaliacao) VALUES ('Prova lixosa by marcos!', 2, 1);
INSERT INTO Messeias.Comentario(texto, id_usuario, id_avaliacao) VALUES ('Prova muito legal!', 5, 1);

SELECT * FROM Messeias.Usuario;
SELECT * FROM Messeias.Usuario_Turma;
SELECT * FROM Messeias.Turma;
SELECT * FROM Messeias.Comentario;
SELECT * FROM Messeias.Avaliacao;