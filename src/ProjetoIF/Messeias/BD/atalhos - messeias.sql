USE messeias;

SELECT * FROM Usuario;
SELECT * FROM Usuario_Turma;
SELECT * FROM Professor;
SELECT * FROM Turma;
SELECT * FROM Comentario;
SELECT * FROM Avaliacao;

INSERT INTO Usuario(nome, senha, tipo) VALUES ('Oseias', 'oss', 'Aluno');
INSERT INTO Usuario(nome, senha, tipo) VALUES ('Marcos', 'mgr', 'Aluno');
INSERT INTO Usuario(nome, senha, tipo) VALUES ('Bertolla', 'lb', 'Aluno');
INSERT INTO Usuario(nome, senha, tipo) VALUES ('Jesus', 'lb', 'Aluno');

INSERT INTO Usuario(nome, senha, tipo) VALUES ('Rodrigo Remor', 'mito', 'Professor');

INSERT INTO Turma(nome) VALUES ('2I');
INSERT INTO Turma(nome) VALUES ('4K');
UPDATE Messeias.Turma SET nome = '2I' WHERE id_turma = 1;
DELETE FROM Messeias.Turma WHERE id_turma = 3 AND nome = '2YYY';
SELECT id_turma, nome FROM Messeias.Turma;

INSERT INTO Messeias.Avaliacao(id_avaliacao, tipo, data_avaliacao, conteudo, disciplina, id_turma, id_professor) VALUES (null, 'Prova', '2015/11/23', 'Java + mysql', 'BD', 1, 1);
UPDATE Messeias.Avaliacao SET data_avaliacao = '2015/11/23' WHERE id_avaliacao = 1;

INSERT INTO usuario_turma(id_usuario, id_turma) VALUES (1, 1);
INSERT INTO usuario_turma(id_usuario, id_turma) VALUES (2, 1);
INSERT INTO usuario_turma(id_usuario, id_turma) VALUES (3, 1);
INSERT INTO usuario_turma(id_usuario, id_turma) VALUES (4, 1);
INSERT INTO usuario_turma(id_usuario, id_turma) VALUES (1, 2);

INSERT INTO Messeias.Comentario(texto, id_aluno, id_professor, id_avaliacao) VALUES ('Prova lixo!', 1, null, 3);

SELECT a.id_aluno, a.nome FROM Aluno a INNER JOIN aluno_turma a_t ON a_t.id_aluno = a.id_aluno WHERE a_t.id_turma = 1;

SELECT u.id_usuario, u.nome, u.tipo FROM Usuario_turma u_t RIGHT JOIN Usuario u ON u.id_usuario = u_t.id_usuario WHERE u_t.id_turma = 1;


SELECT a.id_avaliacao, a.tipo, a.data_avaliacao, a.conteudo, a.disciplina, a.id_turma, t.nome, a.id_professor, p.nome, c.texto, c.id_aluno, ac.nome, c.id_professor, pc.nome 
FROM Messeias.Avaliacao a
INNER JOIN Messeias.Professor p ON a.id_professor = p.id_professor 
INNER JOIN Messeias.Turma t ON t.id_turma = a.id_turma 
INNER JOIN Messeias.Comentario c ON c.id_avaliacao = a.id_avaliacao
LEFT JOIN Messeias.Professor pc ON c.id_professor = pc.id_professor
LEFT JOIN Messeias.Aluno ac ON c.id_aluno = ac.id_aluno;























