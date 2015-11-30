USE Messeias;
SELECT * FROM Messeias.Usuario;
SELECT * FROM Messeias.Usuario_Turma;
SELECT * FROM Messeias.Turma;
SELECT * FROM Messeias.Comentario;
SELECT * FROM Messeias.Avaliacao;

INSERT INTO Turma(nome) VALUES ('2I');
INSERT INTO Turma(nome) VALUES ('4K');

UPDATE Messeias.Turma SET nome = '2I' WHERE id_turma = 1;

DELETE FROM Messeias.Turma WHERE id_turma = 3 AND nome = '2YYY';

DELETE FROM Messeias.Usuario WHERE id_usuario > 5;


INSERT INTO Messeias.Avaliacao(id_avaliacao, tipo, data_avaliacao, conteudo, disciplina, id_turma, id_usuario) VALUES (null, 'Prova', '2015/11/23', 'Java + mysql', 'BD', 1, 5);
UPDATE Messeias.Avaliacao SET data_avaliacao = '2015/11/23' WHERE id_avaliacao = 1;

INSERT INTO usuario_turma(id_usuario, id_turma) VALUES (1, 1);
INSERT INTO usuario_turma(id_usuario, id_turma) VALUES (2, 1);
INSERT INTO usuario_turma(id_usuario, id_turma) VALUES (3, 1);
INSERT INTO usuario_turma(id_usuario, id_turma) VALUES (4, 1);
INSERT INTO usuario_turma(id_usuario, id_turma) VALUES (1, 2);

INSERT INTO Messeias.Comentario(texto, id_usuario, id_avaliacao) VALUES ('Prova lixo!', 1, 1);
INSERT INTO Messeias.Comentario(texto, id_usuario, id_avaliacao) VALUES ('Prova lixosa by marcos!', 2, 1);
INSERT INTO Messeias.Comentario(texto, id_usuario, id_avaliacao) VALUES ('Prova muito legal!', 5, 1);

SELECT a.id_aluno, a.nome FROM Aluno a INNER JOIN aluno_turma a_t ON a_t.id_aluno = a.id_aluno WHERE a_t.id_turma = 1;

SELECT u.id_usuario, u.nome, u.tipo FROM Usuario_turma u_t RIGHT JOIN Usuario u ON u.id_usuario = u_t.id_usuario WHERE u_t.id_turma = 1;


SELECT a.id_avaliacao, a.tipo, a.data_avaliacao, a.conteudo, a.disciplina, a.id_turma, t.nome, a.id_Usuario, p.nome, cm.texto, u_cm.Nome
FROM Messeias.Avaliacao a 
INNER JOIN Messeias.Usuario p ON a.id_Usuario = p.id_Usuario 
INNER JOIN Messeias.Turma t ON t.id_turma = a.id_turma 
RIGHT JOIN Messeias.Comentario cm ON cm.Id_Avaliacao = a.Id_Avaliacao 
LEFT JOIN Messeias.Usuario u_cm ON cm.Id_Usuario = u_cm.Id_Usuario 
WHERE t.id_turma = 1;

SELECT u.id_Usuario, u.nome, u.senha, u.tipo, t.id_Turma, t.Nome FROM Messeias.Usuario u LEFT JOIN Messeias.usuario_turma us ON us.Id_Usuario = u.Id_Usuario INNER JOIN Messeias.turma t ON t.Id_Turma = us.Id_Turma WHERE u.id_usuario = 1;






















